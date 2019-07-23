package com.service;
import com.entity.*;

import java.util.List;

public interface IServiceShopInfo {

    List<ShopInfo> selectAll();
    ShopInfo selectByPrimaryKey(Integer id);
}
