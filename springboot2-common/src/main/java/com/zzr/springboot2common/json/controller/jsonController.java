package com.zzr.springboot2common.json.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzr.springboot2common.json.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/json")
public class jsonController {

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping("/user/{id}")
    public @ResponseBody User showUserInfo(@PathVariable("id")Long id) {
        User user = new User();
        user.setId(id);
        user.setName("zzr");
        user.setAge(11);
        user.setSex("women");

        //model.addAttribute("user",user);
        return user;
    }

    @GetMapping("/now")
    public @ResponseBody Map datetime(){
        Map map = new HashMap();
        map.put("time",new Date());
        return map;
    }

    @GetMapping("/readTree")
    public @ResponseBody String readTree() throws IOException {
        String json = "{\"name\":\"zzr\",\"id\":10}";
        JsonNode jsonNode = mapper.readTree(json);
        jsonNode.get("name").asText();
        jsonNode.get("id").asInt();
        return null;
    }

    @GetMapping("/databind")
    public @ResponseBody String datebing() throws IOException {

        String json = "{\"name\":\"zzr\",\"id\":10}";

        User user = mapper.readValue(json,User.class);
        return null;
    }

    @GetMapping("/serialization")
    public @ResponseBody String serialization() throws IOException {

        User user = new User();
        user.setId(1L);
        user.setName("zzr");
        user.setAge(11);
        user.setSex("women");

        String json = mapper.writeValueAsString(user);
        return null;
    }
}
