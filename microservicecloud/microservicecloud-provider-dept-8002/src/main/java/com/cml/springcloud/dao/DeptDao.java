package com.cml.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cml.springcloud.entities.Dept;



@Mapper
public interface DeptDao {

    /**
     * 插入
     * @param deptEntity
     *
     * @return
     */
    boolean addDept(Dept deptEntity);

    /**
     * 根据id查找
     * @param deptNo
     * @return
     */
    Dept findById(Long deptNo);

    /**
     * 查询全部
     * @return
     */
    List<Dept> findAll();

}
