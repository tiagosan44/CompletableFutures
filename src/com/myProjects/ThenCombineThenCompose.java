package com.myProjects;

import java.util.concurrent.CompletableFuture;

public class ThenCombineThenCompose {

    public static void main(String[] args) {
        int userId = 5;
//        getValuesAsync(userId)
//                .thenCombine(getOtherValuesAsync(userId), (a, b) -> a + b)
//                .thenAccept(System.out::println);
        getValuesAsync(userId)
                .thenCompose(ThenCombineThenCompose::getOtherValuesAsync)
                .thenAccept(System.out::println);

        sleepALittleBitMore();
    }

    public static CompletableFuture<Integer> getValuesAsync(int value) {
        return CompletableFuture.supplyAsync(() -> process(value));
    }

    public static CompletableFuture<Integer> getOtherValuesAsync(int value) {
        return CompletableFuture.supplyAsync(() -> anotherProcess(value));
    }

    public static int process(int value) {
        sleepALittleBit();
        return value * 4;
    }

    public static int anotherProcess(int value) {
        sleepALittleBit();
        return  value * 10;
    }

    public static void sleepALittleBit() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepALittleBitMore() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
