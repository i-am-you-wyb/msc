package msc.cloud;

import config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="microservicecloud-dept",configuration= RibbonConfig.class)
@EnableFeignClients(basePackages = "msc.cloud.feign")
public class DeptFeign9001App {
    public static void main(String[] args) {
        SpringApplication.run(DeptFeign9001App.class,args);
    }


}
