package com.entity;
import java.util.*;
import java.io.*;
import java.io.Serializable;

public class LineDate implements Serializable{

    private List<Integer> allOrder = new ArrayList();

    private List<Integer> sOrder = new ArrayList();

    private List<Integer> bOrder = new ArrayList();

    private Integer max ;
    private Integer min ;


    public List<Integer> getAllOrder() {
        return allOrder;
    }

    public List<Integer> getsOrder() {
        return sOrder;
    }

    public List<Integer> getbOrder() {
        return bOrder;
    }

    public Integer getMax() {
        return max;
    }

    public Integer getMin() {
        return min;
    }

    public void setAllOrder(List<Integer> allOrder) {
        this.allOrder = allOrder;
    }

    public void setsOrder(List<Integer> sOrder) {
        this.sOrder = sOrder;
    }

    public void setbOrder(List<Integer> bOrder) {
        this.bOrder = bOrder;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public void setMin(Integer min) {
        this.min = min;
    }


    public String toString() {
        return "LineDate{" +
                "allOrder=" + allOrder +
                ", sOrder=" + sOrder +
                ", bOrder=" + bOrder +
                ", max=" + max +
                ", min=" + min +
                '}';
    }
}
