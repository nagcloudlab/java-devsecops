package com.example;

import java.util.ArrayList;
import java.util.List;

public class GcPauseDemo {

    public static void main(String[] args) {

        // Heartbeat thread: prints timestamp every 100ms
        Thread heartbeat = new Thread(() -> {
            while (true) {
                System.out.println("🟢 App thread alive: " + System.currentTimeMillis());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        heartbeat.setDaemon(true);
        heartbeat.start();

        // Allocate memory to trigger GC
        List<byte[]> memoryHog = new ArrayList<>();
        try {
            for (int i = 0; i < 10000; i++) {
                memoryHog.add(new byte[1024 * 1024]); // 1 MB chunks
                Thread.sleep(10); // Give time for GC to kick in
            }
        } catch (OutOfMemoryError | InterruptedException e) {
            System.err.println("❗️Memory pressure interrupted or OOM");
        }

        System.out.println("✅ Done allocating memory.");
    }
}
