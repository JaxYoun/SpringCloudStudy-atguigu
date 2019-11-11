SpringCloudStudy-atguigu

根据尚硅谷视频学习搭建的SpringCloud分布式学习框架

------



GitHub地址：

  代码：https://github.com/wangliu1102/SpringCloudStudy-atguigu

  配置文件：https://github.com/wangliu1102/microservicecloud-config



微服务架构SpringCloud：一堆技术的集合体，大概21种技术之多。目前最常用的有五种（**Eureka、Ribbon/Feign、Hystrix、Zuul、SpringCloud  Config**），俗称Cloud技术的五大神兽。

# **一、从面试题开始**

1、什么是微服务？

2、微服务之间是如何独立通讯的？

3、SpringCloud和Dubbo有哪些区别？

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/c3953348-069c-4a49-88eb-b0c6ef310306.jpg)

- 通信机制（本质区别）：Dubbo基于RPC远程过程调用，微服务SpringCloud基于Http的RESTful API调用；

严格来说，这两种方式各有优劣。虽然从一定程度上来说，后者牺牲了服务调用的性能，但也避免了上面提到的原生RPC带来的问题。而且REST相比RPC更为灵活，服务提供方和调用方的依赖只依靠一纸契约，不存在代码级别的强依赖，这在强调快速演化的微服务环境下，显得更加合适。

-  品牌机与组装机的区别

很明显，Spring Cloud的功能比DUBBO更加强大，涵盖面更广，而且作为Spring的拳头项目，它也能够与Spring Framework、Spring Boot、Spring Data、Spring Batch等其他Spring项目完美融合，这些对于微服务而言是至关重要的。使用Dubbo构建的微服务架构就像组装电脑，各环节我们的选择自由度很高，但是最终结果很有可能因为一条内存质量不行就点不亮了，总是让人不怎么放心，但是如果你是一名高手，那这些都不是问题；而Spring Cloud就像品牌机，在Spring Source的整合下，做了大量的兼容性测试，保证了机器拥有更高的稳定性，但是如果要在使用非原装组件外的东西，就需要对其基础有足够的了解。

-  社区支持与更新力度

最为重要的是，DUBBO停止了5年左右的更新，虽然2017.7重启了。对于技术发展的新需求，需要由开发者自行拓展升级（比如当当网弄出了DubboX），这对于很多想要采用微服务架构的中小软件组织，显然是不太合适的，中小公司没有这么强大的技术能力去修改Dubbo源码+周边的一整套解决方案，并不是每一个公司都有阿里的大牛+真实的线上生产环境测试过。

4、SpringBoot和SpringCloud，请你谈谈对他们的理解？

5、什么是服务熔断？什么是服务降级？

6、微服务的优缺点分别是什么？说下你在项目开发中碰到的坑。

7、你所知道的微服务技术栈有哪些？请列举一二。

8、Eureka和Zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？

# 二、微服务概述

微服务：强调的是服务的大小，它关注的是某一个点，是具体解决某一个问题/提供落地对应服务的一个服务应用,狭意的看,可以看作Eclipse里面的一个个微服务工程/或者Module。

微服务架构：是⼀种架构模式或者说是一种架构风格，它提倡将单⼀应⽤程序划分成⼀组⼩的服务，每个服务运行在其独立的自己的进程中，服务之间互相协调、互相配合，为⽤户提供最终价值。服务间采⽤轻量级的通信机制互相协作（通常是基于HTTP协议的RESTful API）。每个服务都围绕着具体业务进⾏构建，并且能够被独⽴的部署到⽣产环境、类⽣产环境等。另外，应当尽量避免统⼀的、集中式的服务管理机制，对具体的⼀个服务⽽⾔，应根据业务上下⽂，选择合适的语⾔、⼯具对其进⾏构建。可以有一个非常轻量级的集中式管理来协调这些服务，可以使用不同的语言来编写服务，也可以使用不同的数据存储。

技术维度理解：微服务化的核心就是将传统的一站式应用，根据业务拆分成一个一个的服务，彻底地去耦合,每一个微服务提供单个业务功能的服务，一个服务做一件事，从技术角度看就是一种小而独立的处理过程，类似进程概念，能够自行单独启动或销毁，拥有自己独立的数据库。

微服务优缺点

优点：

   每个服务足够内聚，足够小，代码容易理解这样能聚焦一个指定的业务功能或业务需求；

  开发简单、开发效率提高，一个服务可能就是专一的只干一件事；

  微服务能够被小团队单独开发，这个小团队是2到5人的开发人员组成；

  微服务是松耦合的，是有功能意义的服务，无论是在开发阶段或部署阶段都是独立的；

  微服务能使用不同的语言开发；

  易于和第三方集成，微服务允许容易且灵活的方式集成自动部署，通过持续集成工具，如Jenkins,Hudson,bamboo；

  微服务易于被一个开发人员理解，修改和维护，这样小团队能够更关注自己的工资成果。无需通过合作才能体现价值；

  微服务允许你利用融合最新技术；

  微服务只是业务逻辑的代码，不会和HTML,CSS或其他界面组件混合；

  每个微服务都有自己的存储能力，可以有自己的数据库。也可以有统一的数据库。

缺点：

  开发人员要处理分布式系统的复杂性；

  多服务运维难度，随着服务的增加，运维的压力也在增大；

  系统部署依赖；

  服务间通信成本；

  数据一致性；

  系统集成测试；

  性能监控。

微服务技术栈： 多种技术的集合体。

| 微服务条目                             | 落地技术                                                     | 备注 |
| -------------------------------------- | ------------------------------------------------------------ | ---- |
| 服务开发                               | SpringBoot、Spring、SpringMvc                                |      |
| 服务配置与管理                         | Netflix公司的Archaius、阿里的Diamond等                       |      |
| 服务注册与发现                         | Eureka、Consul、Zookeeper等                                  |      |
| 服务调用                               | Rest、RPC、gRPC                                              |      |
| 服务熔断器                             | Hystrix、Envoy等                                             |      |
| 负载均衡                               | Ribbon、Nginx等                                              |      |
| 服务接口调用(客户端调用服务的简化工具) | Feign等                                                      |      |
| 消息队列                               | Kafka、RabbitMQ、ActiveMQ等                                  |      |
| 服务配置中心管理                       | SpringCloudConfig、Chef等                                    |      |
| 服务路由（API网关）                    | Zuul等                                                       |      |
| 服务监控                               | Zabbix、Nagios、Metrics、Spectator等                         |      |
| 全链路追踪                             | Zipkin，Brave、Dapper等                                      |      |
| 服务部署                               | Docker、OpenStack、Kubernetes等                              |      |
| 数据流操作开发包                       | SpringCloud Stream（封装与Redis,Rabbit、Kafka等发送接收消息） |      |
| 事件消息总线                           | Spring Cloud Bus                                             |      |
| 。。。。。。                           |                                                              |      |

# 三、SpringCloud入门概述

为什么选择SpringCloud作为微服务架构？

选型依据：

​    整体解决方案和框架成熟度

​    社区热度

​    可维护性

​    学习曲线

当前各大IT公司用的微服务架构有哪些：

​    阿里Dubbo/HSF

​    京东JSF

​    新浪微博Motan

​    当当网DubboX

各微服务框架对比：

| 功能点/服务框架 | Netflix/Spring Cloud                                         | Motan                                                        | gRPC                    | Thrift   | Dubbo/DubboX                 |
| --------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ----------------------- | -------- | ---------------------------- |
| 功能定位        | 完整的微服务框架                                             | RPC框架，但整合了ZooKeeper或Consul，实现集群环境的基本的服务注册/发现 | RPC框架                 | RPC框架  | 服务框架                     |
| 支持Rest        | 是，Ribbon支持多种可插拔的序列化选择                         | 否                                                           | 否                      | 否       | 否                           |
| 支持RPC         | 否                                                           | 是（Hession2）                                               | 是                      | 是       | 是                           |
| 支持多语言      | 是（REST形式）                                               | 否                                                           | 是                      | 是       | 否                           |
| 服务注册/发现   | 是（Eureka） Eureka服务注册表，Karyon服务端框架支持服务自注册和健康检查 | 是（Zookeeper/Consul）                                       | 否                      | 否       | 是                           |
| 负载均衡        | 是（服务端zuul+客户端Ribbon） Zuul-服务，动态路由  云端负载均衡  Eureka（针对中间层服务器） | 是（客户端）                                                 | 否                      | 否       | 是（客户端）                 |
| 配置服务        | Netflix Archaius  SpringCloud Config Server集中配置          | 是（Zookeeper提供）                                          | 否                      | 否       | 否                           |
| 服务调用链监控  | 是（zuul） Zuul提供边缘服务，API网关                         | 否                                                           | 否                      | 否       | 否                           |
| 高可用/容错     | 是（服务端Hystrix +　客户端Ribbon）                          | 是（客户端）                                                 | 否                      | 否       | 是（客户端）                 |
| 典型应用案例    | Netflix                                                      | Sina                                                         | Google                  | Facebook |                              |
| 社区活跃程度    | 高                                                           | 一般                                                         | 高                      | 一般     | 有段时间不维护，后面重启维护 |
| 学习难度        | 中等                                                         | 低                                                           | 高                      | 高       | 低                           |
| 文档丰富度      | 高                                                           | 一般                                                         | 一般                    | 一般     | 高                           |
| 其他            | SpringCloud Bus为我们的应用程序带来更多管理端点              | 支持降级                                                     | Netflix内部开发集成gRPC | IDL定义  | 实践的公司比较多             |

SpringCloud：基于SpringBoot提供了一套微服务解决方案，包括服务注册与发现，配置中心，全链路监控，服务网关，负载均衡，熔断器等组件，除了基于NetFlix的开源组件做高度抽象封装之外，还有一些选型中立的开源组件。分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的集合体，俗称微服务全家桶。

 

SpringCloud利用SpringBoot的开发便利性巧妙地简化了分布式系统基础设施的开发，SpringCloud为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等,它们都可以用SpringBoot的开发风格做到一键启动和部署。

 

