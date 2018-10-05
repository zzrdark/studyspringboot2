package com.zzr.springboot2mvc.controller;

import com.zzr.springboot2mvc.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class EmployeeValidatedController {

    public void addEmployee(@Validated(Employee.Add.class)Employee employee, BindingResult bindingResult){
        //看看有没有错误
        if(bindingResult.hasErrors()){

        }else{
            //查看有什么错
            bindingResult.getAllErrors();

        }
    }
}
