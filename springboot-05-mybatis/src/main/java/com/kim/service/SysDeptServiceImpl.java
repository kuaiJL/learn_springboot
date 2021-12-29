package com.kim.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.kim.mapper.SysDeptMapper;
import com.kim.pojo.SysDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 部门管理 服务实现
 *
 * @author ruoyi
 */
@Service
public class SysDeptServiceImpl implements ISysDeptService
{
    @Autowired
    private SysDeptMapper deptMapper;

    @Override
   // @DataScope(deptAlias = "d")
    public List<SysDept> selectDeptList()
    {
        return deptMapper.selectDeptList();
    }


}