SpringBoot并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。

SpringCloud和SpringBoot是什么关系：

- SpringBoot专注于快速方便的开发单个个体微服务。SpringCloud是关注全局的微服务协调整理治理框架，它将SpringBoot开发的一个个单体微服务整合并管理起来，为各个微服务之间提供，配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等集成服务

-  SpringBoot可以离开SpringCloud独立使用开发项目，但是SpringCloud离不开SpringBoot，属于依赖的关系。
-  SpringBoot专注于快速、方便的开发单个微服务个体，SpringCloud关注全局的服务治理框架。

 

# 四、Rest微服务构建案例工程模块

构建步骤：

**1、microservicecloud整体父工程Project**

  ① 新建父工程microservicecloud，切记是Packageing是pom模式。主要是定义POM文件，将后续各个子模块公用的jar包等统一提出来，类似一个抽象父类。

IDEA中直接新建空的Maven项目即可，不勾选Create from archetype

   ![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/533f2293-72a2-4588-9686-c78bf1888e00.png)

  ② POM文件

 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.atguigu.springcloud</groupId>
  <artifactId>microservicecloud</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>pom</packaging>

  <properties>
   <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
   <maven.compiler.source>1.8</maven.compiler.source>
   <maven.compiler.target>1.8</maven.compiler.target>
   <junit.version>4.12</junit.version>
   <log4j.version>1.2.17</log4j.version>
   <lombok.version>1.16.18</lombok.version>
  </properties>

  <dependencyManagement>
   <dependencies>
     <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-dependencies</artifactId>
       <version>Dalston.SR1</version>
       <type>pom</type>
       <scope>import</scope>
     </dependency>
     <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-dependencies</artifactId>
       <version>1.5.9.RELEASE</version>
       <type>pom</type>
       <scope>import</scope>
     </dependency>
     <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>5.0.4</version>
     </dependency>
     <dependency>
       <groupId>com.alibaba</groupId>
       <artifactId>druid</artifactId>
       <version>1.0.31</version>
     </dependency>
     <dependency>
       <groupId>org.mybatis.spring.boot</groupId>
       <artifactId>mybatis-spring-boot-starter</artifactId>
       <version>1.3.0</version>
     </dependency>
     <dependency>
       <groupId>ch.qos.logback</groupId>
       <artifactId>logback-core</artifactId>
       <version>1.2.3</version>
     </dependency>
     <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>${junit.version}</version>
       <scope>test</scope>
     </dependency>
     <dependency>
       <groupId>log4j</groupId>
       <artifactId>log4j</artifactId>
       <version>${log4j.version}</version>
     </dependency>
   </dependencies>
  </dependencyManagement>
</project>
```

**2、microservicecloud-api公共子模块Module**

① 新建microservicecloud-api，在microservicecloud下新建Maven Module子项目

创建完成后请回到父工程查看pom文件变化，多出如下部分：

 

```
<project>
  ...
  <modules>
    <module>microservicecloud-api</module>
  </modules>
</project>
```

② 修改POM文件

 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent><!-- 子类里面显示声明才能有明确的继承表现，无意外就是父类的默认版本否则自己定义 -->
   <groupId>com.atguigu.springcloud</groupId>
   <artifactId>microservicecloud</artifactId>
   <version>0.0.1-SNAPSHOT</version>
  </parent>
    
  <artifactId>microservicecloud-api</artifactId><!-- 当前Module我自己叫什么名字 -->

  <dependencies><!-- 当前Module需要用到的jar包，按自己需求添加，如果父类已经包含了，可以不用写版本号 -->
   <dependency>
     <groupId>org.projectlombok</groupId>
     <artifactId>lombok</artifactId>
   </dependency>
  </dependencies>

</project>
```

③ 新建部门Entity且配合lombok使用

 

```
 
package com.atguigu.springcloud.entities;
 
import java.io.Serializable;
 
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
 
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable //必须序列化
{
  private Long  deptno;   //主键
  private String  dname;   //部门名称
  private String  db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
  
  public Dept(String dname)
  {
   super();
   this.dname = dname;
  }
}
```

④ mvn clean install后给其它模块引用，达到通用目的。也即需要用到部门实体的话，不用每个工程都定义一份，直接引用本模块即可。

3、microservicecloud-provider-dept-8001  部门微服务提供者Module

（1）新建microservicecloud-provider-dept-8001，在microservicecloud下新建Maven Module子项目

（2）修改POM文件

 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.atguigu.springcloud</groupId>
        <artifactId>microservicecloud</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>microservicecloud-provider-dept-8001</artifactId>

    <dependencies>
        <dependency><!-- 引入自己定义的api通用包，可以使用Dept部门Entity -->
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>microservicecloud-api</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.17</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.12</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.0</version>
        </dependency>
        <!-- 修改后立即生效，热部署 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>springloaded</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>

</project>
```

（3）新建application.yml

 

```
server:
  port: 8001
debug: true  
mybatis:
  config-location: classpath:mybatis/mybatis.cfg.xml        # mybatis配置文件所在路径
  type-aliases-package: com.atguigu.springcloud.entities    # 所有Entity别名类所在包
  mapper-locations:
  - classpath:mybatis/mapper/**/*.xml                       # mapper映射文件
    
spring:
   application:
    name: microservicecloud-dept 
   datasource:
    type: com.alibaba.druid.pool.DruidDataSource            # 当前数据源操作类型
    driver-class-name: org.gjt.mm.mysql.Driver              # mysql驱动包
    url: jdbc:mysql://localhost:3306/cloudDB01              # 数据库名称
    username: root
    password: 123456
    dbcp2:
      min-idle: 5                                           # 数据库连接池的最小维持连接数
      initial-size: 5                                       # 初始化连接数
      max-total: 5                                          # 最大连接数
      max-wait-millis: 200                                  # 等待连接获取的最大超时时间
```

（4）工程src/main/resources目录下新建mybatis文件夹后新建mybatis.cfg.xml文件

 

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <settings>
   <setting name="cacheEnabled" value="true"/><!-- 二级缓存开启 -->
  </settings>
</configuration>
```

（5）MySQL创建部门数据库脚本

 

```
DROP DATABASE IF EXISTS cloudDB01;
CREATE DATABASE cloudDB01 CHARACTER SET UTF8;
USE cloudDB01;
CREATE TABLE dept
(
  deptno BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  dname VARCHAR(60),
  db_source   VARCHAR(60)
);
 
INSERT INTO dept(dname,db_source) VALUES('开发部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('人事部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('财务部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('市场部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('运维部',DATABASE());
 
SELECT * FROM dept;
```

（6）新建DeptDao部门接口

 

```
package com.atguigu.springcloud.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.atguigu.springcloud.entities.Dept;

@Mapper
public interface DeptDao
{
  public boolean addDept(Dept dept);

  public Dept findById(Long id);

  public List<Dept> findAll();
}
 
```

（7） 工程src/main/resources/mybatis目录下新建mapper文件夹后再建DeptMapper.xml

 

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 
<mapper namespace="com.atguigu.springcloud.dao.DeptDao">
 
  <select id="findById" resultType="Dept" parameterType="Long">
   select deptno,dname,db_source from dept where deptno=#{deptno}; 
  </select>
  <select id="findAll" resultType="Dept">
   select deptno,dname,db_source from dept; 
  </select>
  <insert id="addDept" parameterType="Dept">
   INSERT INTO dept(dname,db_source) VALUES(#{dname},DATABASE());
  </insert>
  
</mapper>
```

（8）新建DeptService部门服务接口

 

```
package com.atguigu.springcloud.service;

import java.util.List;
import com.atguigu.springcloud.entities.Dept;

public interface DeptService
{
   boolean add(Dept dept);
   Dept get(Long id);
   List<Dept> list();
}
```

（9）新建DeptServiceImpl部门服务接口实现类

 

```
package com.atguigu.springcloud.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService
{
  @Autowired
  private DeptDao dao ;
  
  @Override
  public boolean add(Dept dept)
  {
   return dao.addDept(dept);
  }

  @Override
  public Dept get(Long id)
  {
   return dao.findById(id);
  }

  @Override
  public List<Dept> list()
  {
   return dao.findAll();
  }

}
```

（10）DeptController部门微服务提供者REST

 

```
package com.atguigu.springcloud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

@RestController
public class DeptController
{
  @Autowired
  private DeptService service;
  
  @RequestMapping(value="/dept/add",method=RequestMethod.POST)
  public boolean add(@RequestBody Dept dept)
  {
   return service.add(dept);
  }
  
  @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
  public Dept get(@PathVariable("id") Long id)
  {
   return service.get(id);
  }
  
  @RequestMapping(value="/dept/list",method=RequestMethod.GET)
  public List<Dept> list()
  {
   return service.list();
  }
}
```

（11）DeptProvider8001_App主启动类DeptProvider8001_App

 

```
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeptProvider8001_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(DeptProvider8001_App.class, args);
  }
}
```

（12）测试

 

```
http://localhost:8001/dept/get/2
http://localhost:8001/dept/list
```

4、microservicecloud-consumer-dept-80 部门微服务消费者Module

（1）新建microservicecloud-consumer-dept-80，在microservicecloud下新建Maven Module子项目

（2）修改POM文件

 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
   <groupId>com.atguigu.springcloud</groupId>
   <artifactId>microservicecloud</artifactId>
   <version>0.0.1-SNAPSHOT</version>
  </parent>

  <artifactId>microservicecloud-consumer-dept-80</artifactId>
  <description>部门微服务消费者</description>

  <dependencies>
   <dependency><!-- 自己定义的api -->
     <groupId>com.atguigu.springcloud</groupId>
     <artifactId>microservicecloud-api</artifactId>
     <version>${project.version}</version>
   </dependency> 
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   <!-- 修改后立即生效，热部署 -->
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>springloaded</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-devtools</artifactId>
   </dependency>   
  </dependencies>
</project>
```

（3）新建application.yml

 

```
server:
  port: 80
```

