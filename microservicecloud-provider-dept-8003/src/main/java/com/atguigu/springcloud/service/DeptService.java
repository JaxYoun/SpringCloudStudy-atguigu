package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;

import java.util.List;

/**
 * Created by 王柳
 * Date 2019/8/10 20:34
 * version:1.0
 */
public interface DeptService
{
    public boolean add(Dept dept);
    public Dept    get(Long id);
    public List<Dept> list();
}
