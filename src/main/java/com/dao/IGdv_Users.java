package com.dao;
import java.util.*;
import com.entity.*;
public interface IGdv_Users {

        List<Gdv_Users> selectAll();


        List<Gdv_Users> selectPage(Map<String,Object> mp);

        Gdv_Users selectLogin(Map<String, Object> mp);

        Gdv_Users selectByPrimaryKey(Integer id);

        int selectCount(Map<String,Object> mp);

        int deleteByPrimaryKey(Integer id);
}
