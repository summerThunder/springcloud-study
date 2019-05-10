package com.cml.springcloud.service;

import java.util.List;

import com.cml.springcloud.entities.Dept;



public interface DeptService {
	/**
     * 插入
     * @param deptEntity
     * @return
     */
	//add,get,list更加具有rest风格
    boolean add(Dept deptEntity);

    /**
     * 根据id查找
     * @param deptNo
     * @return
     */
    Dept get(Long deptNo);

    /**
     * 查询全部
     * @return
     */
    List<Dept> list();
}
