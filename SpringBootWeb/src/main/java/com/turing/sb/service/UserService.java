package com.turing.sb.service;

import com.turing.sb.entity.SysUser;

public interface UserService {

    /**
     * 登录验证
     * @param sysUser
     * @return SysUser
     */
    public SysUser login(SysUser sysUser);
}
