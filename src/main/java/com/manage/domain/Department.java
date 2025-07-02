package com.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project：springboot_vue
 * @since：2025/6/29 1:16
 * @author：wzx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String deptName;
}
