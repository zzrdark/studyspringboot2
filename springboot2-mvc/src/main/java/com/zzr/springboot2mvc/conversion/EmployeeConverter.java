package com.zzr.springboot2mvc.conversion;

import com.zzr.springboot2mvc.domain.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
//先不扫描使用
//@Component
public class EmployeeConverter implements Converter<String, Employee> {


    @Override
    public Employee convert(String str) {
        //如果这里是json  就可以直接 Gson去解析

        Employee emp=null;
        //字符串格式 name-age-gender
        if(str!=null && str.split("-").length==3){
            emp=new Employee();
            String[] arr=str.split("-");
            emp.setName(arr[0]);
            emp.setAge(Integer.parseInt(arr[1]));
            emp.setGender(arr[2]);
        }
        return emp;
    }
}
