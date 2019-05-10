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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


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
  
  @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
  @HystrixCommand(fallbackMethod = "processHystrix_Get")
  public Dept get(@PathVariable("id") Long id)
  {
   Dept dept =  this.service.get(id);
   if(null == dept)
   {
     throw new RuntimeException("该ID："+id+"没有没有对应的信息");
   }
   return dept;
  }
 
  public Dept processHystrix_Get(@PathVariable("id") Long id)
  {
//这里异常的处理方法是返回一个属性中写出信息的实体？？？
//最后交给前端来处理
   return new Dept().setDeptNo(id)
           .setDeptName("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
           .setDbSource("no this database in MySQL");
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
 
    
    List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
    for (ServiceInstance element : srvList) {
     System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
         + element.getUri());
    }
    return this.client;
  }
}
