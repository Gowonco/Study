package com.springboot.demo.SpringbootTest.desginer.template;

/**
 * @author gowonco
 * @date 2019-06-28 11:41
 */
public class HelloDispaly extends AbstractDisplay {

    private  String str;
    public HelloDispaly(String str) {
        this.str = str;
    }

    @Override
    public void before() {
        System.out.println(">>>>>>>>>");
    }

    @Override
    public void print() {
        System.out.println(str);
    }

    @Override
    public void after() {
        System.out.println("<<<<<<<<<");
    }
}
