package com.turing.sb.configuration;

import com.turing.sb.interceptors.Loginlnterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*//注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Loginlnterceptor())
                .addPathPatterns("/**")//需要拦截的路径
                .excludePathPatterns("/css/**","/js/**","/images/**","/","/login");//不需要拦截的路径
    }*/

    //统一配置视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/easyui").setViewName("easyui");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/layout").setViewName("layout");
        registry.addViewController("/nav").setViewName("nav");
    }
}
