package com.miscloud.client.fallback;

import com.miscloud.client.DeptClientService;
import com.miscloud.entiy.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactroy implements FallbackFactory<DeptClientService> {

    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public List<Dept> getDeptList() {
                return null;
            }

            public Dept getDeptById(Integer id) {
                return new Dept().setDataBaseName("no in mysql").setDeptName("client service fallback").setId(0);
            }

            public Boolean addDept(Dept dept) {
                return null;
            }

            public Boolean updateDept(Integer id, Dept dept) {
                return null;
            }
        };
    }
}
