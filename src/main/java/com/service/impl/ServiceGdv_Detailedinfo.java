package com.service.impl;
import com.entity.*;
import com.service.IServiceGdv_Detailedinfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service("ServiceGdv_Detailedinfo")
public class ServiceGdv_Detailedinfo implements IServiceGdv_Detailedinfo{

}
