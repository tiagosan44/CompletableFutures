package com.myProjects;

import java.util.concurrent.CompletableFuture;

public class SupplyAsync {

    public static void main(String[] args) {
        System.out.println("Starting process...");
        CompletableFuture.supplyAsync(() -> longNetworkProcess(5))
                .thenAccept(i -> System.out.println("Supplier in alternative thread complete " + i));
        System.out.println("Process called..");
        System.out.println("Sleeping main thread for a little bit");
        sleepALittleBit();
        System.out.println("Main thread done sleeping");
    }

    public static int longNetworkProcess(int value) {
        sleepALittleBit();
        return value * 10;
    }

    public static void sleepALittleBit() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
