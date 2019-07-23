package com.entity;

import java.io.Serializable;
import java.util.Date;

public class Gdv_Orderlist implements Serializable{
    private Integer oid;

    private String orederid;

    private String orederimg;

    private Date paytime;

    private Integer orderstate;

    private Float ordercost;

    private String orderremark;

    private Integer userId;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOrederid() {
        return orederid;
    }

    public void setOrederid(String orederid) {
        this.orederid = orederid == null ? null : orederid.trim();
    }

    public String getOrederimg() {
        return orederimg;
    }

    public void setOrederimg(String orederimg) {
        this.orederimg = orederimg == null ? null : orederimg.trim();
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    public Float getOrdercost() {
        return ordercost;
    }

    public void setOrdercost(Float ordercost) {
        this.ordercost = ordercost;
    }

    public String getOrderremark() {
        return orderremark;
    }

    public void setOrderremark(String orderremark) {
        this.orderremark = orderremark == null ? null : orderremark.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}