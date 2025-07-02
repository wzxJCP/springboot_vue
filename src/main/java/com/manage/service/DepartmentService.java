package com.manage.service;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.domain.Account;
import com.manage.domain.Department;
import com.manage.exception.CustomException;
import com.manage.mapper.DepartmentMapper;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project：springboot_vue
 * @since：2025/6/29 1:16
 * @author：wzx
 */
@Service
public class DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    public void add(Department department) {
        departmentMapper.insert(department);
    }

    public void update(Department department) {
        departmentMapper.updateById(department);
    }

    public void deleteById(Integer id) {
        departmentMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            this.deleteById(id);
        }
    }
    public Department selectById(Integer id) {
        return departmentMapper.selectById(id);
    }

    public List<Department> selectAll(Department department) {
        return departmentMapper.selectAll(department);
    }

    public PageInfo<Department> selectPage(Department  department,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Department> list = departmentMapper.selectAll(department);
        return PageInfo.of(list);
    }

    public Department selectByName(String deptName) {
        return departmentMapper.selectByName(deptName);
    }
}
