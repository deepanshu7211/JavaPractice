package thrd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by deepanshu.saxena on 09/04/16.
 */
public class TestCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<String> myTestCallable = new MyTestCallable();
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Future<String> future = executorService.submit(myTestCallable);
            futureList.add(future);
        }

        for (Future<String> future : futureList) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

    }
}


class MyTestCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}