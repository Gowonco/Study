package com.springboot.demo.SpringbootTest.desginer.factory;

/**
 * @author gowonco
 * @date 2019-06-27 17:36
 */
public class IDCard extends Product {
    private String woner;

    IDCard(String woner) {
        this.woner = woner;
        System.out.println("正在生成" + woner + "的IC卡");
    }

    public String getWoner() {
        return woner;
    }

    public void setWoner(String woner) {
        this.woner = woner;
    }

    @Override
    public void use() {
        System.out.println("正在使用" + woner + "的IC卡");
    }
}
