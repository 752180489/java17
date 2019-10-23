package com.turing.sb.controller;

import com.turing.sb.entity.Dept;
import com.turing.sb.entity.EasyUIDataGrid;
import com.turing.sb.entity.Emp;
import com.turing.sb.service.DeptService;
import com.turing.sb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

    //分页查询，提供给EasyUI使用的
    @RequestMapping("/showEmp")
    @ResponseBody
    public EasyUIDataGrid showEmp(@RequestParam(name = "page",defaultValue = "1") int pageNum,@RequestParam(name = "rows",defaultValue = "4") int pageSize){
        return empService.showEmp(pageNum,pageSize);
    }

    //访问员工管理
//    @GetMapping("/emps")
//    public String emps(){
//        return "emps";
//    }

    //查询所有员工
    @GetMapping("/emps")
    public String emps(Model model){
        List<Emp> list = empService.findAll();
        model.addAttribute("empList",list);
        return "emps";
    }

    //添加员工
    @PostMapping("/emp")
    public String emp(Emp emp){
        empService.insert(emp);
        return "redirect:/emps";
    }

    //使用EasyUI的方式：添加员工
    @PostMapping("/emp2")
    @ResponseBody
    public String emp2(Emp emp){
        empService.insert(emp);
        return "success";
    }

    //使用EasyUI的方式：修改员工
    @PostMapping("/upd")
    @ResponseBody
    public String upd(Emp emp){
        empService.update(emp);
        return "success";
    }

    //使用EasyUI的方式：删除员工
    @PostMapping("/del/{empno}")
    @ResponseBody
    public String del(@PathVariable("empno") Integer empno){
        empService.delete(empno);
        return "success";
    }

     //查找所有部门
    //异步请求
    @GetMapping("/depts")
    @ResponseBody
    public List<Dept> depts(){
        return deptService.findAll();
    }


    //根据id查找员工
    @GetMapping("/edit/{id}")
    @ResponseBody
    public Emp edit(@PathVariable("id") Integer empno, Model model){
        Emp emp = empService.findById(empno);
        return emp;
    }

    //修改员工
    @PostMapping("/update")
    public String update(Emp emp){
        empService.update(emp);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/emp/{id}")
    public String emp(@PathVariable("id") Integer empno){
        empService.delete(empno);
        return "redirect:/emps";
    }


}
