package com.cml.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cml.springcloud.dao.DeptDao;
import com.cml.springcloud.entities.Dept;
import com.cml.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
    
	@Autowired
	private DeptDao dao;
	
	@Override
	public boolean add(Dept deptEntity){
		// TODO Auto-generated method stub
		return dao.addDept(deptEntity);
	}

	@Override
	public Dept get(Long deptNo) {
		// TODO Auto-generated method stub
		return dao.findById(deptNo);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
