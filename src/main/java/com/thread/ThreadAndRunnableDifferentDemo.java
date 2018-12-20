package com.thread;

import org.junit.Test;

/**
 * @author: yangmengjun
 * @date: 2018\12\20 0020 16:27
 */
public class ThreadAndRunnableDifferentDemo {
    public static void main(String[] args) {
        //正常打印，线程隔离运行
        MineThread t1 = new MineThread();
        MineThread t2 = new MineThread();

        t1.start();
        t2.start();

    }

    @Test
    public void test2(){
        //会发生线程安全问题，number数据被共享了
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }
}



class MineThread extends Thread{

    private int number = 100;

    @Override
    public void run() {
        for (int i=0;i<50;i++){
            number--;
            System.out.println(Thread.currentThread().getName()+":  "+number);
        }
    }
}

class MyRunnable implements Runnable{

    private int number = 100;

    @Override
    public synchronized void run() {
        for (int i=0;i<50;i++){
            number--;
            System.out.println(Thread.currentThread().getName()+":  "+number);
        }
    }
}