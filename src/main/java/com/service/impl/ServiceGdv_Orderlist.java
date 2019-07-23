package com.service.impl;
import com.dao.IGdv_Orderlist;
import com.entity.*;
import com.service.IServiceGdv_Oederlist;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@MapperScan(basePackages ="com.dao")
@Service("ServiceGdv_Orderlist")
public class ServiceGdv_Orderlist implements IServiceGdv_Oederlist{


    @Autowired
    private IGdv_Orderlist dao;

    public List<Gdv_Orderlist> selectAll() {

        return dao.selectAll();
    }


    public Gdv_Orderlist selectOne(Map<String, Object> mp) {
        return dao.selectOne(mp);
    }


    public Gdv_Orderlist selectByPrimaryKey(Integer id) {


        return dao.selectByPrimaryKey(id);
    }


    public List<Gdv_Orderlist> selectA(Map<String, Object> mp) {
        return dao.selectA(mp);
    }

    @Override
    public int selectLine(Map<String, Object> mp) {


        System.out.println("-----------mp：="+mp);
        return dao.selectLine(mp);
    }


    public int deleteByPrimaryKey(Integer id) {

        return dao.deleteByPrimaryKey(id);

    }

    public HashMap selectPages(Integer pageNumber, Integer pageSize, Map<String, Object> mp) {
        HashMap mp1 = new HashMap();
        int pagenum=1;//页面纠错
        int pagecount=1;  //页数
        List<Gdv_Orderlist> list = new ArrayList(); // 页显示内容

        //--------------------------------
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
            System.out.println("--------list"+list);
        }
        //--------------------------------
       /* mp1.put("pagenum", pagenum);
        mp1.put("pagecount", pagecount);*/
        mp1.put("list", list);

        return mp1;
    }

    public HashMap selectPageMohu(Integer pageNumber, Integer pageSize, Map<String, Object> mp) {

        HashMap mp1 = new HashMap();
        int pagenum=1;//页面纠错
        int pagecount=1;  //页数
        List<Gdv_Orderlist> list =new ArrayList();
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
        mp1.put("list",list);

        return mp1;
    }


    public List<Gdv_Orderlist> selectPage(Map<String, Object> mp) {

        return dao.selectPage(mp);

    }


    public int selectCount(Map<String, Object> mp) {

        return dao.selectCount(mp);
    }


    public int selectCost() {
        return dao.selectCost();
    }


    public int selectOrder() {
        return dao.selectOrder();
    }


    public int selectSu() {
        return dao.selectSu();
    }


    public int selectBa() {
        return dao.selectBa();
    }
}
