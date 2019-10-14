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
