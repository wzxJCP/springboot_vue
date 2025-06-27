package com.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project：springboot_vue
 * @since：2025/6/25 1:29
 * @author：wzx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String role;
    private String newPassword;
    private String avatar;
}
