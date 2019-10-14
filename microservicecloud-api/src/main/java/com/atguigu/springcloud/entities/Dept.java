package com.atguigu.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by 王柳
 * Date 2019/8/8 22:43
 * version:1.0
 */
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable //必须序列化
{
    //主键
    private Long deptno;

    //部门名称
    private String dname;

    //来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String db_source;

    public Dept(String dname) {
        super();
        this.dname = dname;
    }
}
