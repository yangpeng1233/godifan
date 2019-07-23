package com.service.impl;
import com.dao.IProductInfo;
import com.entity.*;
import com.service.IServiceProductInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;


@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value ="serviceProductInfo")
public class ServiceProductInfo implements IServiceProductInfo{

    @Autowired
    private IProductInfo dao;

    public List<ProductInfo> selectAll() {

        return dao.selectAll();
    }


    public List<ProductInfo> selectLike(Map<String, Object> mp){

        return dao.selectLike(mp);
    }


    public List<ProductInfo> selectPag(Map<String, Object> mp) {

        return dao.selectPag(mp);
    }


    public HashMap selectPaging(Integer pageNumber, Integer pageSize,Map<String, Object> mp) {
        HashMap mp1 = new HashMap();
        int pagenum=1;//页面纠错
        int pagecount=1;  //页数
        List<ProductInfo> list = new ArrayList(); // 页显示内容

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
            list = dao.selectPag(mp);
            System.out.println("--------list"+list);
        }
        //--------------------------------
       /* mp1.put("pagenum", pagenum);
        mp1.put("pagecount", pagecount);*/
        mp1.put("list", list);

        return mp1;
    }


   public HashMap selectPagingMohu(Integer pageNumber, Integer pageSize, Map<String, Object> mp) {

        HashMap mp2 = new HashMap();//传数据
        int pagenum=1;//页面纠错
        int pagecount=1;  //页数
        List<ProductInfo> list =new ArrayList();
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

        list = dao.selectPag(mp);

        }
        mp2.put("list",list);

        return mp2;
    }


    public ProductInfo selectOne(Map<String, Object> mp) {


        return dao.selectOne(mp);
    }

    public ProductInfo selectByPrimaryKey(Integer p1) {

        return dao.selectByPrimaryKey(p1);
    }


    public int insert(ProductInfo p1) {

        return dao.insert(p1);
    }


    public int updateByPrimaryKey(ProductInfo p1) {

        return dao.updateByPrimaryKey(p1);
    }


    public int deleteByPrimaryKey(Integer p1) {

        return dao.deleteByPrimaryKey(p1);
    }


    public int selectCount(Map<String, Object> mp) {

        return dao.selectCount(mp);
    }


}
