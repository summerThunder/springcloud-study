package com.cml.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cml.springcloud.entities.Dept;
import com.cml.springcloud.service.DeptClientService;



@RestController
public class DeptController_Consumer {
	//用feign，客户端也能调用service了
	 @Autowired
	  private DeptClientService service = null;
	 
	  @RequestMapping(value = "/consumer/dept/get/{id}")
	  public Dept get(@PathVariable("id") Long id)
	  {
	   return this.service.get(id);
	  }
	 
	  @RequestMapping(value = "/consumer/dept/list")
	  public List<Dept> list()
	  {
	   return this.service.list();
	  }
	 
	  @RequestMapping(value = "/consumer/dept/add")
	  public Object add(Dept dept)
	  {
	   return this.service.add(dept);
	  }


}