（4）com.atguigu.springcloud.cfgbeans包下ConfigBean的编写（类似spring里面的applicationContext.xml写入的注入Bean）

 

```
package com.atguigu.springcloud.cfgbeans;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
 
@Configuration
public class ConfigBean
{
    @Bean
    public RestTemplate getRestTemplate()
    {
         return new RestTemplate();
    }
}
```

（5）com.atguigu.springcloud.controller包下新建DeptController_Consumer部门微服务消费者REST

RestTemplate：

  是什么： RestTemplate提供了多种便捷访问远程Http服务的方法， 是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集。

  官网及使用：

​      官网地址：https://docs.spring.io/spring-framework/docs/4.3.7.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html

​      使用：使用restTemplate访问restful接口非常的简单粗暴无脑。(url, requestMap, ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。

 

```
package com.atguigu.springcloud.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
 
import com.atguigu.springcloud.entities.Dept;
 
@RestController
public class DeptController_Consumer
{
    private static final String REST_URL_PREFIX = "http://localhost:8001";
    
    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
         return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }
    
    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
         return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }
    
    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
         return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }   
}
```

（6）DeptConsumer80_App主启动类

 

```
package com.atguigu.springcloud;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeptConsumer80_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(DeptConsumer80_App.class, args);
  }
}
```

（7）测试

 

```
http://localhost/consumer/dept/get/2
http://localhost/consumer/dept/list
http://localhost/consumer/dept/add?dname=AI
```

# 五、Eureka服务注册与发现

Eureka是什么：Eureka是Netflix的一个子模块，也是核心模块之一。Eureka是一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移。Netflix在设计Eureka时遵守的就是AP原则。服务注册与发现对于微服务架构来说是非常重要的，有了服务发现与注册，只需要使用服务的标识符，就可以访问到服务，而不需要修改服务调用的配置文件了。功能类似于dubbo的注册中心，比如Zookeeper。

Eureka的基本架构： 

- Spring Cloud 封装了 Netflix 公司开发的 Eureka 模块来实现服务注册和发现(请对比Zookeeper)。
- Eureka 采用了 C-S 的设计架构。Eureka Server 作为服务注册功能的服务器，它是服务注册中心。
- 而系统中的其他微服务，使用 Eureka 的客户端连接到 Eureka Server并维持心跳连接。这样系统的维护人员就可以通过 Eureka Server 来监控系统中各个微服务是否正常运行。SpringCloud 的一些其他模块（比如Zuul）就可以通过 Eureka Server 来发现系统中的其他微服务，并执行相关的逻辑。

请注意和Dubbo的架构对比

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/31f40d44-80d8-43a2-ae97-dade08bf1dce.jpg)![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/98639013-b79b-4811-a640-d48e4f6c8f2e.jpg)Eureka包含两个组件：Eureka Server和Eureka Client

Eureka Server提供服务注册服务，各个节点启动后，会在EurekaServer中进行注册，这样EurekaServer中的服务注册表中将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观的看到。

Eureka Client是一个Java客户端，用于简化Eureka Server的交互，客户端同时也具备一个内置的、使用轮询(round-robin)负载算法的负载均衡器。在应用启动后，将会向Eureka Server发送心跳(默认周期为30秒)。如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，EurekaServer将会从服务注册表中把这个服务节点移除（默认90秒）。

三大角色：

- Eureka Server 提供服务注册和发现；
- Service Provider服务提供方将自身服务注册到Eureka，从而使服务消费方能够找到；
- Service Consumer服务消费方从Eureka获取注册服务列表，从而能够消费服务。 

构建步骤：

1、microservicecloud-eureka-7001 eureka服务注册中心Module

（1）新建microservicecloud-eureka-7001，在microservicecloud下新建Maven Module子项目

（2）修改POM

 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
   <groupId>com.atguigu.springcloud</groupId>
   <artifactId>microservicecloud</artifactId>
   <version>0.0.1-SNAPSHOT</version>
  </parent>

  <artifactId>microservicecloud-eureka-7001</artifactId>

  <dependencies>
   <!--eureka-server服务端 -->
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-eureka-server</artifactId>
   </dependency>
   <!-- 修改后立即生效，热部署 -->
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>springloaded</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-devtools</artifactId>
   </dependency>
  </dependencies>
</project>
```

（3）新建application.yml

 

```
server: 
  port: 7001
 
eureka:
  instance:
    hostname: localhost #eureka服务端的实例名称
  client:
    register-with-eureka: false #false表示不向注册中心注册自己。
    fetch-registry: false #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/        #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址。
```

（4）EurekaServer7001_App主启动类

 

```
package com.atguigu.springcloud;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
 
@SpringBootApplication
@EnableEurekaServer//EurekaServer服务器端启动类,接受其它微服务注册进来
public class EurekaServer7001_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(EurekaServer7001_App.class, args);
  }
}
```

 （5）测试

No application available 没有服务被发现 O(∩_∩)O

因为没有注册服务进来当然不可能有服务被发现

 

```
http://localhost:7001/
```

2、microservicecloud-provider-dept-8001将已有的部门微服务注册进eureka服务中心

（1）修改microservicecloud-provider-dept-8001

（2）修改POM

 

```
    <!-- 将微服务provider侧注册进eureka -->
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-eureka</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-config</artifactId>
   </dependency>
```

（3）修改application.yml

 

```
eureka:
  client: #客户端注册进eureka服务列表内
    service-url: 
      defaultZone: http://localhost:7001/eureka
```

（4）DeptProvider8001_App主启动类

 

```
package com.atguigu.springcloud;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
 
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
public class DeptProvider8001_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(DeptProvider8001_App.class, args);
  }
}
```

（5）测试

先要启动EurekaServer

 

```
http://localhost:7001/
```

微服务注册名配置说明：

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/019d8e76-c7fa-42cd-abc6-56e38a948241.jpg)

3、actuator与注册微服务信息完善

（1）主机名称:服务名称修改

当前问题：含有主机名称。

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/800b856b-0e76-4994-a254-044cfd3df2e6.jpg)修改microservicecloud-provider-dept-8001，修改application.yml：

 

```
eureka:
  client: #客户端注册进eureka服务列表内
    service-url: 
      defaultZone: http://localhost:7001/eureka
  instance:
    instance-id: microservicecloud-dept8001
```

（2）访问信息有IP信息提示

当前问题：没有IP提示。

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/3876592e-4a87-4238-98d6-7bab12648dfb.jpg)

修改microservicecloud-provider-dept-8001，修改application.yml：

 

```
eureka:
  client: #客户端注册进eureka服务列表内
    service-url: 
      defaultZone: http://localhost:7001/eureka
  instance:
    instance-id: microservicecloud-dept8001   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址
 
```

（3）微服务info内容详细信息

当前问题：超链接点击服务报告ErrorPage。

修改microservicecloud-provider-dept-8001，修改POM:

 

```
    <!--actuator监控信息完善-->
    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
```

总的父工程microservicecloud修改pom.xml添加构建build信息，clean-install后即可：

 

```
<build>
   <finalName>microservicecloud</finalName>
   <resources>
     <resource>
       <directory>src/main/resources</directory>
       <filtering>true</filtering>
     </resource>
   </resources>
   <plugins>
     <plugin>
       <groupId>org.apache.maven.plugins</groupId>
       <artifactId>maven-resources-plugin</artifactId>
       <configuration>
         <delimiters>
          <delimit>$</delimit>
         </delimiters>
       </configuration>
     </plugin>
   </plugins>
  </build>
```

修改microservicecloud-provider-dept-8001，修改application.yml：

 

```
info:
  app.name: atguigu-microservicecloud
  company.name: www.atguigu.com
  build.artifactId: $project.artifactId$
  build.version: $project.version$
```

**4、eureka自我保护**

故障现象： 

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/22536531-7db0-48a2-af56-9246f8545920.png)

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/1cbc4511-a3fa-4ad9-a1d2-6f52d69d0a28.jpg)

导致原因：一句话：某时刻某一个微服务不可用了，eureka不会立刻清理，依旧会对该微服务的信息进行保存。

自我保护模式：默认情况下，如果EurekaServer在一定时间内没有接收到某个微服务实例的心跳，EurekaServer将会注销该实例（默认90秒）。但是当网络分区故障发生时，微服务与EurekaServer之间无法正常通信，以上行为可能变得非常危险了——因为微服务本身其实是健康的，此时本不应该注销这个微服务。Eureka通过“自我保护模式”来解决这个问题——当EurekaServer节点在短时间内丢失过多客户端时（可能发生了网络分区故障），那么这个节点就会进入自我保护模式。一旦进入该模式，EurekaServer就会保护服务注册表中的信息，不再删除服务注册表中的数据（也就是不会注销任何微服务）。当网络故障恢复后，该Eureka Server节点会自动退出自我保护模式。

在自我保护模式中，Eureka Server会保护服务注册表中的信息，不再注销任何服务实例。当它收到的心跳数重新恢复到阈值以上时，该Eureka Server节点就会自动退出自我保护模式。它的设计哲学就是宁可保留错误的服务注册信息，也不盲目注销任何可能健康的服务实例。一句话讲解：好死不如赖活着。

 综上，自我保护模式是一种应对网络异常的安全保护措施。它的架构哲学是宁可同时保留所有微服务（健康的微服务和不健康的微服务都会保留），也不盲目注销任何健康的微服务。使用自我保护模式，可以让Eureka集群更加的健壮、稳定。

 在Spring Cloud中，可以使用eureka.server.enable-self-preservation = false 禁用自我保护模式。

 

5、microservicecloud-provider-dept-8001服务发现Discovery

（1）对于注册进Eureka里面的微服务，可以通过服务发现来获得该服务的信息。

（2）修改microservicecloud-provider-dept-8001工程的DeptController

 

```
    @Resource
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("************" + list);

        List<ServiceInstance> serviceInstanceList = client.getInstances("microservicecloud-dept");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            System.out.println(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }

        return this.client;
    }
