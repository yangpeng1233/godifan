package com.action;

import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSON;

import com.entity.*;
import com.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class    Ajax1Controller {

    @Autowired
    private  IServiceGdv_Oederlist soeder;

    @Autowired
    private IServiceGdv_Users uesrs;

    @Autowired
    private  IServiceProductInfo pf;

    @Autowired
    private IServiceShopStore store;

    @RequestMapping(value ="/orederAll" ,produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String orederAll(){
        System.out.println("-------查全部---");
        Map<String,Object> mp=new HashMap();//传回去
        Map<String,Object> mp1=new HashMap();//发网页
        int  pageNumber=1;
        int  pageSize=2;
        String js = "";
        mp.put("start",Integer.valueOf((pageNumber-1)*pageSize));
        mp.put("pagesize",pageSize);
        List<Gdv_Orderlist> list;
        HashMap hm = soeder.selectPages(pageNumber,pageSize ,mp);
        int count = soeder.selectCount(mp);

        list=(List<Gdv_Orderlist>)hm.get("list");
        //转订单状态
        List<Object> olist = new ArrayList();
        for(Gdv_Orderlist o :list){
            if (o.getOrderstate() == 0){
                String state = "完成";
                olist.add(state);
            }else {
                String state = "未完成";
                olist.add(state);
            }
        }

        mp1.put("olist",olist);
        mp1.put("list",list);
        mp1.put("count",count);

        js = JSON.toJSONString(mp1);
        System.out.println("--------js" +js);
        return  js;
    }

    @RequestMapping(value ="/orederAllLimit",produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String orederAllLimit(Integer pageNumber,Integer pageSize){
        System.out.println("-------查全部---");
        Map<String,Object> mp=new HashMap();//传回去
        Map<String,Object> mp1=new HashMap();//发网页
        if (pageNumber == null){
            pageNumber=1;
        }
        if (pageSize == null){
            pageSize=2;
        }
        String js = "";
        mp.put("start",Integer.valueOf((pageNumber-1)*pageSize));
        mp.put("pagesize",pageSize);
        List<Gdv_Orderlist> list;
        HashMap hm = soeder.selectPages(pageNumber,pageSize ,mp);
        int count = soeder.selectCount(mp);

        list=(List<Gdv_Orderlist>)hm.get("list");
        //转订单状态
        List<Object> olist = new ArrayList();
        for(Gdv_Orderlist o :list){
            if (o.getOrderstate() == 0){
                String state = "完成";
                olist.add(state);
            }else {
                String state = "未完成";
                olist.add(state);
            }
        }

        mp1.put("olist",olist);
        mp1.put("list",list);
        mp1.put("count",count);

        js = JSON.toJSONString(mp1);
        System.out.println("--------js" +js);
        return  js;
    }

    @RequestMapping(value ="/orederLike",produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String orederLike(String oname,String otime,String ostate,Integer pageNumber,Integer pageSize){
        System.out.println("-----模糊查询------");
        Map<String,Object> mp1 = new HashMap();//发网页
        Map<String,Object> mp  = new HashMap();  //回底层的mp
        if(pageNumber == null){
            pageNumber=1;
        }
        if(pageSize == null){
            pageSize=2;
        }
        mp.put("start",Integer.valueOf((pageNumber-1)*pageSize));
        mp.put("pagesize",pageSize);

        List<Gdv_Orderlist> list ;

        if (oname.length() > 0){
            mp.put("oreder","%"+oname+"%");
        }
        if (ostate.length() > 0){
            mp.put("state",Integer.parseInt(ostate));
        }
        int count = soeder.selectCount(mp);
      ;

        HashMap hm = soeder.selectPageMohu(pageNumber,pageSize ,mp);
        list=(List<Gdv_Orderlist>)hm.get("list");
        //转订单状态
        List<Object> olist = new ArrayList();
        for(Gdv_Orderlist o :list){
            if (o.getOrderstate() == 0){
                String state = "完成";
                olist.add(state);
            }else {
                String state = "未完成";
                olist.add(state);
            }
        }
        mp1.put("olist",olist);
        mp1.put("list",list);
        mp1.put("count",count);

        String js = JSON.toJSONString(mp1);

        return  js;
    }
/*------------------首页查询------------------------*/
    @RequestMapping(value ="/selectSales",produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String selectSales(){
        /*----------销量查询-------------*/
        List<ShopStore> list = store.selectSales();

        Map<String,Object> mp = new HashMap();
        Map<String,Object> mp2 = new HashMap();
        List<Object> infolist = new ArrayList();
        for(ShopStore s :list){
            mp.put("productid",s.getProductid());
            ProductInfo p1 = pf.selectOne(mp);
            infolist.add(p1.getProductname());
        }

        mp2.put("lists",list);
        mp2.put("infolist",infolist);
        String js = JSON.toJSONString(mp2);

        return js;
    }
    @RequestMapping(value ="/selectCost",produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String selectCost(){

        int num = soeder.selectCost();
        String js = JSON.toJSONString(num);
        return js;
    }
    @RequestMapping(value ="/selectOrder",produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String selectOrder(){
        int num = soeder.selectOrder();
        String js = JSON.toJSONString(num);
        return js;
    }
    @RequestMapping(value ="/selectSu",produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String selectSu(){
        int num = soeder.selectSu();
        String js = JSON.toJSONString(num);
        return js;
    }
    @RequestMapping(value ="/selectBa",produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String selectBa(){
        int num = soeder.selectBa();
        String js = JSON.toJSONString(num);
        return js;
    }
    @RequestMapping(value ="/selectLine",produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String selectLine() {

        Map<String,Object> mp = new HashMap();
        Map<String,Object> mp1 = new HashMap();
        Map<String,Object> mp2 = new HashMap();
        Map<String,Object> mp3 = new HashMap();

        List<Integer> listAll = new ArrayList<>();
        List<Integer> lists = new ArrayList<>();
        List<Integer> listb = new ArrayList<>();
        int s1 = 0;
        int s2 = 1;
        int s3 = 2;
        //所有

        //已完成
        mp1.put("orderState",s2);
        //未完成
        mp1.put("orderState",s3);
        if (s1 == 0) {
            mp1.put("orderState",s1);
            for (int i = 7; i > 0; i--) {
                mp1.put("num", i);
                int num1 = soeder.selectLine(mp1);
                listAll.add(num1);
            }
        }
        if (s2 == 1){
            mp1.put("orderState",s2);
            for (int i = 7; i > 0; i--) {
                mp1.put("num", i);
                int num1 = soeder.selectLine(mp1);
                lists.add(num1);
            }
        }
        if (s3 == 2){
            mp1.put("orderState",s3);
            for (int i = 7; i > 0; i--) {
                mp1.put("num", i);
                int num1 = soeder.selectLine(mp1);
                listb.add(num1);
            }
        }
        mp.put("listAll",listAll);
        mp.put("lists",lists);
        mp.put("listb",listb);
        String js = JSON.toJSONString(mp);
        System.out.println("--------js:="+js);
        return js;
    }

/*--------------------VIP查询-------------------------------------------*/

    //查所有
    @RequestMapping(value ="/selectAllUser",produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String selectAllUser(){
        HashMap mp = new HashMap();
        Map<String,Object> mp1 = new HashMap();
        Map<String,Object> mp2 = new HashMap();
        int  pageNumber=1;
        int  pageSize=2;
        String js = "";
        mp.put("start",Integer.valueOf((pageNumber-1)*pageSize));
        mp.put("pagesize",pageSize);
        List<Gdv_Users> list;
        int count = uesrs.selectCount(mp);

        HashMap hm = uesrs.selectPages(pageNumber,pageSize ,mp);

        list=(List<Gdv_Users>)hm.get("list");


        List<Object> ulist = new ArrayList();
        List<Object> Viplist = new ArrayList();

        for(Gdv_Users u1 :list){
            mp2.put("userid",u1.getUserId());
            Gdv_Orderlist d2 = soeder.selectOne(mp2);
            if (d2 == null){
                String ss = "无消费";
                ulist.add(ss);
            }else {
                SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
                String date=smf.format(d2.getPaytime());
                ulist.add(date);
            }
            if (u1.getUserVip() == 0){
                String vip = "管理员";
                Viplist.add(vip);
            }else if (u1.getUserVip() == 1){
                String vip = "歌帝梵经典卡会员";
                Viplist.add(vip);
            }else if (u1.getUserVip() == 2){
                String vip = "歌帝梵金卡会员";
                Viplist.add(vip);
            }else{
                String vip = "歌帝梵白金卡会员";
                Viplist.add(vip);
            }
        }
        mp1.put("vlist",Viplist);
        mp1.put("olist",ulist);
        mp1.put("list",list);
        mp1.put("count",count);
        js = JSON.toJSONString(mp1);

        return js;
    }

    @RequestMapping(value ="/selectUserLimit",produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String selectUserLimit(Integer pageNumber,Integer pageSize){
        HashMap mp = new HashMap();
        Map<String,Object> mp1 = new HashMap();
        Map<String,Object> mp2 = new HashMap();
        System.out.println("-----------------pageNumber:="+pageNumber);
        System.out.println("-----------------pageSize:="+pageSize);
        if (pageNumber == null) {
            pageNumber = 1;
        }
        if (pageSize == null){
            pageSize=2;
        }
        String js = "";
        mp.put("start",Integer.valueOf((pageNumber-1)*pageSize));
        mp.put("pagesize",pageSize);
        List<Gdv_Users> list;

        int count = uesrs.selectCount(mp);

        HashMap hm = uesrs.selectPages(pageNumber,pageSize ,mp);

        list=(List<Gdv_Users>)hm.get("list");


        List<Object> ulist = new ArrayList();
        List<Object> Viplist = new ArrayList();

        for(Gdv_Users u1 :list){
            mp2.put("userid",u1.getUserId());
            Gdv_Orderlist d2 = soeder.selectOne(mp2);
            if (d2 == null){
                String ss = "无消费";
                ulist.add(ss);
            }else {
                SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
                String date=smf.format(d2.getPaytime());
                ulist.add(date);
            }
            if (u1.getUserVip() == 0){
                String vip = "管理员";
                Viplist.add(vip);
            }else if (u1.getUserVip() == 1){
                String vip = "歌帝梵经典卡会员";
                Viplist.add(vip);
            }else if (u1.getUserVip() == 2){
                String vip = "歌帝梵金卡会员";
                Viplist.add(vip);
            }else{
                String vip = "歌帝梵白金卡会员";
                Viplist.add(vip);
            }
        }
        mp1.put("vlist",Viplist);
        mp1.put("olist",ulist);
        mp1.put("list",list);
        mp1.put("count",count);
        js = JSON.toJSONString(mp1);

        return js;
    }


    @RequestMapping(value ="/UserDelect",produces="application/json;charset=UTF-8" )
    @ResponseBody
    public String UserDelect(String id){
        System.out.println("--------id--:="+id);
        Map<String,Object> mp = new HashMap();
            String js ="";
        Gdv_Users u1 = uesrs.selectByPrimaryKey(Integer.parseInt(id));
        if (u1.getUserVip() ==0){
            js =JSON.toJSONString(false);
        }else {
            mp.put("userid",u1.getUserId());
            Gdv_Orderlist d2 = soeder.selectOne(mp);
           if (d2 == null){
               int unum = uesrs.deleteByPrimaryKey(Integer.parseInt(id));
               if (unum > 0){
                   js =JSON.toJSONString(true);
               }else {
                   js =JSON.toJSONString(false);
               }
           }else {
               int num =soeder.deleteByPrimaryKey(d2.getOid());
               if (num > 0){
                   int unum = uesrs.deleteByPrimaryKey(Integer.parseInt(id));
                   if (unum > 0){
                       js =JSON.toJSONString(true);
                   }else {
                       js =JSON.toJSONString(false);
                   }
               }else {
                   js =JSON.toJSONString(false);
               }
           }
        }
        return js;

    }

}
