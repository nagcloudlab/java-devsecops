
package com.example;

import com.example.dto.TransferRequest;
import com.example.dto.TransferResponse;
import com.example.service.TransferService;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example")
public class TrafficSimulator {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger("transfer-service");

    private static final String[] ACCOUNTS = { "1234567890", "0987654321" };
    @SuppressWarnings("java:S2245")
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {

        ConfigurableApplicationContext context = SpringApplication.run(TrafficSimulator.class, args);
        TransferService transferService = context.getBean(TransferService.class);

        System.out.println("📡 Starting simulated live traffic...\n");

        for (int i = 0; i < 0; i++) {
            String from;
            String to;
            do {
                from = ACCOUNTS[RANDOM.nextInt(ACCOUNTS.length)];
                to = ACCOUNTS[RANDOM.nextInt(ACCOUNTS.length)];
            } while (from.equals(to));

            double amount = 100 + RANDOM.nextDouble(500); // 100 to 600
            TransferRequest transferRequest = new TransferRequest(from, to, amount);
            TransferResponse response = transferService.transfer(transferRequest);

            logger.info("Transfer response: {}", response);

            // Simulate a delay between requests
            Thread.sleep(RANDOM.nextInt(1000) + 500); // 500 to 1500 ms

        }

    }

}
