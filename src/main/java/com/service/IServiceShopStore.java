package com.service;
import com.entity.*;

import java.util.*;

public interface IServiceShopStore {
    List<ShopStore> selectALl();

    List<ShopStore> selectSales();
    List<ShopStore> selectLike(Map<String,Object> mp);
    List<ShopStore> selectPage(Map<String,Object> mp);
    HashMap selectPages(Integer pageSize,Integer pageNumber,Map<String,Object> mp);
    HashMap selectPageMpHu(Map<String,Object> mp);
    int selectCount(Map<String,Object> mp);
    int insert(ShopStore ss);
    int deleteByPrimaryKey(Integer id);


}


