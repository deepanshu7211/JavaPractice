package thrd;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by desaxena on 10/20/2016.
 */
public class JoinForkMain {
    public static void main(String[] args) {
        ProductListGenerator productListGenerator = new ProductListGenerator();
        List<Product> products = productListGenerator.generate(100);
        Task task = new Task(products,0 , products.size(),0.20);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(task);

        do {
            System.out.println("Main Thread Count %d \n" + forkJoinPool.getActiveThreadCount());
            System.out.println("Main Thread Steal %d \n" + forkJoinPool.getStealCount());
            System.out.println("Main Parallelism %d \n" + forkJoinPool.getParallelism());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }while (!task.isDone());


        forkJoinPool.shutdown();

        if(task.isCompletedNormally())
        {
            System.out.println(" Main : The Process has completed normally...");
        }

        for(Product product : products)
        {
            if(product.getPrice()==12)
            {
                System.out.println("Product Info :: " + product.getName() + " Price :: " + product.getPrice());
            }
        }

        System.out.println("Main : End of the program... ");
    }
}
