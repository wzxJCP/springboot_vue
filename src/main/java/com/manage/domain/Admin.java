package com.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project：springboot_vue
 * @since：2025/6/24 10:12
 * @author：wzx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Account {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String role;
}
