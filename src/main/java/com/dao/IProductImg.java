package com.dao;
import java.util.*;
import com.entity.*;
public interface IProductImg {


    int updateByPrimaryKey(ProductImg m1);

    int insert(ProductImg m1);

    int deleteByPrimaryKey(Integer id);
}
