package com.turing.sb.service.impl;

import com.turing.sb.entity.EasyUIDataGrid;
import com.turing.sb.entity.Emp;
import com.turing.sb.mapper.EmpMapper;
import com.turing.sb.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public EasyUIDataGrid showEmp(int pageNum, int pageSize) {
        EasyUIDataGrid dataGrid=new EasyUIDataGrid();
        dataGrid.setRows(empMapper.selectByPage(pageSize*(pageNum-1),pageSize));
        dataGrid.setTotal(empMapper.selectCount());
        return dataGrid;
    }

    @Override
    public List<Emp> findAll() {
        return empMapper.selectByExample(null);
    }

    @Override
    public Emp findById(Integer empno) {
        return empMapper.selectByPrimaryKey(empno);
    }

    @Override
    public void insert(Emp emp) {
        empMapper.insert(emp);
    }

    @Override
    public void update(Emp emp) {
        empMapper.updateByPrimaryKey(emp);
    }

    @Override
    public void delete(Integer empno) {
        empMapper.deleteByPrimaryKey(empno);
    }
}
