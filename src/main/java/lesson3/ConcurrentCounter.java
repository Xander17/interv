package lesson3;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentCounter {

    @SneakyThrows
    public static void main(String[] args) {
        int threadsCount = 100;
        int countPerThread = 1000000;
        CountDownLatch countDownLatch = new CountDownLatch(threadsCount);
        ConcurrentCounter concurrentCounter = new ConcurrentCounter(threadsCount, countPerThread, countDownLatch);
        countDownLatch.await();
        System.out.println(concurrentCounter.getCounter());
    }

    @Getter
    private final AtomicInteger counter = new AtomicInteger(0);

    public ConcurrentCounter(int threadsCount, int countPerThread, CountDownLatch countDownLatch) {
        for (int i = 0; i < threadsCount; i++) {
            new Thread(() -> {
                for (int j = 0; j < countPerThread; j++) {
                    counter.incrementAndGet();
                }
                countDownLatch.countDown();
            }).start();
        }
    }
}
