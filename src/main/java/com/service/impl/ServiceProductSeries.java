package com.service.impl;

import com.entity.*;
import com.dao.IProductSeries;
import com.service.IServiceProductSeries;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value = "serviceProductSeries")
public class ServiceProductSeries implements IServiceProductSeries{

    @Autowired
    private IProductSeries dao;


    public List<ProductSeries> selectLike(Integer s1) {

        return dao.selectLike(s1);
    }
}
