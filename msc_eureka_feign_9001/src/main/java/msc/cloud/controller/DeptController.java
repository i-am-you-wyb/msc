package msc.cloud.controller;

import msc.cloud.feign.FeignProviderClient;
import msc.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private FeignProviderClient client;

    @RequestMapping(value="/feign/add",method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return client.add(dept);
    }

    @RequestMapping(value="/feign/get/{id}",method=RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return client.get(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value="/feign/list",method=RequestMethod.GET)
    public List<Dept> list()
    {
        return client.list();
    }
}
