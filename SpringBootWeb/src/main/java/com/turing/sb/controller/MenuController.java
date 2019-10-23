package com.turing.sb.controller;

import com.turing.sb.entity.Menu;
import com.turing.sb.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    //获取菜单
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Menu> findAll(){
        return menuService.findMenu();
    }

    //获取菜单2:递归方式
    @RequestMapping("/findAll2")
    @ResponseBody
    public List<Menu> findAll2(){
        return menuService.findMenu2();
    }
}
