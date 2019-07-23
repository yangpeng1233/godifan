package com.service.impl;
import com.entity.*;
import com.dao.IGdv_Users;
import com.service.IServiceGdv_Users;
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
@Service(value = "serviceGdv_Users")
public class ServiceGdv_Users implements IServiceGdv_Users{

    @Autowired
    private IGdv_Users dao;



    public Gdv_Users selectLogin(Map<String,Object> mp) {

        return dao.selectLogin(mp);
    }



    public List<Gdv_Users> selectAll() {

        return dao.selectAll();
    }



    public List<Gdv_Users> selectPage(Map<String, Object> mp) {
        return dao.selectPage(mp);
    }


    public HashMap selectPages(Integer pageNumber, Integer pageSize, Map<String, Object> mp) {
        HashMap mp1 = new HashMap();
        int pagenum=1;//页面纠错
        int pagecount=1;  //页数
        List<Gdv_Users> list = new ArrayList(); // 页显示内容

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

        }

        mp1.put("list", list);

        return mp1;
    }



    public Gdv_Users selectByPrimaryKey(Integer id) {

        return dao.selectByPrimaryKey(id);
    }


    public int selectCount(Map<String, Object> mp){
        return dao.selectCount(mp);
    }


    public int deleteByPrimaryKey(Integer id) {

        return dao.deleteByPrimaryKey(id);
    }


}
