package com.dao;
import java.util.*;
import com.entity.*;
public interface IShopStore {

        List<ShopStore> selectAll();
        List<ShopStore> selectSales();

        List<ShopStore> selectLike(Map<String,Object> mp);
        List<ShopStore> selectPage(Map<String,Object> mp);

        int insert(ShopStore ss);
        int deleteByPrimaryKey(Integer id);
        int selectCount(Map<String,Object> mp);
}
