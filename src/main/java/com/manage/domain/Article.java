package com.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project：springboot_vue
 * @since：2025/6/27 10:36
 * @author：wzx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Integer id;
    private String title;
    private String img;
    private String description;
    private String content;
    private String time;
}
