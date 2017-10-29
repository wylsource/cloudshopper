package org.star4j.cloudshopper.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.star4j.cloudshopper.annotation.ExcludFromComponentScan;

/**
 * @Author: WuYL
 * @Description: 此类用于配置一些个性化内容
 * @Date: Create in 2017/10/29 17:30
 * @Modified By:
 */
@Configuration
@ExcludFromComponentScan
public class Configurations {


    /**
     * 配置使用的条约（默认是基于spring-mvc的）
     * @return
     */
    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();
    }

    /**
     * 配置Feign 的日志级别
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
     * 配置带用户名密码访问Eureka(与 Eureka 设置的用户名密码一致)
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "admin");
    }

    /**
     * 配置负载均衡策略
     * RandomRule 表示随机策略
     * RoundRobin 表示轮询策略
     * WeightedResponseTimeRule 表示加权策略
     * BestAvailableRule 表示请求数最少策略
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