```

（3）DeptProvider8001_App主启动类

 

```
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient // 服务发现
public class DeptProvider8001_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}
```

（4）自测

先要启动EurekaServer。

再启动DeptProvider8001_App主启动类。

 

```
http://localhost:8001/dept/discovery
```

（5）修改microservicecloud-consumer-dept-80工程的DeptController_Consumer

 

```
    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
    }

http://localhost/consumer/dept/discovery
```



集群配置：

1、新建microservicecloud-eureka-7002/microservicecloud-eureka-7003


2、按照7001为模板粘贴POM

3、修改7002和7003的主启动类

4、修改映射配置

（1）找到C:\Windows\System32\drivers\etc路径下的hosts文件

（2）修改映射配置添加进hosts文件

 

```
127.0.0.1  eureka7001.com
127.0.0.1  eureka7002.com
127.0.0.1  eureka7003.com
```

5、3台eureka服务器的yml配置

7001：

 

```
server: 
  port: 7001
 
eureka: 
  instance:
    hostname: eureka7001.com #eureka服务端的实例名称
  client: 
    register-with-eureka: false     #false表示不向注册中心注册自己。
    fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url: 
      #单机 defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/       #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址（单机）。
      defaultZone: http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
```

7002：

 

```
server: 
  port: 7002

eureka: 
  instance:
    hostname: eureka7002.com #eureka服务端的实例名称
  client: 
    register-with-eureka: false     #false表示不向注册中心注册自己。
    fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url: 
      #defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/       #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址。
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7003.com:7003/eureka/
```

7003：

 

```
server: 
  port: 7003

eureka: 
  instance:
    hostname: eureka7003.com #eureka服务端的实例名称
  client: 
    register-with-eureka: false     #false表示不向注册中心注册自己。
    fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url: 
      #defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/       #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址。
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/
```

6、microservicecloud-provider-dept-8001微服务发布到上面3台eureka集群配置中

 

```
server:
  port: 8001
  
mybatis:
  config-location: classpath:mybatis/mybatis.cfg.xml  #mybatis所在路径
  type-aliases-package: com.atguigu.springcloud.entities #entity别名类
  mapper-locations:
  - classpath:mybatis/mapper/**/*.xml #mapper映射文件
    
spring:
   application:
    name: microservicecloud-dept 
   datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: org.gjt.mm.mysql.Driver
    url: jdbc:mysql://localhost:3306/cloudDB01
    username: root
    password: 123456
    dbcp2:
      min-idle: 5
      initial-size: 5
      max-total: 5
      max-wait-millis: 200
      
eureka:
  client: #客户端注册进eureka服务列表内
    service-url: 
      #defaultZone: http://localhost:7001/eureka
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
  instance:
    instance-id: microservicecloud-dept8001   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址
      
info:
  app.name: atguigu-microservicecloud
  company.name: www.atguigu.com
  build.artifactId: $project.artifactId$
  build.version: $project.version$
```

7、测试

 

```
http://eureka7001.com:7001/
http://eureka7002.com:7002/
http://eureka7003.com:7003/
```

**作为服务注册中心，Eureka比Zookeeper好在哪里：**

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/b6f8be03-cd3b-4653-bf1c-aef682d878a0.jpg)

著名的CAP理论指出，一个分布式系统不可能同时满足C（一致性）、A（可用性）和P（分区容错性）。由于分区容错性P是分布式系统中必须要保证的，因此我们只能在A和C之间进行权衡。

Eureka遵守AP原则，Zookeeper遵守CP原则。

Zookeeper：当向注册中心查询服务列表时，我们可以容忍注册中心返回的是几分钟以前的注册信息，但不能接受服务之间down掉不可用。也就是说，服务注册功能对可用性的要求要高于一致性。但是Zookeeper会出现这样一种情况，但master节点因为网络故障与其他节点失去联系时，剩余节点会重新进行leader选举。问题在于，选举leader的实际太长，30~120s，且选举期间整个Zookeeper集群都是不可用的，这就导致在选举期间注册服务瘫痪。在云部署的环境下，因网络问题使得Zookeeper集群失去master节点是较大概率会发生的事，虽然服务能够最终恢复，但是漫长的选举时间导致的注册长期不可用是不能容忍的。

Eureka：Eureka看明白了这一点，因此在设计时就优先保证可用性。Eureka各个节点都是平等的，几个节点挂掉不会影响正常节点的工作，剩余的节点依然可以提供注册和查询服务。而Eureka的客户端在向某个Eureka注册时如果发现连接失败，则会自动切换至其他节点，只要有一台Eureka还在，就能保证注册服务可用（保证可用性），只不过查到的信息可能不是最新的（不保证强一致性）。除此之外，Eureka还有一种自我保护机制，如果在15分钟内超过85%的节点都没有正常的心跳，那么Eureka就任务客户端与注册中心出现了网络故障，此时会出现以下几种情况：

（1）、Eureka不再从注册列表中移除因为长时间没收到心跳而应该过期的服务

（2）、Eureka仍然能够接受新服务的注册和查询请求，但是不会被同步到其他节点上（即保证当前节点依然可用）

（3）、当网络稳定时，当前实例新的注册信息会被同步到其他节点中

因此，Eureka可用很好的应对因网络故障导致部分节点失去联系的情况，而不会像Zookeeper那样使整个注册服务瘫痪。

# 六、Ribbon负载均衡

Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。

 

简单的说，Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法，将Netflix的中间层服务连接在一起。Ribbon客户端组件提供一系列完善的配置项如连接超时，重试等。简单的说，就是在配置文件中列出Load Balancer（简称LB）后面所有的机器，Ribbon会自动的帮助你基于某种规则（如简单轮询，随机连接等）去连接这些机器。我们也很容易使用Ribbon实现自定义的负载均衡算法。

LB（负载均衡）：LB，即负载均衡(Load Balance)，在微服务或分布式集群中经常用的一种应用。负载均衡简单的说就是将用户的请求平摊的分配到多个服务上，从而达到系统的HA。常见的负载均衡有软件Nginx，LVS，硬件 F5等。相应的在中间件，例如：dubbo和SpringCloud中均给我们提供了负载均衡，SpringCloud的负载均衡算法可以自定义。 

集中式LB：即在服务的消费方和提供方之间使用独立的LB设施(可以是硬件，如F5, 也可以是软件，如nginx), 由该设施负责把访问请求通过某种策略转发至服务的提供方。

进程内LB：将LB逻辑集成到消费方，消费方从服务注册中心获知有哪些地址可用，然后自己再从这些地址中选择出一个合适的服务器。Ribbon就属于进程内LB，它只是一个类库，集成于消费方进程，消费方通过它来获取到服务提供方的地址。

官网资料：https://github.com/Netflix/ribbon/wiki/Getting-Started

**Ribbon配置初步：**

1、修改microservicecloud-consumer-dept-80工程

2、修改pom.xml文件

 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
 
  <parent>
   <groupId>com.atguigu.springcloud</groupId>
   <artifactId>microservicecloud</artifactId>
   <version>0.0.1-SNAPSHOT</version>
  </parent>
 
  <artifactId>microservicecloud-consumer-dept-80</artifactId>
  <description>部门微服务消费者</description>
 
  <dependencies>
   <dependency><!-- 自己定义的api -->
     <groupId>com.atguigu.springcloud</groupId>
     <artifactId>microservicecloud-api</artifactId>
     <version>${project.version}</version>
   </dependency>
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   <!-- 修改后立即生效，热部署 -->
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>springloaded</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-devtools</artifactId>
   </dependency>
   <!-- Ribbon相关 -->
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-eureka</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-ribbon</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-config</artifactId>
   </dependency>
  </dependencies>
</project>
```

3、修改application.yml   追加eureka的服务注册地址

 

```
server:
  port: 80
  
eureka:
  client:
    register-with-eureka: false
    service-url: 
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
```

4、对ConfigBean进行新注解@LoadBalanced    获得Rest时加入Ribbon的配置

 

```
package com.atguigu.springcloud.cfgbeans;
 
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
 
@Configuration
public class ConfigBean
{
  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate()
  {
   return new RestTemplate();
  }
}
```

5、主启动类DeptConsumer80_App添加@EnableEurekaClient

 

```
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer80_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(DeptConsumer80_App.class, args);
  }
}
```

6、修改DeptController_Consumer客户端访问类

 

```
package com.atguigu.springcloud.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
 
import com.atguigu.springcloud.entities.Dept;
 
@RestController
public class DeptController_Consumer
{
  //private static final String REST_URL_PREFIX = "http://localhost:8001";
  private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
  
  @Autowired
  private RestTemplate restTemplate;
  
  @RequestMapping(value="/consumer/dept/add")
  public boolean add(Dept dept)
  {
   return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
  }
  
  @RequestMapping(value="/consumer/dept/get/{id}")
  public Dept get(@PathVariable("id") Long id)
  {
   return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
  }
  
  @SuppressWarnings("unchecked")
  @RequestMapping(value="/consumer/dept/list")
  public List<Dept> list()
  {
   return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
  } 
}
```

7、先启动3个eureka集群后，再启动microservicecloud-provider-dept-8001并注册进eureka

8、启动microservicecloud-consumer-dept-80

9、测试

 

```
http://localhost/consumer/dept/get/1
http://localhost/consumer/dept/list
http://localhost/consumer/dept/add?dname=大数据部
```

10、Ribbon和Eureka整合后Consumer可以直接调用服务而不用再关心地址和端口号

**Ribbon负载均衡**：

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/4dbcc332-36d5-4a9a-bdd2-b33a9a830ad5.jpg)

Ribbon在工作时分成两步：

- 第一步先选择 EurekaServer ,它优先选择在同一个区域内负载较少的server；
- 第二步再根据用户指定的策略，在从server取到的服务注册列表中选择一个地址。

其中Ribbon提供了多种策略：比如轮询、随机和根据响应时间加权。

1、参考microservicecloud-provider-dept-8001，新建两份，分别命名为8002，8003

2、新建8002/8003数据库，各自微服务分别连各自的数据库

8002SQL脚本：

 

