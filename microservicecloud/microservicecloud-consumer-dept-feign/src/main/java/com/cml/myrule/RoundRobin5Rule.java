package com.cml.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

public class RoundRobin5Rule extends AbstractLoadBalancerRule {

	@Override
	public Server choose(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
  

}
