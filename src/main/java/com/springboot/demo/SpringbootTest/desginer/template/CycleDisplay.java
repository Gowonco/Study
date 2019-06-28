package com.springboot.demo.SpringbootTest.desginer.template;

/**
 * @author gowonco
 * @date 2019-06-28 11:47
 */
public class CycleDisplay extends AbstractDisplay {
    private  String str;
    private  int width;

    public CycleDisplay(String str) {
        this.str = str;
        width = str.getBytes().length;
    }

    @Override
    public void before() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("*"+str+"*");
    }

    @Override
    public void after() {
        printLine();
    }

    public void printLine() {
        System.out.print("+");
        for (int i=0;i<width;i++) {
            System.out.print("*");
        }
        System.out.println("+");
    }

    public static void main(String[] args) {
        AbstractDisplay display1 = new CycleDisplay("你还在吗");
        AbstractDisplay display2 = new HelloDispaly("hello");
        display1.display();
        display2.display();
    }
}
