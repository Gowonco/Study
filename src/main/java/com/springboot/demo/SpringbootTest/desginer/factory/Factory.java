package com.springboot.demo.SpringbootTest.desginer.factory;

/**
 * 抽象工厂类
 * @author gowonco
 * @date 2019-06-27 17:54
 */
public abstract class Factory {

    public abstract IDCard factoryCreateIDCard(String woner);
}
