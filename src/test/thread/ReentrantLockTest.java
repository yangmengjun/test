package test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	
	private Lock lock = new ReentrantLock();// 锁对象
	
	public void test(String name){
		lock.lock();      // 得到锁 
		try {    
            for(int i = 0; i < name.length(); i++) {    
                System.out.print(name.charAt(i));    
            }    
        } finally {    
            lock.unlock();// 释放锁    
        }    
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				new ReentrantLockTest().test("yang");
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				new ReentrantLockTest().test("meng");
			}
		}).start();
	}

}
