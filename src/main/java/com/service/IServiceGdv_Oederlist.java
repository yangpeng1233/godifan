package com.service;
import com.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IServiceGdv_Oederlist {

    List<Gdv_Orderlist> selectAll();

    Gdv_Orderlist selectOne(Map<String,Object> mp);

    Gdv_Orderlist selectByPrimaryKey(Integer id);

    List<Gdv_Orderlist> selectA(Map<String,Object> mp);

    int selectLine(Map<String,Object> mp);

    int deleteByPrimaryKey(Integer id);

    HashMap selectPages(Integer pageNumber, Integer pageSize, Map<String, Object> mp);

    HashMap selectPageMohu(Integer pageNumber, Integer pageSize, Map<String, Object> mp);


    List<Gdv_Orderlist> selectPage(Map<String,Object> mp);

   int  selectCount(Map<String,Object> mp);

    int selectCost();////查成交金额
    int selectOrder();//查总数
    int selectSu();//查以成交订单
    int selectBa();//查未成交订单

}
