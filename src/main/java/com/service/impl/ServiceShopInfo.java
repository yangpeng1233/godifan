package com.service.impl;
import com.dao.IShopInfo;
import com.entity.*;
import com.service.IServiceShopInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service("serviceShopInfo")
public class ServiceShopInfo implements IServiceShopInfo{

    @Autowired
    private IShopInfo dao;


    public List<ShopInfo> selectAll() {
        return dao.selectAll();
    }


    public ShopInfo selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }
}
