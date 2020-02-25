package laba1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private final static int COUNT = 1000;

    public static void main(String[] args) {
        RaceConditionThread raceConditionThread = new RaceConditionThread();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int index = 0; index < COUNT; index++) {
            executorService.execute(raceConditionThread);
        }

    }

}
