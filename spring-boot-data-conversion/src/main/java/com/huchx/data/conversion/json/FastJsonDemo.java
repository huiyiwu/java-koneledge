package com.huchx.data.conversion.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * publicstaticfinalObject parse(String text);// 把JSON文本parse为JSONObject或者JSONArray
 * publicstaticfinalJSONObject parseObject(String text)；// 把JSON文本parse成JSONObject
 * publicstaticfinal<T> T parseObject(String text, Class<T> clazz);// 把JSON文本parse为JavaBean
 * publicstaticfinalJSONArray parseArray(String text);// 把JSON文本parse成JSONArray
 * publicstaticfinal<T> List<T> parseArray(String text, Class<T> clazz);//把JSON文本parse成JavaBean集合
 * publicstaticfinalString toJSONString(Object object);// 将JavaBean序列化为JSON文本
 * publicstaticfinalString toJSONString(Object object,booleanprettyFormat);// 将JavaBean序列化为带格式的JSON文本
 * publicstaticfinalObject toJSON(Object javaObject); 将JavaBean转换为JSONObject或者JSONArray。
 */
public class FastJsonDemo {
    static String jsonStr = "{\"sites\":[{\"name\":\"huchx\",\"url\":\"www.baidu.com\"},{\"name\":\"王金\",\"url\":\"http://google.com/\"}]}";

    public static void main(String[] args) {
        System.out.println("=========JSON字符串转为JSON对象============");
        strToObj();
        System.out.println("=========JSON对象转为JSON字符串============");
        objToStr();
    }

    /**
     * Json对象转为Json字符串
     */
    private static void objToStr() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject stObject = new JSONObject();
        stObject.put("name","huchx");
        stObject.put("url","www.baidu.com");
        jsonArray.add(stObject);
        jsonObject.put("sites",jsonArray);
        System.out.println(jsonObject.toJSONString());
    }

    /**
     * Json字符串转为JSON对象
     */
    private static void strToObj() {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonStrObject = JSON.parseObject(jsonStr);
        JSONArray jsonArray = jsonStrObject.getJSONArray("sites");
        for (Object obj : jsonArray){
            JSONObject stObject = (JSONObject) obj;
            String name =  stObject.getString("name");
            String url = stObject.getString("url");
            System.out.println("name:"+name+"------url:"+url);
        }
    }
}
