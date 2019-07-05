package com.springboot.demo.SpringbootTest.desginer.singleton;

public class TicketMakeForLazy {
    public static TicketMakeForLazy single = null;
    public int num = 10000;

    public static synchronized TicketMakeForLazy getInstance() {
        if (single == null) {
            single = new TicketMakeForLazy();
        }

        return single;
    }

    public static TicketMakeForLazy getInstanceBlock() {
        if (single == null) {
            synchronized (TicketMakeForLazy.class) {
                if (single == null) {
                    single = new TicketMakeForLazy();
                }

            }
        }
        return single;
    }

    public int getNextTicketNum() {
        return ++num;
    }

    public static void main(String[] args) {
        int a = 1;
        for (int i = 0; i < 100; i++) {
            System.out.println(TicketMakeForLazy.getInstanceBlock().getNextTicketNum());
        }
    }

}
