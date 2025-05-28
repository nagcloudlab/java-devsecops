package com.example;

import com.example.model.Trader;
import com.example.model.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //--------------------------------------------------------
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        // Query 2: What are all the unique cities where the traders work?
        // Query 3: Find all traders from Cambridge and sort them by name.
        // Query 5: Are there any trader based in Milan?
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        //----------------------------------------------------------

        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).

        System.out.println(
                transactions
                        .stream()
                        .filter(t -> t.getYear() == 2011)
                        .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                        .collect(Collectors.toList())
        );

        System.out.println();
        // Query 2: What are all the unique cities where the traders work?

        transactions
                .stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(city -> System.out.println(city));


        System.out.println();
        // Query 3: Find all traders from Cambridge and sort them by name.
        transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .forEach(trader -> System.out.println(trader.getName()));


        // Query 5: Are there any trader based in Milan?
        System.out.println();
        boolean isAnyTraderInMilan = transactions
                .stream()
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println("Is there any trader based in Milan? " + isAnyTraderInMilan);


        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        System.out.println();
        transactions
                .stream()
                .filter(t -> "Milan".equals(t.getTrader().getCity()))
                .map(t -> {
                    t.getTrader().setCity("Cambridge");
                    return t;
                })
                .forEach(t -> System.out.println("Updated transaction: " + t.getTrader().getName() + " now in " + t.getTrader().getCity()));

    }

}
