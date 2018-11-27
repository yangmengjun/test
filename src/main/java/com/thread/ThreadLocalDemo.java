package com.thread;

/**
 * ThreadLocal
 * ThreadLocal确实是可以达到线程隔离机制，确保变量的安全性
 * @author: yangmengjun
 * @date: 2018\11\27 14:41
 */
public class ThreadLocalDemo {
    private ThreadLocal<Integer> seqCount = new ThreadLocal<Integer>(){
        @Override
        public Integer initialValue(){
            return  0;
        }
    };
    public Integer getNextSeq(){
        seqCount.set(seqCount.get()+1);
        return seqCount.get();
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        MyThread t1 = new MyThread(demo);
        MyThread t2 = new MyThread(demo);
        MyThread t3= new MyThread(demo);
        MyThread t4 = new MyThread(demo);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        /**
         * 打印结果如下：
         * Thread-0 seqCount:1
         Thread-0 seqCount:2
         Thread-0 seqCount:3
         Thread-3 seqCount:1
         Thread-3 seqCount:2
         Thread-3 seqCount:3
         Thread-1 seqCount:1
         Thread-1 seqCount:2
         Thread-1 seqCount:3
         Thread-2 seqCount:1
         Thread-2 seqCount:2
         Thread-2 seqCount:3
         不同线程之间相互不干扰
         */
    }
}
class MyThread extends Thread{
    ThreadLocalDemo threadLocalDemo;
    public MyThread(ThreadLocalDemo threadLocalDemo){
        this.threadLocalDemo = threadLocalDemo;
    }

    @Override
    public void run(){
        for (int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+" seqCount:"+threadLocalDemo.getNextSeq());
        }
    }
}
