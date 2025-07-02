package com.manage.service;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.domain.Account;
import com.manage.domain.Employee;
import com.manage.exception.CustomException;
import com.manage.mapper.EmployeeMapper;
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
        String username = employee.getUsername();
        Employee employee1 = employeeMapper.selectByUsername(username);
        // 检查用户名是否已存在
        if (employee1 != null) {
            throw new CustomException("500", "账号已存在");
        }
        Employee employee2 = employeeMapper.selectByNo(employee.getNo());
        // 检查工号是否已存在
        if (employee2 != null) {
            throw new CustomException("500", "工号已存在，请重新输入");
        }
        // 如果密码为空，则设置默认空字符串（防止null值）
        if (StrUtil.isBlank(employee.getPassword())) {
            employee.setPassword(username+"123456");
        } 
        // 冗余检查，确保密码字段处理一致性
        if (StrUtil.isBlank(employee.getPassword())) {
            employee.setPassword(username+"123456");
        }
        // 设置用户角色为普通员工(EMP)
        employee.setRole("EMP");
        // 插入新员工数据到数据库
        employeeMapper.insert(employee);
    }
    public void update(Employee employee) {
        employeeMapper.updateById(employee);
    }

    public void deleteById(Integer id) {
        employeeMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            this.deleteById(id);
        }
    }
    public Employee selectById(Integer id) {
        return employeeMapper.selectById(id);
    }

    public List<Employee> selectAll(Employee employee) {
        return employeeMapper.selectAll(employee);
    }

    public PageInfo<Employee> selectPage(Employee  employee,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Employee> list = employeeMapper.selectAll(employee);
        return PageInfo.of(list);
    }

    public Employee login(Account account) {
        String username = account.getUsername();
        Employee e = employeeMapper.selectByUsername(username);
        if (e == null) {
            throw new CustomException("500", "账号不存在");
        }
        String password = account.getPassword();
        if (!e.getPassword().equals(password)) {
            throw new CustomException("500", "账号或密码错误");
        }
        return e;
    }
    public void register(Employee employee) {
        this.add(employee);
    }

    public void updatePassword(Account account) {
        Integer id = account.getId();
        Employee employee = employeeMapper.selectById(id);
        if (!employee .getPassword().equals(account.getPassword())) {
            throw new CustomException("500", "原密码错误");
        }
        employee.setPassword(account.getNewPassword());
        this.update(employee);
    }
}
