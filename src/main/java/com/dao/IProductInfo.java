package com.dao;
import java.util.*;
import com.entity.*;
public interface IProductInfo {
    List<ProductInfo> selectAll();
    List<ProductInfo> selectLike(Map<String, Object> mp);
    List<ProductInfo> selectPag(Map<String, Object> mp);
    ProductInfo selectOne(Map<String, Object> mp);
    ProductInfo selectByPrimaryKey(Integer p1);
    int insert(ProductInfo p1);
    int updateByPrimaryKey(ProductInfo p1);
    int deleteByPrimaryKey(Integer p1);
    int selectCount(Map<String, Object> mp);
}
