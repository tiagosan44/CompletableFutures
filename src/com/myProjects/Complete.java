package com.myProjects;

import java.util.concurrent.CompletableFuture;

public class Complete {

    public static void main(String[] args) {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        getReady(completableFuture);
        getReady2(completableFuture);
        completableFuture.complete(7);
    }

    public static void getReady(CompletableFuture<Integer> future) {
        future.thenApply(integer -> integer * 5)
                .thenApply(integer -> integer + 20)
                .thenAccept(System.out::println);
    }

    public static void getReady2(CompletableFuture<Integer> future) {
        future.thenApply(integer -> integer * 5)
                .thenApply(integer -> integer * 100)
                .thenAccept(System.out::println);
    }
}
