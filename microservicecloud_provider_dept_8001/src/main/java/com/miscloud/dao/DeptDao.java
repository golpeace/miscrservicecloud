package com.miscloud.dao;

import com.miscloud.entiy.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DeptDao {

    List<Dept> findAll();

    Dept findById(Integer id);

    Boolean add(Dept dept);

    Boolean updateDept(Dept dept);

    void findDeptMaxId(Dept id);

    void batchAddDept(List<Dept> list);

    List<Dept> queryCarMakerList(List<Integer> deptList);

    List<Dept> queryCarMakerMap(Map<String,List<Integer>> map);
}
