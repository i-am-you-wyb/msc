package msc.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "msc.cloud")
@MapperScan(basePackages = "msc.cloud.dao")
@EnableCircuitBreaker //启用hystrix熔断机制
public class DeptHystrix8004App {
    public static void main(String[] args) {
        SpringApplication.run(DeptHystrix8004App.class,args);
    }
}
