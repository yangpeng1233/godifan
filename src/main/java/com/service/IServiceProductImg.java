package com.service;
import com.entity.*;
public interface IServiceProductImg {


    int updateByPrimaryKey(ProductImg m1);

    int insert(ProductImg m1);

    int deleteByPrimaryKey(Integer id);
}