```
DROP DATABASE IF EXISTS cloudDB02;
 
CREATE DATABASE cloudDB02 CHARACTER SET UTF8;

USE cloudDB02;

CREATE TABLE dept
(
  deptno BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  dname VARCHAR(60),
  db_source   VARCHAR(60)
);
 
INSERT INTO dept(dname,db_source) VALUES('开发部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('人事部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('财务部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('市场部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('运维部',DATABASE());
 
SELECT * FROM dept;
```

8003SQL脚本：

 

```
DROP DATABASE IF EXISTS cloudDB03;

CREATE DATABASE cloudDB03 CHARACTER SET UTF8;

USE cloudDB03;

CREATE TABLE dept
(
  deptno BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  dname VARCHAR(60),
  db_source   VARCHAR(60)
);

INSERT INTO dept(dname,db_source) VALUES('开发部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('人事部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('财务部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('市场部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('运维部',DATABASE());

SELECT * FROM dept;
```

3、修改8002/8003各自YML

8002YML：

 

```
server:
  port: 8002
  
mybatis:
  config-location: classpath:mybatis/mybatis.cfg.xml  #mybatis所在路径
  type-aliases-package: com.atguigu.springcloud.entities #entity别名类
  mapper-locations:
  - classpath:mybatis/mapper/**/*.xml #mapper映射文件
    
spring:
   application:
    name: microservicecloud-dept 
   datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: org.gjt.mm.mysql.Driver
    url: jdbc:mysql://localhost:3306/cloudDB02
    username: root
    password: 123456
    dbcp2:
      min-idle: 5
      initial-size: 5
      max-total: 5
      max-wait-millis: 200
      
eureka:
  client: #客户端注册进eureka服务列表内
    service-url: 
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
  instance:
    instance-id: microservicecloud-dept8002   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址
      
info:
  app.name: atguigu-microservicecloud
  company.name: www.atguigu.com
  build.artifactId: $project.artifactId$
  build.version: $project.version$
```

8003YML：

 

```
server:
  port: 8003
  
mybatis:
  config-location: classpath:mybatis/mybatis.cfg.xml  #mybatis所在路径
  type-aliases-package: com.atguigu.springcloud.entities #entity别名类
  mapper-locations:
  - classpath:mybatis/mapper/**/*.xml #mapper映射文件
    
spring:
   application:
    name: microservicecloud-dept 
   datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: org.gjt.mm.mysql.Driver
    url: jdbc:mysql://localhost:3306/cloudDB03
    username: root
    password: 123456
    dbcp2:
      min-idle: 5
      initial-size: 5
      max-total: 5
      max-wait-millis: 200
      
eureka:
  client: #客户端注册进eureka服务列表内
    service-url: 
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
  instance:
    instance-id: microservicecloud-dept8003   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址
      
info:
  app.name: atguigu-microservicecloud
  company.name: www.atguigu.com
  build.artifactId: $project.artifactId$
  build.version: $project.version$
```

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/79b471bf-3df1-4523-bfbe-9cece80a39d7.png)

4、启动3个eureka集群配置区

5、启动3个Dept微服务启动并各自测试通过

 

```
http://localhost:8001/dept/list
http://localhost:8002/dept/list
http://localhost:8003/dept/list
```

6、启动microservicecloud-consumer-dept-80

7、客户端通过Ribbo完成负载均衡并访问上一步的Dept微服务

 

```
http://localhost/consumer/dept/list
注意观察看到返回的数据库名字，各不相同，负载均衡实现
```

总结：Ribbon其实就是一个软负载均衡的客户端组件，他可以和其他所需请求的客户端结合使用，和eureka结合只是其中的一个实例。

**Ribbon核心组件IRule**：

- IRule：根据特定算法中从服务列表中选取一个要访问的服务。
- RoundRobinRule：轮询；
- RandomRule：随机；
- AvailabilityFilteringRule：会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阀值的服务，然后对剩余的服务列表按照轮询策略进行访问；
- WeightedResponseTimeRule：根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，会切换到WeightedResponseTimeRule；
- RetryRule：先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务；
- BestAvailableRule：会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务；
- ZoneAvoidanceRule：默认规则，复合判断server所在区域的性能和server的可用性选择服务器。

 

```
package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean
{
    @Bean
    @LoadBalanced // 默认轮询算法
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        // 达到的目的，用我们重新选择的随机算法替代默认的轮询
        return new RandomRule();
    }
}
```

**自定义Ribbo的负载均衡策略**：

1、修改microservicecloud-consumer-dept-80工程

2、主启动类添加@RibbonClient

在启动该微服务的时候就能去加载我们自定义Ribbon配置类，从而使配置生效：

 

```
@RibbonClient(name = "microservicecloud-dept",configuration = MySelfRule.class)
```

3、注意配置细节

官方文档明确给出了警告：这个自定义配置类（MySelfRule）不能放在@ComponentScan所扫描的当前包下以及子包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是说我们达不到特殊化定制的目的了。

4、步骤

（1）新建package com.atguigu.myrule，新建自定义Ribbon规则类

 

```
package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 王柳
 * Date 2019/8/15 16:14
 * version:1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        // 达到的目的，用我们重新选择的随机算法替代默认的轮询
        return new RandomRule();
    }
}
```

（2）修改主启动类DeptConsumer80_App

 

```
package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "microservicecloud-dept",configuration = MySelfRule.class)
public class DeptConsumer80_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
```

（3）测试，多次刷新

 

```
http://localhost/consumer/dept/list
```

5、自定义规则深度解析

（1）问题：依旧轮询策略，但是加上新需求，每个服务器要求被调用5次。也即以前是每台机器一次，现在是每台机器五次

（2）解析源码：https://github.com/Netflix/ribbon/blob/master/ribbon-loadbalancer/src/main/java/com/netflix/loadbalancer/RandomRule.java 

（3）参考源码修改为我们需求要求的RandomRule_ZY.java

 

```
package com.atguigu.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by 王柳
 * Date 2019/8/15 19:40
 * version:1.0
 */
public class RandomRule_ZY  extends AbstractLoadBalancerRule {

    // total = 0 当total == 5后，我们指针才能往下走
    // index = 0 当前对外提供服务的服务器地址
    // total 需要重新置为0,但是已经达到过一个5次，我们的index = 1
    private int total = 0; // 总共被调用的次数，目前要求每台被调用5次
    private int currentIndex = 0; // 当前提供服务的机器号

    /**
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

//            int index = chooseRandomInt(serverCount);
//            server = upList.get(index);
            if (total < 5){
                server = upList.get(currentIndex);
                total++;
            }else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()){
                    currentIndex = 0;
                }
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
```

（4）调用

 

```
package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 王柳
 * Date 2019/8/15 16:14
 * version:1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        // 达到的目的，用我们重新选择的随机算法替代默认的轮询
//        return new RandomRule();

        // 自定义，每个服务器5次
        return new RandomRule_ZY();
    }
}
```

 

```
package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "microservicecloud-dept",configuration = MySelfRule.class)
public class DeptConsumer80_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
```

（5）测试

 

```
http://localhost/consumer/dept/list
```

# 七、Feign负载均衡

官网解释：

http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-feign

 

Feign是一个声明式WebService客户端。使用Feign能让编写Web Service客户端更加简单, 它的使用方法是定义一个接口，然后在上面添加注解，同时也支持JAX-RS标准的注解。Feign也支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。

 

Feign是一个声明式的Web服务客户端，使得编写Web服务客户端变得非常容易，只需要创建一个接口，然后在上面添加注解即可。

参考官网：https://github.com/OpenFeign/feign 

 

Feign能干什么：

Feign旨在使编写Java Http客户端变得更容易。

前面在使用Ribbon+RestTemplate时，利用RestTemplate对http请求的封装处理，形成了一套模版化的调用方法。但是在实际开发中，由于对服务依赖的调用可能不止一处，往往一个接口会被多处调用，所以通常都会针对每个微服务自行封装一些客户端类来包装这些依赖服务的调用。所以，Feign在此基础上做了进一步封装，由他来帮助我们定义和实现依赖服务接口的定义。在Feign的实现下，我们只需创建一个接口并使用注解的方式来配置它(以前是Dao接口上面标注Mapper注解,现在是一个微服务接口上面标注一个Feign注解即可)，即可完成对服务提供方的接口绑定，简化了使用Spring cloud Ribbon时，自动封装服务调用客户端的开发量。

Feign集成了Ribbon：

利用Ribbon维护了MicroServiceCloud-Dept的服务列表信息，并且通过轮询实现了客户端的负载均衡。而与Ribbon不同的是，通过feign只需要定义服务绑定接口且以声明式的方法，优雅而简单的实现了服务调用。

 

**Feign使用步骤**：

1、参考microservicecloud-consumer-dept-80

2、新建microservicecloud-consumer-dept-feign，修改主启动类名字，DeptConsumer80_Feign_App

3、microservicecloud-consumer-dept-feign工程pom.xml修改，主要添加对feign的支持

 

```
<!--Feign相关-->
<dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-feign</artifactId>
   </dependency>
```

4、修改microservicecloud-api工程

（1）修改POM

 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <parent><!-- 子类里面显示声明才能有明确的继承表现，无意外就是父类的默认版本否则自己定义 -->
   <groupId>com.atguigu.springcloud</groupId>
   <artifactId>microservicecloud</artifactId>
   <version>0.0.1-SNAPSHOT</version>
  </parent>

  <artifactId>microservicecloud-api</artifactId><!-- 当前Module我自己叫什么名字 -->

  <dependencies><!-- 当前Module需要用到的jar包，按自己需求添加，如果父类已经包含了，可以不用写版本号 -->
   <dependency>
     <groupId>org.projectlombok</groupId>
     <artifactId>lombok</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-feign</artifactId>
   </dependency>
  </dependencies>
</project>
```

（2）新建DeptClientService接口并新增注解@FeignClient

 

```
package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.springcloud.entities.Dept;

