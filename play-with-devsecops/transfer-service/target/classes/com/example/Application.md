package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example")
public class Application {

    // private static Logger logger =
    // org.slf4j.LoggerFactory.getLogger("transfer-service");

    public static void main(String[] args) {

        // ----------------------------------------
        // init / boot
        // ----------------------------------------
        // initialize & assemble application's
        // components based on config

        // AccountRepository accountRepository =
        // AccountRepositoryFactory.getAccountRepository("jpa");
        // TransferService transferService = new UPITransferService(accountRepository);

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        // System.out.println();
        // System.out.println();
        // ----------------------------------------
        // run
        // ----------------------------------------

        // TransferService transferService =
        // applicationContext.getBean("transferService", TransferService.class);
        // transferService.transfer(
        // "A100",
        // "B200",
        // 100.0);

        // System.out.println();
        // System.out.println();
        // ----------------------------------------
        // shutdown
        // ----------------------------------------
        // clean up resources, if any
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (applicationContext != null) {
                applicationContext.close();
            }
            System.out.println("Application is shutting down...");
        }));

    }

}
