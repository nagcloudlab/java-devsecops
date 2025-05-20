package com.example;

public class ReferenceTypesExample {
    public static void main(String[] args) {


//        Account a1=new Account(); // Reference Types
//        System.out.println(a1.accountNumber);
//        System.out.println(a1.balance);
//
//        a1.accountNumber="123456789";
//        a1.balance=1000.0;
//
//        System.out.println(a1.accountNumber);
//        System.out.println(a1.balance);

        Account a2 = new Account("123456789");
        System.out.println(a2.accountNumber);
        System.out.println(a2.balance);

        Account a3 = new Account("987654321", 5000.0);
        System.out.println(a3.accountNumber);
        System.out.println(a3.balance);


        Account a4 = new Account("123456789", 1000.0);
        System.out.println(a4.accountNumber);
        System.out.println(a4.balance);
        System.out.println(a4.accountType);


        //a4.balance = -1000.00;

        System.out.println(a4.balance);

        a4.credit(500.0);
        System.out.println(a4.balance);
        a4.debit(200.0);
        System.out.println(a4.balance);


    }
}