@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientService
{
  @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
  public Dept get(@PathVariable("id") long id);

  @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
  public List<Dept> list();

  @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
  public boolean add(Dept dept);
}
```

（3）mvn clean --》mvn install

5、microservicecloud-consumer-dept-feign工程修改Controller，添加上一步新建的DeptClientService接口

 

```
package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Feign {

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        return this.service.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return this.service.list();
    }
}
```

6、microservicecloud-consumer-dept-feign工程修改主启动类

 

```
package com.atguigu.springcloud;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
 
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.atguigu.springcloud"})
@ComponentScan("com.atguigu.springcloud")
public class DeptConsumer80_Feign_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(DeptConsumer80_Feign_App.class, args);
  }
}
```

7、测试

（1）启动3个eureka集群

（2）启动3个部门微服务8001/8002/8003

（3）启动Feign自己启动

（4）http://localhost/consumer/dept/list 

（5）Feign自带负载均衡配置项

8、 总结：

Feign通过接口的方法调用Rest服务（之前是Ribbon+RestTemplate），该请求发送给Eureka服务器（http://MICROSERVICECLOUD-DEPT/dept/list），通过Feign直接找到服务接口，由于在进行服务调用的时候融合了Ribbon技术，所以也支持负载均衡作用。

 

# 八、Hystrix断路器

分布式系统面临的问题：复杂分布式体系结构中的应用程序有数十个依赖关系，每个依赖关系在某些时候将不可避免地失败。

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/b512cc53-4d0e-4f7d-a41b-b30a25c9f5d1.jpg)

服务雪崩：多个微服务之间调用的时候，假设微服务A调用微服务B和微服务C，微服务B和微服务C又调用其它的微服务，这就是所谓的“扇出”。如果扇出的链路上某个微服务的调用响应时间过长或者不可用，对微服务A的调用就会占用越来越多的系统资源，进而引起系统崩溃，所谓的“雪崩效应”.

 

对于高流量的应用来说，单一的后端依赖可能会导致所有服务器上的所有资源都在几秒钟内饱和。比失败更糟糕的是，这些应用程序还可能导致服务之间的延迟增加，备份队列，线程和其他系统资源紧张，导致整个系统发生更多的级联故障。这些都表示需要对故障和延迟进行隔离和管理，以便单个依赖关系的失败，不能取消整个应用程序或系统。

**Hystrix**是一个用于处理分布式系统的延迟和容错的开源库，在分布式系统里，许多依赖不可避免的会调用失败，比如超时、异常等，Hystrix能够保证在一个依赖出问题的情况下，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。

 

“断路器”本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控（类似熔断保险丝），向调用方返回一个符合预期的、可处理的备选响应（FallBack），而不是长时间的等待或者抛出调用方无法处理的异常，这样就保证了服务调用方的线程不会被长时间、不必要地占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩。

能干嘛：

- 服务降级
- 服务熔断
- 服务限流
- 接近实时的监控

官网资料：https://github.com/Netflix/Hystrix/wiki/How-To-Use

**服务熔断**：

服务熔断：熔断机制是应对雪崩效应的一种微服务链路保护机制。当扇出链路的某个微服务不可用或者响应时间太长时，会进行服务的降级，进而熔断该节点微服务的调用，快速返回"错误"的响应信息。当检测到该节点微服务调用响应正常后恢复调用链路。在SpringCloud框架里熔断机制通过Hystrix实现。Hystrix会监控微服务间调用的状况，当失败的调用到一定阈值，缺省是5秒内20次调用失败就会启动熔断机制。熔断机制的注解是@HystrixCommand。

1、参考microservicecloud-provider-dept-8001

2、新建microservicecloud-provider-dept-hystrix-8001

3、修改POM

 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.atguigu.springcloud</groupId>
        <artifactId>microservicecloud</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>microservicecloud-provider-dept-hystrix-8001</artifactId>

    <dependencies>
        <!--  hystrix -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix</artifactId>
        </dependency>
        <dependency><!-- 引入自己定义的api通用包，可以使用Dept部门Entity -->
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>microservicecloud-api</artifactId>
            <version>${project.version}</version>
        </dependency>
        <!-- 将微服务provider侧注册进eureka -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <!--actuator监控信息完善-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.17</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.12</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.0</version>
        </dependency>
        <!-- 修改后立即生效，热部署 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>springloaded</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>

</project>
```

4、修改YML

 

```
server:
  port: 8001
  
mybatis:
  config-location: classpath:mybatis/mybatis.cfg.xml  #mybatis所在路径
  type-aliases-package: com.atguigu.springcloud.entities #entity别名类
  mapper-locations:
  - classpath:mybatis/mapper/**/*.xml #mapper映射文件
    
spring:
   application:
    name: microservicecloud-dept 
   datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: org.gjt.mm.mysql.Driver
    url: jdbc:mysql://localhost:3306/cloudDB01
    username: root
    password: 123456
    dbcp2:
      min-idle: 5
      initial-size: 5
      max-total: 5
      max-wait-millis: 200
      
eureka:
  client: #客户端注册进eureka服务列表内
    service-url: 
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
  instance:
    instance-id: microservicecloud-dept8001-hystrix   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址
      
info:
  app.name: atguigu-microservicecloud
  company.name: www.atguigu.com
  build.artifactId: $project.artifactId$
  build.version: $project.version$
```

5、修改DeptController

@HystrixCommand报异常后如何处理，一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法

 

```
package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = this.service.get(id);
        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id)
                .setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }

}
```

6、修改主启动类DeptProvider8001_Hystrix_App并添加新注解@EnableCircuitBreaker

 

```
package com.atguigu.springcloud;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
 
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableCircuitBreaker//对hystrixR熔断机制的支持
public class DeptProvider8001_Hystrix_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
  }
}
```

7、测试

3个eureka先启动

主启动类DeptProvider8001_Hystrix_App

Consumer启动microservicecloud-consumer-dept-80

 

```
如果对应的ID：112，数据库里面没有这个记录，我们报错后统一返回。
http://localhost/consumer/dept/get/112
```

**服务降级**：

整体资源快不够了，忍痛将某些服务先关掉，待渡过难关，再开启回来。

服务降级处理是在客户端实现完成的，与服务端没有关系。

1、修改microservicecloud-api工程，根据已经有的DeptClientService接口新建一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory

千万不要忘记在类上面新增@Component注解，大坑！！！

 

```
package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component//不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {
            
            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id)
                        .setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };


    }
}
```

2、修改microservicecloud-api工程，DeptClientService接口在注解@FeignClient中添加fallbackFactory属性值

 

```
package com.atguigu.springcloud.service;
 
import java.util.List;
 
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.atguigu.springcloud.entities.Dept;
 
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService
{
  @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
  public Dept get(@PathVariable("id") long id);
 
  @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
  public List<Dept> list();
 
  @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
  public boolean add(Dept dept);
}
 
```

3、microservicecloud-api工程 mvn clean install

4、microservicecloud-consumer-dept-feign工程修改YML

 

```
server:
  port: 80
 
feign: 
  hystrix: 
    enabled: true
 
eureka:
  client:
    register-with-eureka: false
    service-url: 
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/  
```

5、测试

（1）3个eureka先启动

（2）微服务microservicecloud-provider-dept-8001启动

（3）microservicecloud-consumer-dept-feign启动

（4）正常访问测试

 

```
http://localhost/consumer/dept/get/1
```

（5）故意关闭微服务microservicecloud-provider-dept-8001

（6）客户端自己调用提示

此时服务端provider已经down了，但是我们做了服务降级处理，让客户端在服务端不可用时也会获得提示信息而不会挂起耗死服务器。

 

```
http://localhost/consumer/dept/get/1
```

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/4b2274b3-e559-4e4f-ae62-cee10056e7be.png)

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/a3edc378-628f-48df-a06f-47ebd03ba5e2.jpg)

**服务监控hystrixDashboard**：

 

除了隔离依赖服务的调用以外，Hystrix还提供了准实时的调用监控（Hystrix Dashboard），Hystrix会持续地记录所有通过Hystrix发起的请求的执行信息，并以统计报表和图形的形式展示给用户，包括每秒执行多少请求多少成功，多少失败等。Netflix通过hystrix-metrics-event-stream项目实现了对以上指标的监控。Spring Cloud也提供了Hystrix Dashboard的整合，对监控内容转化成可视化界面。

**Case步骤**：

1、新建工程microservicecloud-consumer-hystrix-dashboard

2、修改POM

 

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>microservicecloud</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>microservicecloud-consumer-hystrix-dashboard</artifactId>

    <dependencies>
        <dependency><!-- 引入自己定义的api通用包，可以使用Dept部门Entity -->
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>microservicecloud-api</artifactId>
            <version>${project.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- 修改后立即生效，热部署 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>springloaded</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
        <!-- Ribbon相关 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-ribbon</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <!-- feign相关 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-feign</artifactId>
        </dependency>
        <!-- hystrix和 hystrix-dashboard相关-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
        </dependency>

    </dependencies>

</project>
```

3、修改YML

 

```
server:
  port: 9001
```

4、主启动类改名+新注解@EnableHystrixDashboard

 

```
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by 王柳
 * Date 2019/8/16 16:58
 * version:1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_DashBoard_App {
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
    }
}

```

5、所有Provider微服务提供类(8001/8002/8003)都需要监控依赖配置

 

```
<!-- actuator监控信息完善 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

6、启动microservicecloud-consumer-hystrix-dashboard该微服务监控消费端

 

```
http://localhost:9001/hystrix
```

7、启动3个eureka集群

8、启动microservicecloud-provider-dept-hystrix-8001

 

```
http://localhost:8001/dept/get/1
http://localhost:8001/hystrix.stream
```

9、启动的相关微服务工程

10、监控测试

（1）多次刷新http://localhost:8001/dept/get/1 

（2）观察监控窗口

填写监控地址：http://localhost:8001/hystrix.stream

1：Delay：该参数用来控制服务器上轮询监控信息的延迟时间，默认为2000毫秒，可以通过配置该属性来降低客户端的网络和CPU消耗。

 2：Title：该参数对应了头部标题Hystrix Stream之后的内容，默认会使用具体监控实例的URL，可以通过配置该信息来展示更合适的标题。

