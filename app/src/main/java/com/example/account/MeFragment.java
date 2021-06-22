package com.example.account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Objects;


/**
 * @author
 * @last_modified_time
 * @description 我的
 */
public class MeFragment extends Fragment {
    ListView listView;

    @Override
    public void onStart() {
        super.onStart();
        initView();
    }

    private void initView() {
        listView = Objects.requireNonNull(getView()).findViewById(R.id.lv_demo);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_me, container, false);
    }
}