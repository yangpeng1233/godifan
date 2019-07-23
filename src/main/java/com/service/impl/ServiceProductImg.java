package com.service.impl;
import com.dao.IProductImg;
import com.entity.*;
import com.service.IServiceProductImg;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value ="serviceProductImg")
public class ServiceProductImg implements IServiceProductImg{

    @Autowired
    private IProductImg dao;

    public int updateByPrimaryKey(ProductImg m1) {
        return dao.updateByPrimaryKey(m1);
    }

    @Override
    public int insert(ProductImg m1) {
        return dao.insert(m1);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }
}
