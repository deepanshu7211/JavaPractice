package thread.paralel;

import java.util.concurrent.Callable;

/**
 * Created by desaxena on 10/21/2016.
 */
public class SubTask2_1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Subtask2_1" + "Thread Name  " + Thread.currentThread().getName();
    }
}