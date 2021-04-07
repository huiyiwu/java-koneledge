package com.huchx.design.pattern.factory;

public class FactoryTestDemo {
    public static void main(String[] args) {
        System.out.println("=========简单工厂=============");
        Car dzCar = Factorys.CarFactory.createCar("DZ");
        Car adCar = Factorys.CarFactory.createCar("AD");
        dzCar.run();
        adCar.run();

        System.out.println("=========工厂方法=============");
        Car dzCar1 = Factorys.DZCarFactory.createCar();
        Car adCar1 = Factorys.AoDiCarFactory.createCar();
        dzCar1.run();
        adCar1.run();
    }
}
