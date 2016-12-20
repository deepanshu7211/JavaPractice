package thrd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by deepanshu.saxena on 02/04/16.
 */

public class ThreadEx {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new Worker();
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isShutdown()) {

        }
    }
}


class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. ");
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}