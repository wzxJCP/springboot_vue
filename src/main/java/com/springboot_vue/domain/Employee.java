package com.springboot_vue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @project：springboot_vue
 * @since：2025/5/19 9:48
 * @author：wzx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Integer id;
    private String name;
    private String sex;
    private String no;
    private Integer age;
    private String description;
    private Integer deptId;
}