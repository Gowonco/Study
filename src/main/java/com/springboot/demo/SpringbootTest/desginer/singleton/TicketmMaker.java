package com.springboot.demo.SpringbootTest.desginer.singleton;

public class TicketmMaker {
    private int num = 10000;
    public static TicketmMaker ticketmMaker = new TicketmMaker();

    private TicketmMaker() {
    }

    public static TicketmMaker getInstance() {
        return   ticketmMaker;
    }

    public synchronized int getNextTicketNum() {
        return ++num;
    }

    public static void main(String[] args) {
        for (int i = 0; i< 100; i++) {
            System.out.println(TicketmMaker.getInstance().getNextTicketNum());
        }
    }
}
