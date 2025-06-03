
package com.example;

import com.example.service.TransferService;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewMethod;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Random;

public class TrafficSimulator {

    private static final String[] ACCOUNTS = { "A100", "B200" };
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

            transferService.transfer(from, to, amount);

            // Thread.sleep(300 + RANDOM.nextInt(700)); // Sleep 300–1000ms between
            // transfers
        }

        // System.out.println("\n🚀 Generating unique classes to pressure
        // Metaspace...");
        // createDummyClasses();

        // System.out.println("✅ Done. Suggesting GC...");
        // System.gc();
        Thread.sleep(10000); // keep alive for VisualVM
        context.close();
    }

    public static void createDummyClasses() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String className = "com.example.GeneratedClass" + i;
            CtClass ctClass = pool.makeClass(className);

            // Add dummy field/method to make class size non-trivial
            ctClass.addField(CtField.make("private int value = " + i + ";", ctClass));
            ctClass.addMethod(CtNewMethod.make("public int getValue() { return value; }", ctClass));

            // Create unique ClassLoader to make class GC-eligible
            URLClassLoader loader = new URLClassLoader(new URL[0], null);
            ctClass.toClass(loader, null); // don't keep ref

            // Free memory aggressively
            ctClass.detach();

            if (i % 1000 == 0) {
                System.out.println("Loaded " + i + " dummy classes...");
            }
        }
    }

}
