package com.entity;

import java.io.Serializable;

public class ProductSeries implements Serializable{
    private Integer seriesid;

    private String seriesname;

    private String seriesimg;

    private Integer kindid;

    public Integer getSeriesid() {

        return seriesid;
    }

    public void setSeriesid(Integer seriesid) {

        this.seriesid = seriesid;
    }

    public String getSeriesname() {

        return seriesname;
    }

    public void setSeriesname(String seriesname) {

        this.seriesname = seriesname == null ? null : seriesname.trim();
    }

    public String getSeriesimg() {

        return seriesimg;
    }

    public void setSeriesimg(String seriesimg) {

        this.seriesimg = seriesimg == null ? null : seriesimg.trim();
    }

    public Integer getKindid() {

        return kindid;
    }

    public void setKindid(Integer kindid) {

        this.kindid = kindid;
    }
}