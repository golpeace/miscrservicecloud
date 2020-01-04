package com.miscloud.client;

import com.miscloud.client.fallback.DeptClientServiceFallback;
import com.miscloud.client.fallback.DeptClientServiceFallbackFactroy;
import com.miscloud.entiy.Dept;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "MICROSERVICECLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactroy.class)
public interface DeptClientService {

    /**
     * 在微服务中每一个模块具有一个功能，我们将这个模块对外暴露一个接口，
     * 其他微服务想要访问这个服务，直接调用这个服务的接口即可
     */

    @GetMapping("/deptController")
    List<Dept> getDeptList();

    @GetMapping("/deptController/{id}")
    Dept getDeptById(@PathVariable("id") Integer id);

    @PostMapping("/deptController")
    Boolean addDept(@RequestBody Dept dept);

    @PostMapping("/deptController/{id}")
    Boolean updateDept(@PathVariable("id")Integer id,@RequestBody Dept dept);
}
