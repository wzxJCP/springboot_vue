package com.manage.controller;

import com.manage.common.Result;
import com.manage.domain.Account;
import com.manage.domain.Employee;
import com.manage.exception.CustomException;
import com.manage.service.AdminService;
import com.manage.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @project：springboot_vue
 * @since：2025/5/27 8:58
 * @author：wzx
 */
@RestController
public class WebController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private AdminService adminService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    /**
     * 管理员/员工 角色登录
     * @param account
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        Account result = null;
        // 管理员登录
        if ("ADMIN".equals(account.getRole())) {
            result = adminService.login(account);
        } else if ("EMP".equals(account.getRole())) {
            result = employeeService.login(account);
        } else {
            throw new CustomException("500", "非法输入!");
        }
        return Result.success(result);
    }

    /**
     * 员工注册
     * @param employee
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody Employee employee) {
        employeeService.register(employee);
        return Result.success();
    }

    /**
     * 修改密码
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account) {
        if ("ADMIN".equals(account.getRole())) {
            adminService.updatePassword(account);
        } else if ("EMP".equals(account.getRole())) {
            employeeService.updatePassword(account);
        } else {
            throw new CustomException("500", "非法输入!");
        }
        return Result.success();
    }
}
