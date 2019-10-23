package com.turing.sb.service;

import com.turing.sb.entity.Menu;

import java.util.List;

public interface MenuService {
    //查询菜单
    List<Menu> findMenu();

    //查询菜单2：递归方式
    List<Menu> findMenu2();
}
