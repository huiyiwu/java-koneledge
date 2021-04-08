package com.huchx.helloword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Map<String,Object> map){
        map.put("name","Freemarker模板测试");
        map.put("sex",1);
        List<String> users = new ArrayList<>();
        users.add("hucxh1");
        users.add("hucxh2");
        users.add("hucxh3");
        map.put("users",users);
        return "index";
    }
}
