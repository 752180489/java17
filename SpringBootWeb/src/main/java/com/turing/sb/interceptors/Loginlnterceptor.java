package com.turing.sb.interceptors;

import com.turing.sb.entity.SysUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Loginlnterceptor implements HandlerInterceptor {

    //在控制器执行前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //通过什么来判断登录了？session
        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        if (sysUser==null){
            //没有登录
            response.sendRedirect("/");//回到登录页面
            return false;//拦截
        }else {
            return true;//放行
        }
    }
}
