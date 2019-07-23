package com.dao;
import java.util.*;
import com.entity.*;
public interface IGdv_Orderlist {

    List<Gdv_Orderlist> selectAll();

    Gdv_Orderlist selectOne(Map<String,Object> mp);

    List<Gdv_Orderlist> selectA(Map<String,Object> mp);

    Gdv_Orderlist selectByPrimaryKey(Integer id);

    List<Gdv_Orderlist> selectPage(Map<String,Object> mp);



    int deleteByPrimaryKey(Integer id);

    int selectCount(Map<String,Object> mp);
    int selectLine(Map<String,Object> mp);
    int selectCost();////查成交金额
    int selectOrder();//查总数
    int selectSu();//查以成交订单
    int selectBa();//查未成交订单
}
