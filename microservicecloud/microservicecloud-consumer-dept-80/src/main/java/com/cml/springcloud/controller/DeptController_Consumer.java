package com.cml.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cml.springcloud.entities.Dept;



@RestController
public class DeptController_Consumer {
  //客户端没有 service层，改为引用其他Bean
	
//	private static final String REST_URL_PREFIX="http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
    @Autowired
    private RestTemplate restTemplate;

    //先向客户端发请求(默认都是get请求)，再由客户端向服务端发请求
    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept deptEntity){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.postForObject(
                REST_URL_PREFIX+"/dept/add",
                deptEntity,
                Boolean.class);
    }
//    @RequestMapping(value = "/consumer/dept/test")
//    public void test(Integer id){
//        System.out.println(id);
//    }
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        //get只有两个参数
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/get/"+id,
                Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/list",
                List.class);
    }


    
    @RequestMapping(value="/consumer/dept/discovery") 
    public Object discovery()
    {
     return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
    } 

}
