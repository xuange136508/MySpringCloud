package com.springboot.service;

import com.springboot.bean.Department;
import com.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(value = "dept",key = "#root.methodName+'['+ #id +']'")
    public Department getDeptById(Integer id){
        return departmentMapper.getDeptById(id);
    }

    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @Cacheable(value = "dept")
    public List<Department> getAllDeptInfo() {
        return departmentMapper.getAllDeptInfo();
    }

    @CachePut(value = "dept",key = "#result.id")
    public Department updateDepartment(Department department){
        departmentMapper.updateDept(department);
        return department;
    }
}
