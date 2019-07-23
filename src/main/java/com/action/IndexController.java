package com.action;
import com.entity.*;
import com.service.IServiceGdv_Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private IServiceGdv_Users us;


    @RequestMapping(value = "reg")
    public ModelAndView reg(ModelAndView mvo){
        int sid = 1;
        Gdv_Users u1 = us.selectByPrimaryKey(sid);

        System.out.println("--------u1"+u1);
        mvo.setViewName("login");
        return mvo;
    }

}
