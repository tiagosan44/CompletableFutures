package com.myProjects;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class TimeOut {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(TimeOut::getValue)
                .completeOnTimeout(getTimeOutValue(), 1 , TimeUnit.SECONDS)
                //orTimeout throws an exception
                .thenAccept(System.out::println);
        sleepALittleBit();
        System.out.println("Main done sleeping..");
    }

    public static int getValue() {
        sleepALittleBit();
        return 10;
    }

    public static int getTimeOutValue() {
        return 89;
    }

    public static void sleepALittleBit() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
