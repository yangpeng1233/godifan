package com.service.impl;

import com.dao.IShopStore;
import com.entity.*;
import com.service.IServiceShopStore;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value = "serviceShopStore")
public class ServiceShopStore implements IServiceShopStore{


    @Autowired
    private IShopStore dao;



    public List<ShopStore> selectALl() {
        return dao.selectAll();
    }
    public List<ShopStore> selectSales() {
        return dao.selectSales();
    }


    public List<ShopStore> selectLike(Map<String, Object> mp) {
        return dao.selectLike(mp);
    }


    public List<ShopStore> selectPage(Map<String, Object> mp) {
        return dao.selectPage(mp);
    }


    public HashMap selectPages(Integer pageSize,Integer pageNumber, Map<String,Object> mp){
        HashMap mp2 = new HashMap();//传数据
        int pagenum=1;//页面纠错
        int pagecount=1;  //页数
        List<ShopStore> list =new ArrayList();
        // 分页逻辑
        // 1 .取总记录数
        int count = dao.selectCount(mp);
        if(count > 0){
            // 2. 算总页数
            if(count % pageSize == 0){
                pagecount = count / pageSize ;
            }else{
                pagecount = count / pageSize  + 1;
            }
            //	3. 对页数纠错 >=1 &&  <=pagecount
            if(pageNumber < 1){
                pagenum = 1;
            }else if(pageNumber > pagecount){
                pagenum = pagecount;
            }else{
                pagenum = pageNumber ;
            }
            // 4. 取数据

            list = dao.selectPage(mp);

        }
        mp2.put("list",list);

        return mp2;
    }


    public HashMap selectPageMpHu(Map<String, Object> mp) {
        return null;
    }


    public int selectCount(Map<String, Object> mp) {
        return dao.selectCount(mp);
    }

    public int insert(ShopStore ss) {
        return dao.insert(ss);
    }


    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

}
