
package com.example;

import com.example.service.TransferService;
import com.example.Calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Random;

public class TrafficSimulator {

    private static final String[] ACCOUNTS = { "1234567890", "0987654321" };
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException, Exception {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        TransferService transferService = context.getBean(TransferService.class);

        System.out.println("📡 Starting simulated live traffic...\n");

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            // Randomly pick two different accounts
            String from, to;
            do {
                from = ACCOUNTS[RANDOM.nextInt(ACCOUNTS.length)];
                to = ACCOUNTS[RANDOM.nextInt(ACCOUNTS.length)];
            } while (from.equals(to));

            double amount = 100 + RANDOM.nextInt(500); // 100 to 600
            System.out.printf("🔁 Simulating transfer #%d: %s -> %s | ₹%.2f\n", i + 1, from, to, amount);
            Calculator calc = new Calculator();
            System.out.println("Addition: " + calc.add(5, 3));
            transferService.transfer(from, to, amount);

            // Thread.sleep(300 + RANDOM.nextInt(700)); // Sleep 300–1000ms between
            // transfers
        }

    }

}
