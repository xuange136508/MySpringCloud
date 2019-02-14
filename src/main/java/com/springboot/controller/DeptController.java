package com.springboot.controller;


import com.springboot.bean.Department;
import com.springboot.bean.Employee;
import com.springboot.mapper.EmployeeMapper;
import com.springboot.service.DepartmentService;
import com.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentService.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentService.insertDept(department);
        return department;
    }

    @GetMapping("/depts")
    public List<Department> getAllDeptInfo(){
        System.out.println("getAllDeptInfo......");
        return departmentService.getAllDeptInfo();
    }


    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
       return employeeService.getEmpById(id);
    }

    @GetMapping("/updateDept")
    public Department update(Department department){
        Department dept = departmentService.updateDepartment(department);
        return dept;
    }



}
