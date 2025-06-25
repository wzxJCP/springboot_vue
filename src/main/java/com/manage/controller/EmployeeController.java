package com.manage.controller;

import com.github.pagehelper.PageInfo;
import com.manage.common.Result;
import com.manage.domain.Employee;
import com.manage.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @project：springboot_vue
 * @since：2025/5/19 9:44
 * @author：wzx
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    /**
     * 新增用户
     * @param employee
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Employee employee) {
        employeeService.add(employee);
        return Result.success();
    }
    @PutMapping("/update")
    public Result updateById(@RequestBody Employee employee) {
        employeeService.update(employee);
        return Result.success();
    }
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/deleteByIds")
    public Result deleteByIds(@RequestBody List<Integer> ids) {
            employeeService.deleteByIds(ids);
            return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(Employee employee) {
        List<Employee> list = employeeService.selectAll(employee);
        return Result.success(list);
    }

    // 方式一
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Employee employee = employeeService.selectById(id);
        return Result.success(employee);
    }
    // 方式二
    // @GetMapping("/selectOne")
    // public Result selectByIdOne(@RequestParam Integer id) {
    //     Employee employee = employeeService.selectById(id);
    //     return Result.success(employee);
    // }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(Employee employee,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Employee> pageInfo = employeeService.selectPage(employee,pageNum, pageSize);
        return Result.success(pageInfo);
    }

}