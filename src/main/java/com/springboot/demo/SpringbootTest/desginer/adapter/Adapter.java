package com.springboot.demo.SpringbootTest.desginer.adapter;

/**
 * @author gowonco
 * @date 2019-06-27 20:16
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void walk() {
        super.birdWalk();
    }

    @Override
    public void fly() {
        super.birdFly();
    }

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.fly();
        adapter.walk();
    }
}
