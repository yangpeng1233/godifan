package com.entity;

import java.io.Serializable;

public class ProductKind implements Serializable{
    private Integer kindid;

    private String kindname;

    public Integer getKindid() {

        return kindid;
    }

    public void setKindid(Integer kindid) {

        this.kindid = kindid;
    }

    public String getKindname() {

        return kindname;
    }

    public void setKindname(String kindname) {

        this.kindname = kindname == null ? null : kindname.trim();
    }
}