package com.springboot_vue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project：springboot_vue
 * @since：2025/5/17 2:40
 * @author：wzx
 */
@RestController
public class WebController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}
