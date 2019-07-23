package com.dao;
import java.util.*;
import com.entity.*;


public interface IShopInfo {

    List<ShopInfo> selectAll();

   /* List<ShopInfo> selectLike(Map<String,Object> mp);
    List<ShopInfo> selectPage(Map<String,Object> mp);
    int selectCount(Map<String,Object> mp);*/
    ShopInfo selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);


}
