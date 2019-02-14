package com.springcloud.consumer.controller;

import java.util.List;

import com.springcloud.api.entities.Dept;
import com.springcloud.api.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController_Consumer
{

	@Autowired
	private DeptClientService service;

	@RequestMapping(value = "/consumer_feign/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return this.service.get(id);
	}

	@RequestMapping(value = "/consumer_feign/dept/list")
	public List<Dept> list()
	{
		System.out.println("consumer_feign===================================>");
		return this.service.list();
	}

	@RequestMapping(value = "/consumer_feign/dept/add")
	public Object add(Dept dept)
	{
		return this.service.add(dept);
	}
}
