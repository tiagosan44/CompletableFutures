package com.myProjects;

import java.util.concurrent.CompletableFuture;

public class HandleErrors {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(HandleErrors::getValue)
                .exceptionally(HandleErrors::handleError)
                .thenApply(integer -> getAnotherValue())
                .thenApply(integer -> integer + 8)
                .thenApply(integer -> integer + 2)
                .exceptionally(HandleErrors::handleError)
                .thenApply(integer -> integer + 10)
                .thenAccept(System.out::println);
    }

    public static int getValue() {
        blowUp();
        return 5;
    }

    public static int getAnotherValue() {
        blowUp();
        return 50;
    }

    public static void blowUp() {
        throw  new RuntimeException();
    }

    public static int handleError(Throwable throwable) {
        return 10;
    }
}
