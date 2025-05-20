package com.springboot_vue.exception;

import com.springboot_vue.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @project：springboot_vue
 * @since：2025/5/17 2:56
 * @author：wzx
 */
@ControllerAdvice("com.spring_vue.controller")
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error();
    }
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result error(CustomException e){
        return Result.error(e.getCode(),e.getMsg());
    }

}
