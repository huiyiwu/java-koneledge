package com.huchx.data.conversion.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonDemo {
    static String jsonStr = "{\"sites\":[{\"name\":\"huchx\",\"url\":\"www.baidu.com\"},{\"name\":\"王金\",\"url\":\"http://google.com/\"}]}";

    public static void main(String[] args) {
        System.out.println("=========JSON字符串转为JSON对象============");
        strToObj();
        System.out.println("=========JSON对象转为JSON字符串============");
        objToStr();
    }

    private static void objToStr() {
        ObjectMapper objectManager = new ObjectMapper();
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> childMap = new HashMap<String, Object>();
        childMap.put("name","huchx");
        childMap.put("url","www.baidu.com");
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        list.add(childMap);
        map.put("sites",list);
        try {
            System.out.println(objectManager.writeValueAsString(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static void strToObj() {
        ObjectMapper objectManager = new ObjectMapper();
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            map = objectManager.readValue(jsonStr,Map.class);
            System.out.println(map.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
