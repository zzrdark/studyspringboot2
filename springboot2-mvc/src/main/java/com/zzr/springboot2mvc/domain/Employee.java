package com.zzr.springboot2mvc.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Employee implements Serializable {

    public interface Update{}

    public interface Add{}


    @NotNull(groups = Update.class)
    @NotNull(groups = Add.class)
    private String name;
    @Size(min= 1,max = 2,groups = Update.class)
    private Integer age;
    @NotNull(groups = Update.class)
    @NotNull(groups = Add.class)
    private String gender;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", gender=" + gender
                + "]";
    }
}
