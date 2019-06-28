package com.springboot.demo.SpringbootTest.desginer.template;

/**
 * @author gowonco
 * @date 2019-06-28 11:27
 */
public abstract class AbstractDisplay {
    /**
     * 打印前
     */
    public abstract void before();

    /**
     * 打印中
     */
    public abstract void print();

    /**
     * 打印后
     */
    public abstract void after();

    /**
     * 显示打印
     */
    public final void display(){
        before();
        print();
        after();
    }
}
