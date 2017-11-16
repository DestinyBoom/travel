package com.xawl.travel.pojo;

public class Business {
    //商家主键id,自定规则生成的ID10位数字,用于商家的主键,商家登录使用的账号
    private String bid;
    //商家名称如:'**游乐场'
    private String bname;
    //商家地理位置的纬度
    private String latitude;
    //商家地理位置的经度
    private String longitude;
    //商家地址,注册商家时的必填项
    private String address;
    //商家等级,如;'4A级景区'
    private String level;
    //是否停用商家,默认不停用0
    private Boolean isUse;
    //图片
    private String image;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Boolean getIsUse() {
        return isUse;
    }

    public void setIsUse(Boolean isUse) {
        this.isUse = isUse;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}