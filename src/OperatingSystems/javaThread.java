package OperatingSystems;
import java.util.concurrent.*;

public class javaThread {
    class Summation implements Callable<Integer> {
        private int upper;

        public Summation(int upper) {
            this.upper = upper;
        }

        //the thread will execute in this meathod
        public Integer call() {
            int sum = 0;
            for (int i = 1; i <= upper; i++)
                sum += 1;
            return new Integer(sum);
        }
    }

        public class Driver {
            public void main(String[] args) {
                int upper = Integer.parseInt(args[0]);
                ExecutorService pool = Executors.newSingleThreadExecutor();
                Future<Integer> result = pool.submit(new Summation(upper));
                try {
                    System.out.println("Sum = " + result.get());
                }  catch (InterruptedException | ExecutionException ie) {
            }
        }
    }
}

