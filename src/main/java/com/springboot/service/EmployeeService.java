package com.springboot.service;

import com.springboot.bean.Employee;
import com.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;


    public Employee getEmpById(Integer id){
        return employeeMapper.getEmpById(id);
    }



}
