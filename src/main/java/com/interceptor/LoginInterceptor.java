package com.interceptor;

import com.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class LoginInterceptor implements HandlerInterceptor{

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(handler instanceof HandlerMethod){
           HandlerMethod hmd = (HandlerMethod)handler;
           Method md = hmd.getMethod(); // 取方法
           Login lg = (Login)md.getAnnotation(Login.class); //取注解
           if(lg != null){
                    boolean cklogin = lg.check();
                    //System.out.println(" check = "+cklogin);
                   if(cklogin){ // 进行验证
                       HttpSession session = request.getSession();
                       boolean ck = check(session,request);//检查
                       if(ck){
                           response.sendRedirect("login.jsp");
                           return false;
                       }
                   }
           }else{
               //System.out.println("不要验证登录！！");
           }
        }

        return true;
    }

    private boolean check( HttpSession session,HttpServletRequest request){ // 结果是 true 就是不能过要去登录页面
        boolean ck = false;
        // 取 spring 的 web 上下文
        ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        RedisClient redisClient = (RedisClient)ac1.getBean("redisClient"); // 取 redis客户端对象
        // 先看 session
        Object sobj = session.getAttribute("userinfo");
        if(sobj == null){
             // 后看 redis
            Object robj = redisClient.get("userinfo");
            //System.out.println(" redis obj = "+robj );
            if(robj == null){
                ck = true ; // 不能过
            }else{
                session.setAttribute("userinfo",robj); // 把redis中的放session
            }
        }

        return ck ;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
