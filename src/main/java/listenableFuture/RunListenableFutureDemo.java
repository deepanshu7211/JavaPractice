package listenableFuture;

/**
 * Created by deepanshu.saxena on 05/03/16.
 */

import com.google.common.util.concurrent.*;
import org.joda.time.LocalTime;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;


public class RunListenableFutureDemo {
    public static void main(String args[]) {
        System.out.println(LocalTime.now() + " Hello future!");

//        final ListenableFutureDemo demo = new ListenableFutureDemo();

        //create executor service to submit all future tasks
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        //execute non-blocking task
        ListenableFuture<String> listenableFuture = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });

        //add success and failure handler to listenableFuture object
        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(LocalTime.now() + " Task completed successfuly with result: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(LocalTime.now() + " Task failed with result: " + t.getMessage());
            }
        });

        System.out.println(LocalTime.now() + " Main method completed but the result is still being calculated...");
        service.shutdown();
//        System.exit(0);
    }
}
