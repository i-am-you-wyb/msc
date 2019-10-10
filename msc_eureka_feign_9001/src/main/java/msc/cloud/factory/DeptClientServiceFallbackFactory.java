package msc.cloud.factory;/**
 * Created by Administrator on 2019/10/10 0010.
 */

import feign.hystrix.FallbackFactory;
import msc.cloud.feign.FeignProviderClient;
import msc.entity.Dept;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/10/10 0010 14:01
 * @description
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<FeignProviderClient> {
    @Override
    public FeignProviderClient create(Throwable throwable) {
        return new FeignProviderClient(){
            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("服务停止了......").setDb_source("数据源停止了");
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
