package com.springboot.demo.SpringbootTest.desginer.proxy;


public class PrinterProxy implements Printable {

    private Printer real = null;

    private String name;


    public PrinterProxy (String name) {
        this.name = name;
    }

    public synchronized void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public  String getPrintName() {
        return name;
    }

    @Override
    public void print(String str) {
        realize();
        real.print(str);
    }


    public synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }


    public static void main(String[] args) {
        PrinterProxy proxy = new PrinterProxy("张三");
        System.out.println("现在的名字"+proxy.getPrintName());
        proxy.setPrinterName("李四");
        System.out.println("现在的名字"+proxy.getPrintName());
        proxy.print("hello...");
    }
}