监控结果：

如何看？7色

1圈：实心圆：共有两种含义。它通过颜色的变化代表了实例的健康程度，它的健康度从绿色<黄色<橙色<红色递减。

该实心圆除了颜色的变化之外，它的大小也会根据实例的请求流量发生变化，流量越大该实心圆就越大。所以通过该实心圆的展示，就可以在大量的实例中快速的发现故障实例和高压力实例。

1线：曲线：用来记录2分钟内流量的相对变化，可以通过它来观察到流量的上升和下降趋势。

搞懂一个才能看懂复杂的：

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/79d0d3d0-3517-463e-8f4c-f5b6173efce7.jpg)

# 九、Zuul路由网关

Zuul包含了对请求的路由和过滤两个最主要的功能：

其中路由功能负责将外部请求转发到具体的微服务实例上，是实现外部访问统一入口的基础。而过滤器功能则负责对请求的处理过程进行干预，是实现请求校验、服务聚合等功能的基础。Zuul和Eureka进行整合，将Zuul自身注册为Eureka服务治理下的应用，同时从Eureka中获得其他微服务的消息，也即以后的访问微服务都是通过Zuul跳转后获得。

注意：Zuul服务最终还是会注册进Eureka。

 

**提供=代理+路由+过滤三大功能**

能干嘛：路由和过滤。

官网资料：https://github.com/Netflix/zuul/wiki/Getting-Started。

路由基本配置：

1、新建Module模块microservicecloud-zuul-gateway-9527

2、修改POM

 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <parent>
   <groupId>com.atguigu.springcloud</groupId>
   <artifactId>microservicecloud</artifactId>
   <version>0.0.1-SNAPSHOT</version>
  </parent>

  <artifactId>microservicecloud-zuul-gateway-9527</artifactId>

  <dependencies>
   <!-- zuul路由网关 -->
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-zuul</artifactId>
   </dependency> 
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-eureka</artifactId>
   </dependency>
   <!-- actuator监控 -->
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
   <!--  hystrix容错-->
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-hystrix</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-config</artifactId>
   </dependency>
   <!-- 日常标配 -->
   <dependency>
     <groupId>com.atguigu.springcloud</groupId>
     <artifactId>microservicecloud-api</artifactId>
     <version>${project.version}</version>
   </dependency>
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-jetty</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-test</artifactId>
   </dependency>
   <!-- 热部署插件 -->
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>springloaded</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-devtools</artifactId>
   </dependency>
  </dependencies>

</project>
```

3、新建application.yml

 

```
server: 
  port: 9527
 
spring: 
  application:
    name: microservicecloud-zuul-gateway
 
eureka: 
  client: 
    service-url: 
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka,http://eureka7003.com:7003/eureka  
  instance:
    instance-id: gateway-9527.com
    prefer-ip-address: true 
    
info:
  app.name: atguigu-microcloud
  company.name: www.atguigu.com
  build.artifactId: $project.artifactId$
  build.version: $project.version$
```

4、hosts修改

 

```
127.0.0.1  myzuul.com
```

5、主启动类

 

```
package com.atguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp
{
  public static void main(String[] args)
  {
   SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
  }
}
 
```

6、启动

三个eureka集群，一个服务提供类microservicecloud-provider-dept-8001，一个路由

7、测试

不用路由：http://localhost:8001/dept/get/2 

启用路由：http://myzuul.com:9527/microservicecloud-dept/dept/get/2 

路由访问映射规则：

1、工程microservicecloud-zuul-gateway-9527

2、代理名称，修改application.yml

before：http://myzuul.com:9527/microservicecloud-dept/dept/get/2

 

```
 zuul: 
    routes: mydept.serviceId: microservicecloud-dept 
    mydept.path: /mydept/**
```

after：http://myzuul.com:9527/mydept/dept/get/1

此时问题：

路由访问OK ：http://myzuul.com:9527/mydept/dept/get/1 

原路径访问OK：http://myzuul.com:9527/microservicecloud-dept/dept/get/2 

3、原真实服务名忽略，修改application.yml

 

```
 zuul: 
  ignored-services: microservicecloud-dept 
  routes: 
    mydept.serviceId: microservicecloud-dept
    mydept.path: /mydept/**
```

单个具体，多个可以用"*"：

 

```
zuul: 
  ignored-services: "*"
  routes: 
    mydept.serviceId: microservicecloud-dept
    mydept.path: /mydept/**
```

4、设置统一公共前缀，修改application.yml

 

```
zuul: 
  prefix: /atguigu
  ignored-services: "*"
  routes: 
    mydept.serviceId: microservicecloud-dept
    mydept.path: /mydept/**
```

访问：http://myzuul.com:9527/atguigu/mydept/dept/get/1 

5、最终的application.yml

 

```
server: 
  port: 9527
 
spring: 
  application:
    name: microservicecloud-zuul-gateway
 
zuul: 
  prefix: /atguigu
  ignored-services: "*"
  routes: 
    mydept.serviceId: microservicecloud-dept
    mydept.path: /mydept/**


eureka: 
  client: 
    service-url: 
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka,http://eureka7003.com:7003/eureka  
  instance:
    instance-id: gateway-9527.com
    prefer-ip-address: true 
 
info:
  app.name: atguigu-microcloud
  company.name: www.atguigu.com
  build.artifactId: $project.artifactId$
  build.version: $project.version$
 
```

# 十、SpringCloud Config分布式配置中心

分布式系统面临的---配置问题：微服务意味着要将单体应用中的业务拆分成一个个子服务，每个服务的粒度相对较小，因此系统中会出现大量的服务。由于每个服务都需要必要的配置信息才能运行，所以一套集中式的、动态的配置管理设施是必可不少的。SpringCloud提供了COnfigServer来解决这个问题，我们每一个微服务自己带着一个application.yml，上百个配置文件的管理。

是什么：

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/61a2d716-a054-41f8-ad92-949ee1c1e59e.jpg)

SpringCloud Config为微服务架构中的微服务提供集中化的外部配置支持，配置服务器为各个不同微服务应用的所有环境提供了一个中心化的外部配置。

怎么玩：

SpringCloud Config分为服务端和客户端两部分。

服务端也称为分布式配置中心，它是一个独立的微服务应用，用来连接配置服务器并为客户端提供获取配置信息，加密/解密信息等访问接口。

客户端则是通过指定的配置中心来管理应用资源，以及与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息，配置服务器默认采用git来存储配置信息，这样就有助于对环境配置进行版本管理，并且可以通过git客户端工具来方便的管理和访问配置内容。

能干吗：

- 集中管理配置文件；
- 不同环境不同配置，动态化的配置更新，分环境部署比如dev/test/prod/beta/release；
- 运行期间动态调整配置，不再需要在每个服务部署的机器上编写配置文件，服务会向配置中心统一拉取配置自己的信息；
- 当配置发生变动时，服务不需要重启即可感知到配置的变化并应用新的配置；
- 将配置信息以REST接口的形式暴露。

SpringCloud Config服务端配置：

1、用自己的GitHub账号在GitHub上新建一个名为microservicecloud-config的新Repository。

2、由上一步获得http协议或SSH协议的git地址：

 

```
https://github.com/wangliu1102/microservicecloud-config.git
git@github.com:wangliu1102/microservicecloud-config.git
```

3、本地硬盘目录上新建git仓库并clone

本地地址：D:\study\code\myspringcloud

git命令：

 

```
git clone https://github.com/wangliu1102/microservicecloud-config.git
或者
git clone git@github.com:wangliu1102/microservicecloud-config.git
```

4、在本地D:\study\code\myspringcloud\microservicecloud-config里面新建一个application.yml，保存为UTF-8格式

 

```
spring:
  profiles:
    active:
    - dev
---


spring:
  profiles: dev  #开发环境
  application:
    name: microservicecloud-config-atguigu-dev
---


spring:
  profiles: test  #测试环境
  application:
    name: microservicecloud-config-atguigu-test

#请保存为UTF-8格式
```

5、将上一步的YML文件推送到github上

 

```
git pull
git add .
git commit -m "init.yml"
git push orgin master
```

6、新建Module模块microservicecloud-config-3344，它即为Cloud的配置中心模块

7、修改POM

 

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>microservicecloud</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>microservicecloud-config-3344</artifactId>

    <dependencies>
        <!-- SpringCloud Config -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
        <!-- actuator监控 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!--  hystrix容错-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <!-- 日常标配 -->
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>microservicecloud-api</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
        <!-- 热部署插件 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>springloaded</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>

</project>
```

8、新建application.yml

 

```
server:
  port: 3344
spring:
  application:
    name: microservicecloud-config
  cloud:
    config:
      server:
        git:
          uri: https://github.com/wangliu1102/microservicecloud-config.git

```

9、主启动类Config_3344_StartSpringCloudApp

 

```
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by 王柳
 * Date 2019/8/27 17:07
 * version:1.0
 */
@SpringBootApplication
@EnableConfigServer
public class Config_3344_StartSpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(Config_3344_StartSpringCloudApp.class, args);
    }
}

```

10、windows下修改hosts文件，增加映射

 

```
127.0.0.1 config-3344.com
```

11、测试通过Config微服务是否可以从GitHub上获取配置内容

启动微服务3344；

 

```
http://config-3344.com:3344/application-dev.yml
http://config-3344.com:3344/application-test.yml
http://config-3344.com:3344/application-xxx.yml
```

12、配置读取规则

![img](/2c2154f6-4be6-4bb8-9275-0c4fe7e11497/128/index_files/25a47f49-5587-4e1d-9a14-b3e3e0b55431.jpg)

 

```
/{application}-{profile}.yml
http://config-3344.com:3344/application-dev.yml
http://config-3344.com:3344/application-test.yml
http://config-3344.com:3344/application-xxx.yml(不存在的配置)

/{application}/{profile}[/{label}]
http://config-3344.com:3344/application/dev/master
http://config-3344.com:3344/application/test/master
http://config-3344.com:3344/application/xxx/master

