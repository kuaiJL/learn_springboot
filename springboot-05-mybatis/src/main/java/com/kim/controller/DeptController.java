package com.kim.controller;

import com.kim.mapper.SysDeptMapper;
import com.kim.mapper.UserMapper;
import com.kim.pojo.SysDept;
import com.kim.pojo.User;
import com.kim.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class DeptController {

    @Autowired
    private ISysDeptService deptService;


    @GetMapping("/queryDeptList")
    //@ResponseBody //也可以省略
    public List<SysDept> querySysDeptList() {
        System.out.println(111111);
        List<SysDept> sysDeptList = deptService.selectDeptList();
        System.out.println(2222222);
        for (SysDept sysDept : sysDeptList) {
            System.out.println(sysDept);
        }
        return sysDeptList;
    }

}
