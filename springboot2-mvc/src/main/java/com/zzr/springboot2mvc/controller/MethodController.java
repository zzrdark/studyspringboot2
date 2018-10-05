package com.zzr.springboot2mvc.controller;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @PathVariable 可以将URl中的键值到方法类型
 * Model ModelMap 作为渲染视图的模型
 * ModelAndView 包含了模型和视图路径的对象
 * JavaBean  将Http参数映射到javabean对象上
 * @ModelAttribute 使用该注释的变量将作为Model的一个属性。
 * @InitBinder
 *
 */
@Controller
@RequestMapping("/Method")
public class MethodController {

    /**
     * Model & ModelMap
     *  用来作为渲染视图的模型
     *
     */
    @RequestMapping("/hello")
    public String say(Model model){
        model.addAttribute("name","helloworld");

        return "index.btl";
    }
    /**
     *  ModelAndView
     *  包含了模型和视图路径的对象
     *
     */
    @RequestMapping("/{id}/get2")
    public ModelAndView getId(@PathVariable Long id, ModelAndView view){
        view.addObject("user","zzr");
        view.setViewName("/index.btl");
        return view;
    }

    /**
     *  JavaBean  将Http参数映射到javabean对象上
     *
     *  name = name
     *  order.name = Order对象的name
     *  details[0].name = List对象的name
     *  但不支持set 因为 set 不支持 索引取值
     */
    @RequestMapping("/helloparam")
    @ResponseBody
    public String say1(@RequestParam(name = "id",required = true) Integer id){
        return "" + id;
    }


    @ModelAttribute
    public void findById(@PathVariable Long id ,Model model){
        model.addAttribute("id",id);
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String getId(Model model){
        //这里model可以取出之前ModelAttribute那个方法的id
        model.asMap();
        //也可以查看是否存在这个值 再去获取
        model.containsAttribute("id");
        return "succuss";
    }
    /**
     * @Ininbinder  用在这个方法上，说明这个方法会注册到多个转化器，
     * 用来个性化的讲http请求参数转化成对应的java对象，
     * 比如转化日期类型，浮点类型，javabean
     * 当然可以实现webBingingInitalizer 接口 用于Springboot应用需要的DataBinder
     *
     */

    @InitBinder
    protected void initBinger(WebDataBinder binder){
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
        //接下来在遇到这个类型的时候就会自动转换

    }


}
