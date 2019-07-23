package com.entity;

import java.io.Serializable;

public class ProductImg implements Serializable{
    private Integer imgid;

    private String imgname;

    private String imgsrc;

    private Integer imgbig;

    private String productId;

    public Integer getImgid() {
        return imgid;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname == null ? null : imgname.trim();
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc == null ? null : imgsrc.trim();
    }

    public Integer getImgbig() {
        return imgbig;
    }

    public void setImgbig(Integer imgbig) {
        this.imgbig = imgbig;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId == null ? null : productId.trim();
    }


    public String toString() {
        return "ProductImg{" +
                "imgid=" + imgid +
                ", imgname='" + imgname + '\'' +
                ", imgsrc='" + imgsrc + '\'' +
                ", imgbig=" + imgbig +
                ", productId='" + productId + '\'' +
                '}';
    }
}