package listenableFuture;

import com.google.common.util.concurrent.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by deepanshu.saxena on 08/02/16.
 */
public class Bomb {
    private String bomb;
    private int count;

    public Bomb() {
    }

    public Bomb(String count) {
        this.bomb = count;
    }

    public static void main(String[] args) {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        List<ListenableFuture<Bomb>> bombs = new ArrayList<ListenableFuture<Bomb>>();
        for (int i = 0; i < 10; i++) {
            ListenableFuture<Bomb> bomb = service.submit(new Callable<Bomb>() {
                public Bomb call() throws Problem {
                    return craftBomb(Thread.currentThread().getName());
                }
            });
            bombs.add(bomb);
        }
        ListenableFuture<List<Bomb>> successfulBombs = Futures.successfulAsList(bombs);
        Futures.addCallback(successfulBombs, new FutureCallback<List<Bomb>>() {
            public void onSuccess(List<Bomb> bombs) {
                System.out.println("My successful bombs");
                for (Bomb b : bombs) {
                    System.out.println(b);
                }
            }

            public void onFailure(Throwable thrown) {
                System.err.println("There was a problem making this bomb.");
            }
        });
    }

    private static Bomb craftBomb(String name) {
        return new Bomb(name);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBomb() {
        return bomb;
    }

    public void setBomb(String bomb) {
        this.bomb = bomb;
    }
}