/{label}/{application}-{profile}.yml
http://config-3344.com:3344/master/application-dev.yml
http://config-3344.com:3344/master/application-test.yml
http://config-3344.com:3344/master/application-xxx.yml
```

13、成功实现了用SpringCloud Config通过GitHub获取配置信息

SpringCloud Config客户端配置与测试：

1、在本地D:\study\code\myspringcloud\microservicecloud-config路径下新建文件microservicecloud-config-client.yml

2、microservicecloud-config-client.yml内容

 

```
spring:
  profiles:
    active:
    - dev

---
server:
  port: 8201
spring:
  profiles: dev
  application:
    name: microservicecloud-config-client
eureka:
  client:
    service-url:
      defaultZone: http://eureka-dev.com:7001/eureka/

---
server:
  port: 8202
spring:
  profiles: test
  application:
    name: microservicecloud-config-client
eureka:
  client:
    service-url:
      defaultZone: http://eureka-test.com:7001/eureka/
```

3、将上一步提交到GitHub中

4、新建microservicecloud-config-client-3355

5、修改POM

 

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>microservicecloud</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>microservicecloud-config-client-3355</artifactId>

    <dependencies>
        <!-- SpringCloud Config 客户端-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <!-- actuator监控 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!-- 日常标配 -->
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>microservicecloud-api</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
        <!-- 热部署插件 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>springloaded</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>

</project>
```

6、新建bootstrap.yml

application.yml是用户级的资源配置项。

bootstrap.yml是系统级的，优先级更高。

Spring Cloud会创建一个Bootstrap Context，作为Spring应用的Application Context的父上下文。初始化的时候，Bootstrap Context负责从外部源加载配置属性并解析配置。这两个上下文共享一个从外部获取的Environment。Bootstrap属性有高优先级，默认情况下，它们不会被本地配置覆盖。Bootstrap Context和Application Context有着不同的约定，所以新增一个bootstrap.yml文件，保证Bootstrap Context和Application Context配置的分离。

 

```
spring:
  cloud:
    config:
      name: microservicecloud-config-client #需要从github上读取的资源名称，注意没有yml后缀名
      profile: dev #本次访问的配置项
      label: master
      uri: http://config-3344.com:3344 #本微服务启动后先去找3344的服务，通过SpringCloud Config获取GitHub的服务地址
```

7、新建application.yml

 

```
spring:
  application:
    name: microservicecloud-config-client
```

8、windows下修改hosts文件，增加映射

 

```
127.0.0.1  client-config.com
```

9、新建rest类，验证能否从GitHub上读取配置

 

```
package com.atguigu.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 王柳
 * Date 2019/8/28 10:42
 * version:1.0
 */
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        String str = "applicationName: " + applicationName + "\t eurekaServers: " + eurekaServers + "\t port: " + port;
        System.out.println("**********str: " + str);
        return str;
    }


}

```

10、主启动类ConfigClient_3355_StratSpringCloudApp

 

```
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by 王柳
 * Date 2019/8/28 10:50
 * version:1.0
 */
@SpringBootApplication
public class ConfigClient_3355_StratSpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_3355_StratSpringCloudApp.class, args);
    }
}

```

11、测试

启动Config配置中心3344微服务并自测

 

```
http://config-3344.com:3344/application-dev.yml
```

启动3355作为Client准备访问。

bootstrap.yml里面的profile值是什么，决定从github上读取什么。

假如入目前是profile: dev ，dev默认在github上对应的端口就是8201

 

```
http://client-config.com:8201/config
```

假如入目前是profile: test，dev默认在github上对应的端口就是8202

 

```
http://client-config.com:8202/config
```

12、成功实现了客户端3355访问SpringCloud Config3344通过GitHub获取配置信息

SpringCloud Config配置实战：

目前情况：

① Config服务端配置OK且测试通过，我们可以和config + GitHub进行配置修改并获得内容；

② 此时我们做一个eureka服务 + 一个Dept访问的微服务，将两个微服务的配置统一由github获得实现统一配置分布式管理，完成多环境的变更。

步骤：

1、Git配置文件本地配置

（1）在本地D:\study\code\myspringcloud\microservicecloud-config路径下新建文件microservicecloud-config-eureka-client.yml

 

```
spring:
  profiles:
    active: 
    - dev
---
server:
  port: 7001

eureka:
  instance:
    hostname: eureka7001.com #eureka服务端的实例名称
  client:
    service-url: 
      defaultZone: http://eureka7001.com:7001/eureka/
spring:
  profiles: dev
  application:
      name: microservicecloud-config-eureka-client

---
server:
  port: 7001
eureka:
  instance:
    hostname: eureka7001.com #eureka服务端的实例名称
  client:
    service-url: 
      defaultZone: http://eureka7001.com:7001/eureka/
spring:
  profiles: test
  application:
      name: microservicecloud-config-eureka-client
```

（1）在本地D:\study\code\myspringcloud\microservicecloud-config路径下新建文件microservicecloud-config-dept-client.yml

 

```
spring:
  profiles:
    active:
    - dev

---
server:
  port: 8001

spring:
   profiles: dev
   application:
    name: microservicecloud-config-dept-client
   datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: org.gjt.mm.mysql.Driver
    url: jdbc:mysql://localhost:3306/cloudDB01
    username: root
    password: 123456
    dbcp2:
      min-idle: 5
      initial-size: 5
      max-total: 5
      max-wait-millis: 200

mybatis:
  config-location: classpath:mybatis/mybatis.cfg.xml  #mybatis所在路径
  type-aliases-package: com.atguigu.springcloud.entities #entity别名类
  mapper-locations:
  - classpath:mybatis/mapper/**/*.xml #mapper映射文件

eureka:
  client: #客户端注册进eureka服务列表内
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/
  instance:
    instance-id: dept-8001.com   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址

info:
  app.name: atguigu-microservicecloud-springcloudconfig01
  company.name: www.atguigu.com
  build.artifactId: $project.artifactId$
  build.version: $project.version$
  
---
server:
  port: 8001

spring:
   profiles: test
   application:
    name: microservicecloud-config-dept-client
   datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: org.gjt.mm.mysql.Driver
    url: jdbc:mysql://localhost:3306/cloudDB02
    username: root
    password: 123456
    dbcp2:
      min-idle: 5
      initial-size: 5
      max-total: 5
      max-wait-millis: 200

mybatis:
  config-location: classpath:mybatis/mybatis.cfg.xml  #mybatis所在路径
  type-aliases-package: com.atguigu.springcloud.entities #entity别名类
  mapper-locations:
  - classpath:mybatis/mapper/**/*.xml #mapper映射文件

eureka:
  client: #客户端注册进eureka服务列表内
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/
  instance:
    instance-id: dept-8001.com   #自定义服务名称信息
    prefer-ip-address: true     #访问路径可以显示IP地址

info:
  app.name: atguigu-microservicecloud-springcloudconfig02
  company.name: www.atguigu.com
  build.artifactId: $project.artifactId$
  build.version: $project.version$
```

2、Config版的eureka服务端

（1）新建工程microservicecloud-config-eureka-client-7001

（2）修改POM

 

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>microservicecloud</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>microservicecloud-config-eureka-client-7001</artifactId>

    <dependencies>
        <!-- SpringCloud Config 客户端-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <!--eureka-server服务端 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-server</artifactId>
        </dependency>
        <!-- 修改后立即生效，热部署 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>springloaded</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>
</project>
```

（3）bootstrap.yml

 

```
spring:
  cloud:
    config:
      name: microservicecloud-config-eureka-client #需要从github上读取的资源名称，注意没有yml后缀名
      profile: dev #本次访问的配置项
      label: master
      uri: http://config-3344.com:3344 #本微服务启动后先去找3344的服务，通过SpringCloud Config获取GitHub的服务地址
```

（4）application.yml

 

```
spring:
  application:
      name: microservicecloud-config-eureka-client
server:
  port: 7001
eureka:
  client:
    register-with-eureka: false     #false表示不向注册中心注册自己。
    fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/
```

（5）主启动类Config_Git_EurekaServerApplication

 

```
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//EurekaServer服务器端启动类,接受其它微服务注册进来
public class Config_Git_EurekaServerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(Config_Git_EurekaServerApplication.class, args);
    }
}
```

（6）测试

先启动microservicecloud-config-3344微服务，保证Config总配置是OK的。

再启动microservicecloud-config-eureka-client-7001微服务。

 

```
http://eureka7001.com:7001/
```

3、COnfig版的dept微服务

（1）参考之前的8001拷贝后新建工程microservicecloud-config-dept-client-8001

（2）修改POM

 

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>microservicecloud</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>microservicecloud-config-dept-client-8001</artifactId>

    <dependencies>
        <!-- SpringCloud Config 客户端-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <dependency><!-- 引入自己定义的api通用包，可以使用Dept部门Entity -->
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>microservicecloud-api</artifactId>
            <version>${project.version}</version>
        </dependency>
        <!-- 将微服务provider侧注册进eureka -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <!--actuator监控信息完善-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.17</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.12</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.0</version>
        </dependency>
        <!-- 修改后立即生效，热部署 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>springloaded</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>
</project>
```

（3）bootstrap.yml

 

```
spring:
  cloud:
    config:
      name: microservicecloud-config-dept-client #需要从github上读取的资源名称，注意没有yml后缀名
      profile: dev #本次访问的配置项
      label: master
      uri: http://config-3344.com:3344 #本微服务启动后先去找3344的服务，通过SpringCloud Config获取GitHub的服务地址
```

（4）application.yml

 

```
spring:
  application:
    name: microservicecloud-config-dept-client
```

（5）主启动类及其它一套业务逻辑代码

 

```
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient // 服务发现
public class DeptProvider8001_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}
```

（6）配置说明

（7）测试

test配置默认访问：http://localhost:8001/dept/list 可以看到数据库配置时02

dev配置默认访问：http://localhost:8001/dept/list 可以看到数据库配置时01

