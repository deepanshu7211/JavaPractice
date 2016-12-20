package thrd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by deepanshu.saxena on 19/02/16.
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable worker = new WorkerThread(" ");
        for (int i = 0; i < 10; i++) {
//            Runnable worker=new WorkerThread(" "+i);
            executorService.execute(worker);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        System.out.println("finished all threads ");
    }
}


class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  started " + "  command :: " + command);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end ");
    }

    @Override
    public String toString() {
        return command;
    }
}