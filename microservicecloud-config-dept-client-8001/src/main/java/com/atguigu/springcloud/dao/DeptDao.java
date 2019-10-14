package com.atguigu.springcloud.dao;


import com.atguigu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
