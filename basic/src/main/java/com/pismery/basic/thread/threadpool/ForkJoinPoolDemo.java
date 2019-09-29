package com.pismery.basic.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.*;

@Slf4j
public class ForkJoinPoolDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        runIncrementTask();
        runSumTask();
    }

    private static void runSumTask() throws InterruptedException, ExecutionException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int size = 10;
        int sum = 0;
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
            sum += i;
        }

        ForkJoinTask<Integer> task = forkJoinPool.submit(new SumArrayTask(array));
        log.debug("Array result:" + sum + ";compute result:" + task.get());
    }

    private static void runIncrementTask() throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int size = 10;
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        log.debug("Before:"+ Arrays.toString(array));
        forkJoinPool.execute(new IncrementTask(array, 0, size));

        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
        log.debug("After:"+Arrays.toString(array));
    }

    @Slf4j
    static class IncrementTask extends RecursiveAction {
        private static final int THRESHOLD = 2;
        private final long[] array;
        private final int low, high;

        public IncrementTask(long[] array, int low, int high) {
            this.array = array;
            this.low = low;
            this.high = high;
        }

        public IncrementTask(long[] array) {
            this(array, 0, array.length);
        }

        @Override
        protected void compute() {
            if (high - low < THRESHOLD) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = low; i < high; i++)
                    log.debug(Thread.currentThread().getName() + ":" + array[i]++);
            } else {
                int mid = low + (high - low) / 2;
                IncrementTask left = new IncrementTask(array, low, mid);
                IncrementTask right = new IncrementTask(array, mid, high);

                log.debug(Thread.currentThread().getName() + ": fork task...");
                invokeAll(left, right);
            }
        }
    }



    static class SumArrayTask extends RecursiveTask<Integer> {
        private final static int THRESHOLD = 5;
        private final long[] array;
        private final int low, high;

        public SumArrayTask(long[] array, int low, int high) {
            this.array = array;
            this.low = low;
            this.high = high;
        }

        public SumArrayTask(long[] array) {
            this(array, 0, array.length);
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            if (high - low < THRESHOLD) {
                for (int i = low; i < high; i++) {
                    sum += array[i];
                }
                log.debug("{}: sub task[{},{}] result - {}", Thread.currentThread().getName(), low, high, sum);
                return sum;
            }

            int mid = low + (high - low) / 2;

            SumArrayTask left = new SumArrayTask(array, low, mid);
            SumArrayTask right = new SumArrayTask(array, mid, high);
            //option 1
//            left.fork();
//            right.fork();
//            sum = left.join() + right.join();
            //option 2
//            invokeAll(left,right);
//            sum = left.join() + right.join();
            //option 3
            sum = left.invoke() + right.invoke();

            log.debug("{}: Join task result - {}" , Thread.currentThread().getName(), sum);

            return sum;
        }
    }
}
