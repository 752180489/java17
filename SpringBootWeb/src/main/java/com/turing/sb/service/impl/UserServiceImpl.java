package com.turing.sb.service.impl;

import com.turing.sb.entity.SysUser;
import com.turing.sb.entity.SysUserExample;
import com.turing.sb.mapper.SysUserMapper;
import com.turing.sb.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserMapper userMapper;

    @Override
    public SysUser login(SysUser sysUser) {
        SysUserExample example=new SysUserExample();
        example.createCriteria()
               .andUserNameEqualTo(sysUser.getUserName())
               .andPassWordEqualTo(sysUser.getPassWord());
        List<SysUser> list = userMapper.selectByExample(example);
        if (list !=null && list.size()==1){
            return list.get(0);
        }else {
            return null;
        }
    }
}
