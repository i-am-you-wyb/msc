package msc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //启用路由
public class StartSpringCloudAppZuul9800 {
    public static void main(String[] args) {
        SpringApplication.run(StartSpringCloudAppZuul9800.class,args);
    }

}
