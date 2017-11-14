package com.xawl.travel.pojo;

import java.util.Date;

public class User {
    private String uid;

    private String phone;

    private String account;

    private Date signinTime;

    private String pass;

    private String sex;

    private String headImgPath;

    private Boolean isAct;

    private Boolean isdel;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getHeadImgPath() {
        return headImgPath;
    }

    public void setHeadImgPath(String headImgPath) {
        this.headImgPath = headImgPath == null ? null : headImgPath.trim();
    }

    public Boolean getIsAct() {
        return isAct;
    }

    public void setIsAct(Boolean isAct) {
        this.isAct = isAct;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }
}