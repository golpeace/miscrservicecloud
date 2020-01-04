package com.miscloud.exception;

import com.miscloud.entiy.Dept;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class ProjectExceptionHandler {
//    @ExceptionHandler(Exception.class)
    public Dept exceptionMethod(Exception e){
            return new Dept().setId(0).setDeptName("Runtime Exception").setDataBaseName(e.getMessage());
    }
}
