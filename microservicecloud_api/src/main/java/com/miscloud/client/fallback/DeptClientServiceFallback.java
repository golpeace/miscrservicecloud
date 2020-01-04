package com.miscloud.client.fallback;

import com.miscloud.client.DeptClientService;
import com.miscloud.entiy.Dept;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

//@Component  //首先这种方式不会影响正常使用，但是当在Controller层 注入DeptClientService时会提示有多个DeptClientService的实现类
public class DeptClientServiceFallback implements DeptClientService{

    DeptClientServiceFallback(){
        System.out.println("DeptClientServiceFallback 创建了");
    }

    public List<Dept> getDeptList() {
        return new ArrayList<Dept>();
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
}
