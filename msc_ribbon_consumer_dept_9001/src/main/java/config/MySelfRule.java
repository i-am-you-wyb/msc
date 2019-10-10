package config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import myrule.RandomRule_ZY;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class MySelfRule {
    @Bean
    public IRule getIrule(){
//        return new RandomRule();
        return new RandomRule_ZY();
    }
}
