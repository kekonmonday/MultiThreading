package laba1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class RaceConditionThread implements Runnable {

    private AtomicInteger value = new AtomicInteger(0);

    public void run() {
        printValue();
        try {
            add(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printValue();
        decrement(10);
        printValue();
    }

    private void printValue() {
        Logger.getAnonymousLogger().info(String.format("Current value = %s threadId = %s", this.value.intValue(), Thread.currentThread().getName()));
    }

    private void add(int value) throws InterruptedException {
        Thread.sleep(10);
        this.value.addAndGet(value);
    }

    private void decrement(int value) {
        this.value.addAndGet(-value);
    }

   /* private int getCurrentValue() {
        return this.value;
    }*/
}
