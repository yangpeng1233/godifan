package com.entity;

import java.io.Serializable;

public class ShopStore implements Serializable{
    private Integer storeid;

    private Integer shopId;

    private String productid;

    private Integer storenum;

    private Integer sales;

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public Integer getStorenum() {
        return storenum;
    }

    public void setStorenum(Integer storenum) {
        this.storenum = storenum;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}