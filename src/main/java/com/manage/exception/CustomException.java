package com.manage.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project：springboot_vue
 * @since：2025/5/17 3:08
 * @author：wzx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private String code;
    private String msg;
}
