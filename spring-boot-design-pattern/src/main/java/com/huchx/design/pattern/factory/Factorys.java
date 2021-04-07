package com.huchx.design.pattern.factory;

/**
 *
 */
public class Factorys {
    //简单工厂
    public static class CarFactory{
        static public Car createCar(String carName){
            Car car = null;
            if (carName.equals("DZ")){
                car = new DZCar();
            }else if (carName.equals("AD")){
                car = new AoDiCar();
            }
            return car;
        };
    }
    //工厂方法
    public static class DZCarFactory{
        static public Car createCar(){
            return new DZCar();
        }
    }
    public static class AoDiCarFactory{
        static public Car createCar(){
            return new AoDiCar();
        }
    }
}
