package com.service;
import com.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IServiceProductInfo {

    List<ProductInfo> selectAll();
    List<ProductInfo> selectLike(Map<String, Object> mp);
    List<ProductInfo> selectPag(Map<String, Object> mp);
    HashMap selectPaging(Integer pageNumber, Integer pageSize,Map<String, Object> mp);
    HashMap selectPagingMohu(Integer pageNumber, Integer pageSize, Map<String, Object> mp);
    ProductInfo selectOne(Map<String, Object> mp);
    ProductInfo selectByPrimaryKey(Integer p1);
    int insert(ProductInfo p1);
    int updateByPrimaryKey(ProductInfo p1);
    int deleteByPrimaryKey(Integer p1);
    int selectCount(Map<String, Object> mp);
}
