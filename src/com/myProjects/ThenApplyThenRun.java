package com.myProjects;

import java.util.concurrent.CompletableFuture;

public class ThenApplyThenRun {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> longNetworkProcess(7))
                .thenApply(ThenApplyThenRun::performSomeOperations)
                .thenApply(ThenApplyThenRun::performSomeOperations)
                .thenAccept(System.out::println)
                .thenRun(ThenApplyThenRun::veryLongProcess)
                .thenRun(ThenApplyThenRun::veryLongProcess);
        sleepALongWhile();
    }

    public static int longNetworkProcess(int value) {
        sleepALittleBit();
        return value * 10;
    }

    public static void veryLongProcess() {
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

    public static void sleepALongWhile() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int performSomeOperations(int value) {
        System.out.println(Thread.currentThread());
        if(value % 2 == 0) {
            value += 1;
        } else {
            value += 3;
        }
        return value;
    }
}
