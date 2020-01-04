package com.miscloud;

import com.miscloud.entiy.Dept;
import com.miscloud.dao.DeptDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Dept> deptList = deptDao.queryCarMakerList(list);
        deptList.forEach(dept -> System.out.println(dept));
    }

    @Test
    public void test2(){
        Map<String,List<Integer>> map = new HashMap<>();
        map.put("list",Arrays.asList(1,2,3));
        List<Dept> deptList = deptDao.queryCarMakerMap(map);
        deptList.forEach(dept -> System.out.println(dept));
    }

    @Test
    public void test3(){
        List<Dept> depts = Arrays.asList(new Dept("管理部","pinyougou"),
                new Dept("领导部","pinyougou"),
                new Dept("经理部","pinyougou"));
        deptDao.batchAddDept(depts);

    }
    
    @Test
    public void test4(){
        String[] beanNamesForType = applicationContext.getBeanNamesForType(RedisTemplate.class);
        for (int i = 0; i < beanNamesForType.length; i++) {
        System.out.println("qwe"+beanNamesForType[i]);

        }
    }

    @Test
    public void test(){

        RedisCallback redisCallback = redisConnection -> {


            return null;
        };
        String zhp = (String) redisTemplate.opsForValue().get("zhp");
        System.out.println(zhp);
    }
}
