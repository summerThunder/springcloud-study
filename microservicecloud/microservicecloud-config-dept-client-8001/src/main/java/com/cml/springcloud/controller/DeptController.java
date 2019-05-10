package com.cml.springcloud.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cml.springcloud.entities.Dept;
import com.cml.springcloud.service.DeptService;


@RestController
public class DeptController {
  @Autowired
  private DeptService service;
  
  @Autowired
  private DiscoveryClient client;
  
  
  @RequestMapping(value="/dept/add",method=RequestMethod.POST)
  public boolean add(@RequestBody Dept dept) {
	  return service.add(dept);
  }
  
  //@PathVariable可以获得url地址中的一些信息
  @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
  public Dept get(@PathVariable("id") Long id) {
	  return service.get(id);
  }
  
  @RequestMapping(value="/dept/list",method=RequestMethod.GET)
  public List<Dept> list() {
	  return service.list();
  }
  
  @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
  public Object discovery()
  {
	//可以从某个微服务拿到注册中心的所有服务
    List<String> list = client.getServices();
    System.out.println("**********" + list);
 
    //微服务可以同名？，名字用大写
    List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
    for (ServiceInstance element : srvList) {
     System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
         + element.getUri());
    }
    return this.client;
  }
}
