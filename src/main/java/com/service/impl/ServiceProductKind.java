package com.service.impl;
import com.entity.*;
import com.dao.IProductKind;
import com.service.IServiceProductKind;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@MapperScan(basePackages="com.dao")
@Service(value ="serviceProductKind")
public class ServiceProductKind implements IServiceProductKind{

    @Autowired
    private IProductKind dao;

    public List<ProductKind> selectAll() {

        return dao.selectAll();
    }
}
