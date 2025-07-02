package com.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project：springboot_vue
 * @since：2025/5/19 9:48
 * @author：wzx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Account {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String name;
    private String sex;
    private String no;
    private Integer age;
    private String description;
    // 对应数据库字段 department_id
    private Integer departmentId;
    // 用于接收 Excel 中的“部门名称”
    private String deptName;
}