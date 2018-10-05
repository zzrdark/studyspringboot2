package com.zzr.springboot2mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodType;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public String say(Model model){
        model.addAttribute("name","helloworld");
        return "index.btl";
    }

    @RequestMapping("/hello2")
    public @ResponseBody String say(){
        return "helloworld";
    }

    /**
     * 匹配 Consumer 是对应请求的Http协议里的Content-Type 字段
     * 匹配 Produces 是对应请求时Http协议里的Accept字段
     *
     * 匹配 params ，Header 匹配这两个的值
     */

    @RequestMapping(value = "/hello3", method = RequestMethod.GET, consumes = "application/json",
    produces = "application/json", params = "action=update", headers = "myHeader=myValue")
    public @ResponseBody String say1(){
        return "helloworld";
    }

    /**
     * 如果参数名不同 可以@PathVariable("id") 来指定
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    public @ResponseBody Long getById(@PathVariable("id") Long id){
        return id;
    }

    /**
     * Spring 提供了简化的RequestMapping
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     * @return
     */
    @GetMapping("/gethello")
    public @ResponseBody String sayGet(){
        return "helloworld";
    }

}
