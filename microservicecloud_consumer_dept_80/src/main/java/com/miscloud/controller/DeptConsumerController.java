package com.miscloud.controller;

import com.miscloud.entiy.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/deptConsumer")
public class DeptConsumerController {

//    private static final String DEPT_URL_PROFIX = "http://localhost:8001";
//
    //通过RestTemplate 对象去访问Eureka  Server上面的微服务，通过是微服务名称去获取相应的微服务
    private static final String DEPT_URL_PROFIX = "http://microservicecloud-provider-dept";

    @Autowired
    private RestTemplate restTemplate;
 

    @GetMapping
    public List<Dept> getDeptList(){
        List<Dept> list = restTemplate.getForObject(DEPT_URL_PROFIX + "/deptController", List.class);
        return list;
    }

    @GetMapping("/{id}")
    public Dept getDeptById(@PathVariable("id") Integer id){
        Dept dept = restTemplate.getForObject(DEPT_URL_PROFIX + "/deptController/"+id, Dept.class);
        return dept;
    }


    @PostMapping("/{id}")
    public Boolean updateDept(@PathVariable("id") Integer id,Dept dept){
        Boolean flag = restTemplate.postForObject(DEPT_URL_PROFIX + "/deptController/" + id,
                dept, Boolean.class);
        return flag;
    }

    @PostMapping
    public Boolean addDept(@RequestBody Dept dept){
        Boolean flag = restTemplate.postForObject(DEPT_URL_PROFIX + "/deptController", dept, Boolean.class);
        return flag;
    }

    @GetMapping("/discovery")
    public Object getServerById(){
        return restTemplate.getForObject(DEPT_URL_PROFIX + "/deptController/discovery", Object.class);
    }

}
