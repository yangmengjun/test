package com.thread.cyclicBarrierTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier测试，所有的线程写完之后在执行其他操作
 * @author Json
 *
 */
public class WritterTest {
	public static void main(String[] args) {
		int barrierSize = 10;
		CyclicBarrier barrier = new CyclicBarrier(barrierSize);
		for (int i = 0; i < barrierSize; i++) {
			new Writer(barrier,i).start();
		}
		
	}

}
class Writer extends Thread{
	
	private int i ;
	private CyclicBarrier barrier  ;
	
	public Writer(){
		
	}
	
	public Writer(CyclicBarrier barrier ,int i){
		this.barrier = barrier;
		this.i = i;
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		System.out.println("线程"+i+"开始执行");
		try {
			Thread.currentThread().sleep(1000);
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("线程"+i+"执行完成，继续其他操作....");
	}
	
}
