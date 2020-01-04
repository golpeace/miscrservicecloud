package com.miscloud.service;

import com.miscloud.entiy.Dept;
import com.miscloud.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptDao deptDao;

    public List<Dept> getDeptList(){
        return deptDao.findAll();
    }

    public Dept getDeptById(Integer id){
        return deptDao.findById(id);
    }

    public Boolean addDept(Dept dept){
        return deptDao.add(dept);
    }

    public Boolean updateDept(Dept dept){
        return deptDao.updateDept(dept);
    }
}
