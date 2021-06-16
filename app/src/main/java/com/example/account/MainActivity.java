package com.example.account;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Field;

/**
 * @author 梅盛珂
 * @last_modified_time 2021年06月14日08:32:33
 * @description 主页面
 */

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener , View.OnClickListener {
    private BottomNavigationView bottomNavigationView;
    private DetailFragment detailFragment;
    private MeFragment meFragment;
    private PropertyFragment propertyFragment;
    private StatisticsFragment statisticsFragment;
    private Fragment[] fragments;

    private FloatingActionButton fabtnAddEntry;
    private int lastFragment ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }
    private void initView(){
        bottomNavigationView = findViewById(R.id.bnv_menu);
        removeNavigationShiftMode(bottomNavigationView);
        detailFragment = new DetailFragment();
        meFragment = new MeFragment();
        propertyFragment = new PropertyFragment();
        statisticsFragment = new StatisticsFragment();
        fragments = new Fragment[]{detailFragment,meFragment,propertyFragment,statisticsFragment};
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main,detailFragment).show(detailFragment).commit();
        fabtnAddEntry = findViewById(R.id.fabtn_add_entry);
    }

    private void initListener(){
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        fabtnAddEntry.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fabtn_add_entry:
                Intent intent = new Intent(getApplicationContext(),AddNewEntryActivity.class);
                startActivity(intent);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mb_item_detail:
                if(lastFragment != 0){
                    switchFragment(lastFragment,0);
                    lastFragment = 0;
                }
                return true;
            case R.id.mb_item_statistics:
                if(lastFragment != 3){
                    switchFragment(lastFragment,3);
                    lastFragment = 3;
                }
                return true;
            case R.id.mb_item_property:
                if(lastFragment!=2){
                    switchFragment(lastFragment,2);
                    lastFragment = 2;
                }
                return true;
            case R.id.mb_item_me:
                if(lastFragment!=1){
                    switchFragment(lastFragment,1);
                    lastFragment = 1;
                }
                return true;
            default:
                return false;
        }
    }

    /**
     * 消除底部导航控件切换item时的动画
     * @param view 底部导航控件
     */
    @SuppressLint("RestrictedApi")
     void removeNavigationShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        menuView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        menuView.buildMenuView();
    }

    /**
     * 用于切换主界面的fragment
     * @param lastFragment 上一个fragment
     * @param index 切换fragment的索引
     */
    private void switchFragment(int lastFragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastFragment]);//隐藏上个Fragment
        if(!fragments[index].isAdded())
        {
            transaction.add(R.id.fl_main,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

}

