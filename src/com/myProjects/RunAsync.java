package com.myProjects;

import java.util.concurrent.CompletableFuture;

public class RunAsync {

    public static void main(String[] args) {
        CompletableFuture.runAsync(RunAsync::veryLongProcess);
        sleepALittleBit();
    }

    public static void veryLongProcess() {
        System.out.println(Thread.currentThread());
        sleepALittleBit();
        System.out.println("Very long process done");
    }

    public static void sleepALittleBit() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
