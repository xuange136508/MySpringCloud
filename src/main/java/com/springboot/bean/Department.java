package com.springboot.bean;

import java.io.Serializable;

public class Department implements Serializable {

    private Integer id;
    private String departmentName;

    public Department() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
