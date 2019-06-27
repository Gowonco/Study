package com.springboot.demo.SpringbootTest.desginer.singleton;

public class TicketMakerEnum {

    public int num = 10000;

    private TicketMakerEnum () {}

    public static TicketMakerEnum getInstance () {
        return Singleton.INSTENCE.getInstance();
    }

    public int getNextTicketNum () {
        return  ++num;
    }


    private  static enum  Singleton{
        INSTENCE;

        private TicketMakerEnum ticketMakerEnum;
        private  Singleton () {
            ticketMakerEnum = new TicketMakerEnum();
        }

        public TicketMakerEnum getInstance() {
            return ticketMakerEnum;
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            System.out.println(TicketMakerEnum.getInstance().getNextTicketNum());
        }
    }
}
