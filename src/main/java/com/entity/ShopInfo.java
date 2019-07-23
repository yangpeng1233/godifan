package com.entity;
 import java.io.Serializable;
 import java.util.*;
public class ShopInfo implements Serializable{
    private Integer shopid;

    private String shopname;

    private String shopcity;

    private String shopaddress;

    private Long shopphonenum;

    private String worktime;

    private String bossname;

    private Long bossphonenum;

    private  List<ShopStore> store;

    public Integer getShopid() {

        return shopid;
    }

    public void setShopid(Integer shopid) {

        this.shopid = shopid;
    }

    public String getShopname() {

        return shopname;
    }

    public void setShopname(String shopname) {

        this.shopname = shopname == null ? null : shopname.trim();
    }

    public String getShopcity() {

        return shopcity;
    }

    public void setShopcity(String shopcity) {

        this.shopcity = shopcity == null ? null : shopcity.trim();
    }

    public String getShopaddress() {

        return shopaddress;
    }

    public void setShopaddress(String shopaddress) {
        this.shopaddress = shopaddress == null ? null : shopaddress.trim();
    }

    public Long getShopphonenum() {

        return shopphonenum;
    }

    public void setShopphonenum(Long shopphonenum) {

        this.shopphonenum = shopphonenum;
    }

    public String getWorktime() {

        return worktime;
    }

    public void setWorktime(String worktime) {

        this.worktime = worktime == null ? null : worktime.trim();
    }

    public String getBossname() {

        return bossname;
    }

    public void setBossname(String bossname) {

        this.bossname = bossname == null ? null : bossname.trim();
    }

    public Long getBossphonenum() {

        return bossphonenum;
    }

    public void setBossphonenum(Long bossphonenum) {

        this.bossphonenum = bossphonenum;
    }


    public List<ShopStore> getStore() {
        return store;
    }

    public void setStore(List<ShopStore> store) {
        this.store = store;
    }


    public String toString() {
        return "ShopInfo{" +
                "shopid=" + shopid +
                ", shopname='" + shopname + '\'' +
                ", shopcity='" + shopcity + '\'' +
                ", shopaddress='" + shopaddress + '\'' +
                ", shopphonenum=" + shopphonenum +
                ", worktime='" + worktime + '\'' +
                ", bossname='" + bossname + '\'' +
                ", bossphonenum=" + bossphonenum +
                ", store=" + store +
                '}';
    }
}