package com.example.account.entity;

public class UserBean {

    /**
     * id : 1
     * userName : 梅盛珂
     * phoneNumber : 15187091901
     * avatarUrl : test_url
     * cpassword : 654321
     */

    private Long id;
    private String userName;
    private String phoneNumber;
    private String avatarUrl;
    private String cpassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
}
