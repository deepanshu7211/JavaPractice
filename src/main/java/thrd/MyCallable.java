package thrd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by deepanshu.saxena on 19/02/16.
 */
public class MyCallable implements Callable<String> {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<String> callable = new MyCallable();
        List<Future<String>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(callable);
            futureList.add(future);
        }

        for (Future<String> future : futureList) {
            try {
                System.out.println("future before :: " + future.isDone());
                System.out.println(new Date() + "::" + future.get());
                System.out.println("future after :: " + future.isDone());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}
