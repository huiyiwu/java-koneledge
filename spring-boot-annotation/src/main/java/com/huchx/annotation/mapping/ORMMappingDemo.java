package com.huchx.annotation.mapping;

import com.huchx.annotation.mapping.entity.User;

import java.io.File;
import java.lang.reflect.Field;

public class ORMMappingDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<User> clazz = (Class<User>) Class.forName("com.huchx.annotation.mapping.entity.User");
        SetTable setTable = clazz.getAnnotation(SetTable.class);
        Field[] fields = clazz.getDeclaredFields();
        StringBuffer sf = new StringBuffer();
        sf.append("select");
        for (int i=0;i<fields.length;i++){
            Field field  =fields[i];
            SetProperty setProperty = field.getAnnotation(SetProperty.class);
            sf.append(" "+setProperty.name());
            if (i==fields.length-1){
                sf.append(" from ");
            }else {
                sf.append(",");
            }
        }
        sf.append(setTable.value());
        System.out.println(sf.toString());
    }
}
