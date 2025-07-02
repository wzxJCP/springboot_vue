package com.manage.controller;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.manage.common.Result;
import com.manage.domain.Account;
import com.manage.domain.Employee;
import com.manage.exception.CustomException;
import com.manage.service.AdminService;
import com.manage.service.ArticleService;
import com.manage.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
    @Resource
    private ArticleService articleService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    /**
     * 管理员/员工 角色登录
     *
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
     *
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

    // @GetMapping("/barData")
    // public Result barData() {
    //     Map<String, Object> map = new HashMap<>();
    //     List<Employee> employeeList = employeeService.selectAll(null);
    //     Set<String> departmentNameSet = employeeList.stream().map(Employee::getDeptName).collect(Collectors.toSet());
    //     // x轴数据
    //     map.put("department", departmentNameSet);
    //     List<Long> countList = new ArrayList<>();
    //     for (String deptName : departmentNameSet) {
    //         long count = employeeList.stream().filter(employee -> employee.getDeptName().equals(deptName)).count();
    //         countList.add(count);
    //     }
    //     // y轴员工数量的数据
    //     map.put("count", countList);
    //     return Result.success(map);
    // }
    // Cannot invoke "String.equals(Object)" because the return value of "com.manage.domain.Employee.getDeptName()" is null (报错案例↑↑↑↑↑)

    /**
     * 柱状图数据
     * @return
     */
    @GetMapping("/barData")
    public Result barData() {
        // 创建一个 Map 用来存放返回给前端的数据
        Map<String, Object> map = new HashMap<>();
        // 查询所有员工数据（从数据库中获取）
        List<Employee> employeeList = employeeService.selectAll(null);
        /*
         * 使用 Java Stream 流处理数据：
         * 1. 先过滤掉部门名称为 null 的员工（避免空指针异常）
         * 2. 按照 "部门名称" 进行分组统计，计算每个部门有多少人
         * 最终结果是一个 Map：key 是部门名，value 是该部门的人数
         */
        Map<String, Long> countMap = employeeList.stream()
                // 过滤掉部门为空的员工
                .filter(e -> e.getDeptName() != null)
                // 按部门名称进行分组 （分组依据：员工所属部门，统计每组的数量）
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
        /*
         * 将部门名称放入 map 中，作为柱状图的 X 轴数据
         * 如：["技术部", "产品部", "市场部"]
         */
        map.put("department", countMap.keySet());
        /*
         * 将每个部门的人数放入 map 中，作为柱状图的 Y 轴数据
         * 如：[10, 5, 8]
         */
        map.put("count", countMap.values());
        // 返回成功的结果，并把 map 数据传给前端
        return Result.success(map);
    }

    /**
     * 7天内发布文章数量折线图数据
     * @return
     */
    @GetMapping("/lineData")
    public Result lineData() {
        // 创建一个 Map 用来存放返回给前端的数据
        Map<String, Object> map = new HashMap<>();
        Date date = new Date();
        DateTime start = DateUtil.offsetDay(date, -7);
        List<DateTime> dateTimeList = DateUtil.rangeToList(start, date, DateField.DAY_OF_YEAR);
        List<String> dateStrList = dateTimeList.stream().map(dateTime -> DateUtil.format(dateTime, "MM月dd日"))
                .sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        map.put("date", dateStrList);

        List<Integer> countList = new ArrayList<>();
        for (DateTime day : dateTimeList) {
            String dayFormat = DateUtil.formatDate(day);
            Integer count = articleService.selectCountByDate(dayFormat);
            countList.add(count);
        }
        map.put("count", countList);
        // 返回成功的结果，并把 map 数据传给前端
        // System.out.println("\n" + countList);
        return Result.success(map);
    }

    /**
     * 饼图数据
     * @return
     */
    @GetMapping("/pieData")
    public Result pieData() {
        List<Map<String, Object>> list = new ArrayList<>();
        List<Employee> employeeList = employeeService.selectAll(null);
        Set<String> departmentNameSet = employeeList.stream().map(Employee::getDeptName).collect(Collectors.toSet());
        for (String deptName : departmentNameSet) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", deptName);
            long count = employeeList.stream().filter(employee -> Objects.equals(employee.getDeptName(), deptName)).count();
            map.put("value", count);
            list.add(map);
        }
        return Result.success(list);
    }

}
