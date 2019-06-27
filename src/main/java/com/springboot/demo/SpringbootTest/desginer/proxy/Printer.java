package com.springboot.demo.SpringbootTest.desginer.proxy;

public class Printer implements Printable {

    private String name;

    public Printer () {
        heavyJob("正在生成Printer实例");
    }
    public Printer (String name) {
        this.name = name;
        heavyJob("正在生成Printer实例" + name);
    }
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrintName() {
        return name;
    }

    @Override
    public void print(String str) {
        System.out.println("=="+name+"==");
        System.out.println(str);
    }

    public void heavyJob(String msg) {
        System.out.println(msg);
        for(int i=0;i<5;i++) {
            try {
                Thread.sleep(1000);
                System.out.println("。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
