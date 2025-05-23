package com.example;

/**
 * create ATM machine with chain of currency handler
 * <p>
 * -> 100-handler
 * -> 500-handler
 * -> 200-handler
 */

interface Handler {
    void handle(double amount);
    void setNextHandler(Handler handler);
}
class FiveHundredHandler implements Handler {
    Handler nextHandler;
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public void handle(double amount) {
        System.out.println("500 - handling amount..");
        if (nextHandler != null) {
            nextHandler.handle(amount);
        }
    }
}
class TwoHundredHandler implements Handler {
    Handler nextHandler;
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public void handle(double amount) {
        System.out.println("200 - handling amount..");
        if (nextHandler != null) {
            nextHandler.handle(amount);
        }
    }
}


public class ChainOfResponsibilityPatternExample {
    public static void main(String[] args) {

        double amount = 100;

        Handler fiveHundredHandler = new FiveHundredHandler();
        Handler twoHundredHandler = new TwoHundredHandler();

        //fiveHundredHandler.setNextHandler(twoHundredHandler); // chain
        //fiveHundredHandler.handle(1700);

        twoHundredHandler.setNextHandler(fiveHundredHandler);
        twoHundredHandler.handle(1700);

    }
}
