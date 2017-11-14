package com.xawl.travel.pojo;

public class BusinessKeepsake {
    private String kid;

    private String bid;

    private String imgPath;

    private String info;

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid == null ? null : kid.trim();
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}