package com.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * 等待/通知 机制
 * @author Json
 * 
WaitThread首先获取了对象的锁， 然后调用对象的wait()方法， 从而放弃了锁
并进入了对象的等待队列WaitQueue中， 进入等待状态。 由于WaitThread释放了对象的锁，
NotifyThread随后获取了对象的锁， 并调用对象的notify()方法， 将WaitThread从WaitQueue移到
SynchronizedQueue中， 此时WaitThread的状态变为阻塞状态。 NotifyThread释放了锁之后，
WaitThread再次获取到锁并从wait()方法返回继续执行。
 * 
 * 打印如下：
Thread[WaitThread,5,main] flag is true. wait@ 15: 54: 25
Thread[NotifyThread,5,main] hold lock. notify @ 15: 54: 26
Thread[NotifyThread,5,main] hold lock again. sleep15: 54: 31
Thread[WaitThread,5,main] flag is false. running@ 15: 54: 36

 *
 */
public class WaitNotifyTest {
	static boolean flag = true;
	static Object lock = new Object();

	public static void main(String[] args) throws Exception {
		Thread waitThread = new Thread(new Wait(), "WaitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(1);
		Thread notifyThread = new Thread(new Notify(), "NotifyThread");
		notifyThread.start();
	}

	static class Wait implements Runnable {
		public void run() {
			// 加锁， 拥有lock的Monitor
			synchronized (lock) {
				// 当条件不满足时， 继续wait， 同时释放了lock的锁
				while (flag) {
					try {
						System.out.println(Thread.currentThread()+ " flag is true. wait@ "
							+ new SimpleDateFormat("HH: mm: ss").format(new Date()));
						lock.wait();
					} catch (InterruptedException e) {
					}
				}// 条件满足时， 完成工作
				System.out.println(Thread.currentThread()+ " flag is false. running@ "
					+ new SimpleDateFormat("HH: mm: ss").format(new Date()));
			}
		}
	}

	static class Notify implements Runnable {
		public void run() {
			// 加锁， 拥有lock的Monitor
			synchronized (lock) {
				// 获取lock的锁， 然后进行通知， 通知时不会释放lock的锁，
				// 直到当前线程释放了lock后， WaitThread才能从wait方法中返回
				System.out.println(Thread.currentThread()+ " hold lock. notify @ "
					+ new SimpleDateFormat("HH: mm: ss").format(new Date()));
				lock.notifyAll();
				flag = false;
				SleepUtils.second(5);
			}
			// 再次加锁
			synchronized (lock) {
				System.out.println(Thread.currentThread()+ " hold lock again. sleep@"
					+ new SimpleDateFormat("HH: mm: ss").format(new Date()));
				SleepUtils.second(5);
			}
		}
	}
}
