package com.miscloud.controller;


import com.miscloud.client.DeptClientService;
import com.miscloud.client.fallback.DeptClientServiceFallback;
import com.miscloud.entiy.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deptConsumer")
public class DeptConsumerController {


    @Autowired
    private DeptClientService deptClientService;

    @GetMapping
    public List<Dept> getDeptList(){
        List<Dept> list = deptClientService.getDeptList();
        return list;
    }

    @GetMapping("/{id}")
    public Dept getDeptById(@PathVariable("id") Integer id){
        Dept dept = deptClientService.getDeptById(id);
        return dept;
    }


    @PostMapping("/{id}")
    public Boolean updateDept(@PathVariable("id") Integer id,Dept dept){
        Boolean flag = deptClientService.updateDept(id,dept);
        return flag;
    }

    @PostMapping
    public Boolean addDept(@RequestBody Dept dept){
        Boolean flag = deptClientService.addDept(dept);
        return flag;
    }
}
