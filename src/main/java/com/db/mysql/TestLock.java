package com.db.mysql;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yangmengjun
 * @date: 2019\1\21 0021 18:25
 */
public class TestLock {
    public static void main(String[] args) throws InterruptedException {
        final int THREAD_NUMBER = 10;
        final int EXCUTE_TIME = 100;
        ExecutorService service = Executors.newFixedThreadPool(THREAD_NUMBER);

        CountDownLatch countDownLatch = new CountDownLatch(EXCUTE_TIME);
        for(int i=0;i<EXCUTE_TIME;i++){
            service.execute(new MySqlLockCountDownDemo(countDownLatch));
        }
        service.shutdown();
        countDownLatch.await();
        System.out.println("FINISHED");
    }
}
