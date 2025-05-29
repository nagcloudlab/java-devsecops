package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.service.TransferService;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example")
public class Application {
    public static void main(String[] args) {

        //-------------------------------------------------
        // init / boot phase
        //-------------------------------------------------
        // intilize & assemble the components

        //AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository("jdbc");
        //TransferService transferService = new UPITransferService(accountRepository);

        ConfigurableApplicationContext applicationContext = null;
        applicationContext = SpringApplication.run(Application.class, args);


        System.out.println();
        System.out.println();
        //-------------------------------------------------
        // run phase
        //-------------------------------------------------

        TransferService transferService = applicationContext.getBean("transferService", TransferService.class);
        transferService.transfer("1234567890", "0987654321", 100.0);


        System.out.println();
        System.out.println();
        //-------------------------------------------------
        // shutdown phase
        //-------------------------------------------------
        // clean up resources if needed
        if (applicationContext != null) {
            applicationContext.close();
        }

    }
}
