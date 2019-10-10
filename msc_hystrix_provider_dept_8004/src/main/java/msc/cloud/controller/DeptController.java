package msc.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import msc.cloud.service.DeptService;
import msc.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value="/dept/add",method= RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "aaa")
    public boolean add(Dept dept)
    {
        return deptService.add(dept);
    }
    public boolean aaa(Dept dept)
    {
        return false;
    }

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrixDeptGet")//服务熔断
    public Dept get(@PathVariable("id") Long id)
    {
        Dept dept=deptService.get(id);
        //模拟服务阻塞
        /*try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/
        //模拟异常
/*        if(dept==null){
            throw new RuntimeException("您查询的数据不存在");
        }*/


        return dept;
    }
    public Dept processHystrixDeptGet(@PathVariable("id")Long id){
        Dept dept=new Dept();
        dept.setDeptno(id).setDname("查无此数据").setDb_source("查无此源");
        return dept;
    }

    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public List<Dept> list()
    {
        return deptService.list();
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<ServiceInstance> srvlist=client.getInstances("microservicecloud-dept");
        for(ServiceInstance element:srvlist){
            System.out.println(element.getServiceId()+ "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.client;
    }
}
