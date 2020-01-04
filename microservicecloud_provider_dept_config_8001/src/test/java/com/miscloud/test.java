package com.miscloud;

import com.miscloud.entiy.Dept;
import com.miscloud.dao.DeptDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    private DeptDao deptDao;

}
