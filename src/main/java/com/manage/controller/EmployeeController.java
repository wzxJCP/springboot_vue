package com.manage.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.github.pagehelper.PageInfo;
import com.manage.common.Result;
import com.manage.domain.Department;
import com.manage.domain.Employee;
import com.manage.mapper.DepartmentMapper;
import com.manage.service.DepartmentService;
import com.manage.service.EmployeeService;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

    @Resource
    private DepartmentService departmentService;

    /**
     * 新增用户
     *
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
        return Result.success("批量删除成功！");
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
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(Employee employee,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Employee> pageInfo = employeeService.selectPage(employee, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/export")
    public void exportData(HttpServletResponse response) throws Exception {
        // 1、拿到所有的员工数据
        List<Employee> employeeList = employeeService.selectAll(null);
        // 2、构建ExcelWriter 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        // 3、设置中文表头
        writer.addHeaderAlias("username", "用户名");
        writer.addHeaderAlias("role", "角色");
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("sex", "性别");
        writer.addHeaderAlias("no", "工号");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("description", "个人介绍");
        writer.addHeaderAlias("deptName", "部门");
        writer.addHeaderAlias("avatar", "头像");
        // 默认的，未添加alias的属性也会写出，如果想只写出加了别名的字段，可以调用此方法排除之
        writer.setOnlyAlias(true);
        // 4、写出数据到writer
        writer.write(employeeList, true);
        // 5、设置输出的文件的名称，以及输出流的头信息 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("员工信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        // 6、写出到输出流并关闭writer
        ServletOutputStream os = response.getOutputStream();
        writer.flush(os);
        writer.close();
    }

    @PostMapping("/import")
    public Result importData(MultipartFile file) throws IOException {
        // 1、构建 ExcelReader
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 2、表头映射（Excel 列名 -> Employee 实体字段）
        reader.addHeaderAlias("用户名", "username");
        reader.addHeaderAlias("角色", "role");
        reader.addHeaderAlias("姓名", "name");
        reader.addHeaderAlias("性别", "sex");
        reader.addHeaderAlias("工号", "no");
        reader.addHeaderAlias("年龄", "age");
        reader.addHeaderAlias("个人介绍", "description");
        // 映射到 deptName 字段
        reader.addHeaderAlias("部门", "deptName");
        reader.addHeaderAlias("头像", "avatar");
        List<Employee> employeeList = reader.readAll(Employee.class);
        // 3、写入list数据到数据库
        for (Employee employee : employeeList) {
            // 获取部门名称
            String deptName = employee.getDeptName();
            if (deptName != null && !deptName.isEmpty()) {
                // 根据部门名称查询 department_id
                Department department = departmentService.selectByName(deptName);
                if (department != null) {
                    employee.setDepartmentId(department.getId());
                } else {
                    // 如果找不到对应的部门，可以选择跳过或记录错误
                    continue;
                }
            } else {
                // 处理空部门情况
                employee.setDepartmentId(null);
            }
            // 清空 deptName，避免后续干扰（可选）
            employee.setDeptName(null);
            // 插入员工
            employeeService.add(employee);
        }
        return Result.success("数据导入成功！");
    }
}