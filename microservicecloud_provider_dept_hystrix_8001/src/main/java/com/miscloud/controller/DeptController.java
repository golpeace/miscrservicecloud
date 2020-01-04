package com.miscloud.controller;

import com.miscloud.entiy.Dept;
import com.miscloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deptController")
public class DeptController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private DeptService deptService;


    @GetMapping("/{id}")
//    @HystrixCommand(fallbackMethod = "exceptionHandlerMathod")
    public Dept getDeptById(@PathVariable("id") Integer id){
        Dept dept = deptService.getDeptById(id);
        if(null == dept){
            throw  new RuntimeException("服务调用失败");
        }
        return dept;
    }

    public Dept exceptionHandlerMathod(){
        return new Dept().setDeptName("HystrixCommand fallbackMethod");
    }

    public Dept exceptionHandlerMathod(@PathVariable("id") Integer id){
        return new Dept().setId(id).setDeptName("error ,调用失败").setDataBaseName("no mysql");
    }

    @GetMapping
    public List<Dept> getDeptList(){
        List<Dept> deptList = deptService.getDeptList();
        if(deptList.size() == 0){
            throw new RuntimeException("调用失败");
        }
        return deptList;
    }

    @PostMapping
    public Boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @PostMapping("/{id}")
    public Boolean updateDept(@PathVariable("id") Integer id,@RequestBody Dept dept){
        dept.setId(id);
        return deptService.updateDept(dept);
    }

    //对外提供接口，使得其他服务可以获取到这个微服务的信息
    @GetMapping("/discovery")
    public Object getServerById(){
        //可以通过这个客户端，获取所有注册在Eureka Server上的服务
        List<String> services = discoveryClient.getServices();
        System.out.println(services);

        //通过客户端可以获取指定暴露的服务
        List<ServiceInstance> instances = discoveryClient.getInstances("microservicecloud_consumer_dept_80");
        //将本服务信息提供给访问者
        return this.discoveryClient;
    }

}
