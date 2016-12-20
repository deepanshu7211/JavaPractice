package thrd.parallel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by desaxena on 10/21/2016.
 */
public class TaskUtility {

    public static <T>List<Future<? extends T>>  invokeAll(Collection<? extends Callable<? extends T>> tasks)
    {
        ExecutorService executor = Executors.newCachedThreadPool();

        List<Future<? extends T>> futures = new ArrayList<>();
        for (Callable<? extends T> callable : tasks) {
            futures.add(executor.submit(callable));
        }

        executor.shutdown();
        return futures;
    }
}
