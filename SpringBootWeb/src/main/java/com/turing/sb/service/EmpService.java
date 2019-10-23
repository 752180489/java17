package com.turing.sb.service;

import com.turing.sb.entity.EasyUIDataGrid;
import com.turing.sb.entity.Emp;

import java.util.List;

public interface EmpService {

    //分页查询
    public EasyUIDataGrid showEmp(int pageNum,int pageSize);

    //查找所有员工
    public List<Emp> findAll();

    //根据id查找员工
    public Emp findById(Integer empno);

    //增加员工
    public void insert(Emp emp);

    //修改员工
    public void update(Emp emp);

    //删除员工
    public void delete(Integer empno);
}
