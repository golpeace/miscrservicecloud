package com.miscloud.dao;

import com.miscloud.entiy.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptDao {

    List<Dept> findAll();

    Dept findById(Integer id);

    Boolean add(Dept dept);

    Boolean updateDept(Dept dept);
}
