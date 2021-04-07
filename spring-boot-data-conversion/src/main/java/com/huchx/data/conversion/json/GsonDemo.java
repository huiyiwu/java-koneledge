package com.huchx.data.conversion.json;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonDemo {
    static String jsonStr = "{\"sites\":[{\"name\":\"huchx\",\"url\":\"www.baidu.com\"},{\"name\":\"王金\",\"url\":\"http://google.com/\"}]}";

    public static void main(String[] args) {
        System.out.println("=========JSON字符串转为JSON对象============");
        strToObj();
        System.out.println("=========JSON对象转为JSON字符串============");
        objToStr();
    }

    private static void objToStr() {
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> childMap = new HashMap<String, Object>();
        childMap.put("name","huchx");
        childMap.put("url","www.baidu.com");
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        list.add(childMap);
        map.put("sites",list);
        System.out.println(gson.toJson(map));
    }

    private static void strToObj() {
        Gson gson = new Gson();
        Map<String,Object> jsonObj= gson.fromJson(jsonStr,Map.class);
        System.out.println(jsonObj.toString());
    }
}
