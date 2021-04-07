package com.huchx.annotation.method;

import java.lang.reflect.Method;

public class MyAnnotationDemo {

    public static void main(String[] args) {
      show();
    }

    /**
     * 获取方法注解的值
     */
    @MyAnnotation(beanId = 123,className = "user1",arrays = {"111","222"})
    private static void show() {
        Class<MyAnnotationDemo> clazz = MyAnnotationDemo.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method.getName());
            if (method.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("beanId:"+ annotation.beanId()+"--className:"+ annotation.className()+"--arrays:"+annotation.arrays().toString());
            }
        }
    }
}
