package com.assignment_10.exceptions;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String hander(Exception e, Model model) {
        model.addAttribute("msg", e.getMessage());
        return "error.html";
    }


}