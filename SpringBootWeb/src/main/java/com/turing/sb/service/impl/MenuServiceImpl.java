package com.turing.sb.service.impl;

import com.turing.sb.entity.Attributes;
import com.turing.sb.entity.Menu;
import com.turing.sb.mapper.MenuMapper;
import com.turing.sb.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findMenu() {
        List<Menu> list = menuMapper.findAll();
        //遍历
        for(Menu menu:list){
            menu.setChildren(menuMapper.findById(menu.getID()));
        }
        return list;
    }

    @Override
    public List<Menu> findMenu2() {
        return getFatherNode(menuMapper.findAll2());
    }

    /**
     * 根据节点集合获得所有的父节点为pid的节点，并且都设置了子元素
     * @param list 所有的菜单集合
     * @return 父节点集合，父节点里装载了子节点
     */
    private List<Menu> getFatherNode(List<Menu> list){
        List<Menu> fatherList = new ArrayList<Menu>();
        for(Menu s:list){
            if(s.getPID()==0){
                //获取父节点下的子节点，根据父节点递归调用获取所有的子节点
                s.setChildren(getChildrenNode(s.getID(),list));
                fatherList.add(s);
            }
        }
        return fatherList;
    }

    /**
     * 递归调用
     * @param pid 父节点
     * @param list 要循环的集合
     * @return 将所有子节点设置到父节点对象里的list集合里
     */
    private List<Menu> getChildrenNode(int pid,List<Menu> list){
        List<Menu> findChildrenList = new ArrayList<Menu>();
        //循环传入的集合
        for(Menu s:list){
            if(s.getID()==0){
                //父节点，不需要装载子元素
                continue;
            }
            if(s.getPID()==pid){
                //根据父id找到了一个子节点，加入到子节点集合中去
                findChildrenList.add(s);
                //设置属性
                Attributes att=new Attributes();
                att.setUrl(s.getUrl());
                att.setIcon(s.getIcon());
                s.setAttributes(att);
                //设置子节点集合，递归调用
                s.setChildren(getChildrenNode(s.getID(),list));
            }
        }
        return findChildrenList;
    }
}
