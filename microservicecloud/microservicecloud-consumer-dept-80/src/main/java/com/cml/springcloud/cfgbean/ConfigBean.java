package com.cml.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {//boot	-->spring  applicationContext.xml=@Configuration配置
//  
  @Bean	
  @LoadBalanced
  public RestTemplate getRestTemplate() {
	  return new RestTemplate();
  }
//  
////  修改LB算法
//  @Bean
//  public IRule myRule() {
//	  return new RandomRule();  //设为bean就能覆盖默认的轮询
//  }
 
}
//@Bean
//public UserService getUserService() {
//	return new UserServiceImpl();
//	
//}
//
////<bean id="userService" class="com.cml.springcloud.UserServiceImpl">
