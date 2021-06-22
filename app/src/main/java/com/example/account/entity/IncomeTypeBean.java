package com.example.account.entity;

public class IncomeTypeBean {
    /**
     * id : 1
     * imageUrl : test_url
     * crank : 1
     * cname : 测试收入
     * cremove : false
     */

    private int id;
    private String imageUrl;
    private int crank;
    private String cname;
    private boolean cremove;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCrank() {
        return crank;
    }

    public void setCrank(int crank) {
        this.crank = crank;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public boolean isCremove() {
        return cremove;
    }

    public void setCremove(boolean cremove) {
        this.cremove = cremove;
    }
}
