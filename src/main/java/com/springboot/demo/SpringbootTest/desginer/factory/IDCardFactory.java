package com.springboot.demo.SpringbootTest.desginer.factory;

/**
 * IDCard 工厂类
 * @author gowonco
 * @date 2019-06-27 17:46
 */
public class IDCardFactory extends Factory{

    public IDCard createIDCard(String woner) {
        return new IDCard(woner);
    }

    @Override
    public IDCard factoryCreateIDCard(String woner) {
        return new IDCard(woner);
    }

    public static void main(String[] args) {
        IDCardFactory factory = new IDCardFactory();
        IDCard card1 = factory.factoryCreateIDCard("张三");
        IDCard card2 = factory.factoryCreateIDCard("李四");
        IDCard card3 = factory.createIDCard("王五");
        card1.use();
    }
}
