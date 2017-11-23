package com.xawl.travel.pojo;

public class BusinessDevice {
    private String did;

    private String bid;

    public String getDid() {return did;}

    public void setDid(String did) {this.did = did== null ? null : did.trim();}

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {this.bid = bid == null ? null : bid.trim();}
}