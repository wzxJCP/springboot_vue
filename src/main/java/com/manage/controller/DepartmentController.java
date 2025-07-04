package com.manage.controller;

import com.github.pagehelper.PageInfo;
import com.manage.common.Result;
import com.manage.domain.Department;
import com.manage.service.DepartmentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @project：springboot_vue
 * @since：2025/6/29 1:16
 * @author：wzx
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    /**
     * 新增用户
     * @param department
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Department department) {
        departmentService.add(department);
        return Result.success("新增部门成功！");
    }
    @PutMapping("/update")
    public Result updateById(@RequestBody Department department) {
        departmentService.update(department);
        return Result.success("更新部门成功！");
    }
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id) {
        departmentService.deleteById(id);
        return Result.success("删除部门成功！");
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/deleteByIds")
    public Result deleteByIds(@RequestBody List<Integer> ids) {
            departmentService.deleteByIds(ids);
            return Result.success("批量删除部门成功！");
    }

    @GetMapping("/selectAll")
    public Result selectAll(Department department) {
        List<Department> list = departmentService.selectAll(department);
        return Result.success(list);
    }

    // 方式一
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Department department = departmentService.selectById(id);
        return Result.success(department);
    }
    // 方式二
    // @GetMapping("/selectOne")
    // public Result selectByIdOne(@RequestParam Integer id) {
    //     Department department = departmentService.selectById(id);
    //     return Result.success(department);
    // }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(Department department,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Department> pageInfo = departmentService.selectPage(department,pageNum, pageSize);
        return Result.success(pageInfo);
    }

}