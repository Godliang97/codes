package com.baizhi.service;

import com.baizhi.dao.EmpDAO;
import com.baizhi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {


    //官方推荐使用构造注入的方式
    private EmpDAO empDAO;

    @Autowired
    public EmpServiceImpl(EmpDAO empDAO) {
        this.empDAO = empDAO;
    }

    @Override
    public void save(Emp emp) {
        empDAO.save(emp);
    }

    @Override
    public List<Emp> findAll() {
        return empDAO.findAll();
    }
}
