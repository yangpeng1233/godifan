package com.service;
import com.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IServiceGdv_Users {

  List<Gdv_Users> selectAll();


  List<Gdv_Users> selectPage(Map<String,Object> mp);

  Gdv_Users selectLogin(Map<String, Object> mp);

  HashMap selectPages(Integer pageNumber, Integer pageSize, Map<String, Object> mp);

  Gdv_Users selectByPrimaryKey(Integer id);

  int selectCount(Map<String,Object> mp);

  int deleteByPrimaryKey(Integer id);
}
