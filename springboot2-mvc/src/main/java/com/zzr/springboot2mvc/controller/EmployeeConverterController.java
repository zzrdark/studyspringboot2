package com.zzr.springboot2mvc.controller;

import com.zzr.springboot2mvc.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeConverterController {

    @RequestMapping("/addEmployee")
    public String add(@RequestParam(value = "employee",required = true)Employee employee){
        System.out.println(employee);
        return "add.btl";
    }
}
