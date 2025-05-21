package com.springboot_vue.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot_vue.domain.Employee;
import com.springboot_vue.mapper.EmployeeMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project：springboot_vue
 * @since：2025/5/19 9:43
 * @author：wzx
 */
@Service
public class EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    public void add(Employee employee) {
        employeeMapper.insert(employee);
    }

    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }

    public Employee selectById(Integer id) {
        return employeeMapper.selectById(id);
    }

    public PageInfo<Employee> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Employee> list = employeeMapper.selectAll();
        return PageInfo.of(list);
    }
}
