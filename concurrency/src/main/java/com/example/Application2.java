package com.example;


class TransferService {
    public void transfer(String from, String to, double amount) {
        // Logic to transfer money from one account to another
        System.out.println("Transferring " + amount + " from " + from + " to " + to);
    }
}

public class Application2 {
    public static void main(String[] args) {

        TransferService transferService = new TransferService();

        // 10K requests per second
        // request 1
        transferService.transfer("AccountA", "AccountB", 1000.0);
        // request 2
        transferService.transfer("AccountB", "AccountC", 2000.0);

    }
}
