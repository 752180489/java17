package com.turing.sb.mapper;

import com.turing.sb.entity.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {
    //查询所有菜单
    @Select("select * from menu where PID = 0")
    List<Menu> findAll();

    //查询子菜单
    @Select("select * from menu where PID = #{0}")
    List<Menu> findById(Integer id);

    //方式二：递归
    @Select("select * from menu")
    List<Menu> findAll2();
}
