package com.atguigu.springcloud.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.atguigu.springcloud.entities.Dept;

/**
 * Created by 王柳
 * Date 2019/8/10 20:25
 * version:1.0
 */
@Mapper
public interface DeptDao {

     boolean addDept(Dept dept);

     Dept findById(Long id);

     List<Dept> findAll();
}
