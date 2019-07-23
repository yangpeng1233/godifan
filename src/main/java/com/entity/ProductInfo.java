package com.entity;

import java.io.Serializable;

public class ProductInfo implements Serializable{
    private Integer pid;

    private String productid;

    private String productname;

    private Integer productprice;

    private Integer iscanbuy;

    private Integer productnum;

    private String producttaste;

    private Integer seriesid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public Integer getProductprice() {
        return productprice;
    }

    public void setProductprice(Integer productprice) {
        this.productprice = productprice;
    }

    public Integer getIscanbuy() {
        return iscanbuy;
    }

    public void setIscanbuy(Integer iscanbuy) {
        this.iscanbuy = iscanbuy;
    }

    public Integer getProductnum() {
        return productnum;
    }

    public void setProductnum(Integer productnum) {
        this.productnum = productnum;
    }

    public String getProducttaste() {
        return producttaste;
    }

    public void setProducttaste(String producttaste) {
        this.producttaste = producttaste == null ? null : producttaste.trim();
    }

    public Integer getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(Integer seriesid) {
        this.seriesid = seriesid;
    }


    @Override
    public String toString() {
        return "ProductInfo{" +
                "pid=" + pid +
                ", productid='" + productid + '\'' +
                ", productname='" + productname + '\'' +
                ", productprice=" + productprice +
                ", iscanbuy=" + iscanbuy +
                ", productnum=" + productnum +
                ", producttaste='" + producttaste + '\'' +
                ", seriesid=" + seriesid +
                '}';
    }
}