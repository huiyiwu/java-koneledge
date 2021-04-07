package com.huchx.design.pattern.singlecase;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @单例设计模式 保证一个对象JVM中只能有一个实例, 常见单例 懒汉式、饿汉式
 */
public class SingeCasePatternDemo {
    /**
     * @懒汉式 需
     * 要的才会去实例化, 线程不安全。
     */
   public static class SluggardStyle {
        static SluggardStyle sluggardStyle;

        public SluggardStyle() {
        }

       synchronized public static SluggardStyle newInstance() {
            if (sluggardStyle == null) {
                sluggardStyle = new SluggardStyle();
            }
            return sluggardStyle;
        }
    }

    /**
     * @饿汉式
     * 当class文件被加载的时候，初始化，天生线程安全。
     */
   public static class HungryManStyle{
        //当class文件被加载时初始化
        private static HungryManStyle hungryManStyle = new HungryManStyle();

        public HungryManStyle() {
        }
        public static HungryManStyle newInstance() {
            return hungryManStyle;
        }
    }

    public static void main(String[] args) {
        System.out.println("=========懒汉式===========");
       SluggardStyle sluggardStyle1 = SluggardStyle.newInstance();
        SluggardStyle sluggardStyle2 = SluggardStyle.newInstance();
        System.out.println("SluggardStyle创建的实例:"+(sluggardStyle1==sluggardStyle2));
        System.out.println("=========饿汉式===========");
        HungryManStyle hungryManStyle1 = HungryManStyle.newInstance();
        HungryManStyle hungryManStyle2 = HungryManStyle.newInstance();
        System.out.println("HungryManStyle创建的实例:"+(hungryManStyle1==hungryManStyle2));


    }
}
