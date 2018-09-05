package com.concurrent;

/**
 * 弱的同步机制，即volatile变量
 * @author Json
 *
 */
public class VolatileTest {
	
	private volatile int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private void printNumber(){
		System.out.println(number);
	}
	
	public static void main(String[] args) {
		final VolatileTest v = new VolatileTest();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Thread.currentThread().sleep(1000);
						v.printNumber();
						System.out.println("监视");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Thread.currentThread().sleep(1000);
						v.setNumber(i);
						System.out.println("设置");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
