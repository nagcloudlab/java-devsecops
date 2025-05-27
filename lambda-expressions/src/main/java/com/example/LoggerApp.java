package com.example;

import java.util.function.Consumer;

public class LoggerApp {

    public static void main(String[] args) {

        Consumer<String> consoleLogger = line -> {
            System.out.println("CONSOLE: " + line);
        };

        Consumer<String> fileLogger = line -> {
            // Simulate writing to a file
            System.out.println("FILE: " + line);
        };

        String log = "server started successfully";
        Consumer<String> consoleAndFileLogger = consoleLogger.andThen(fileLogger);
        consoleAndFileLogger.accept(log);

    }

}
