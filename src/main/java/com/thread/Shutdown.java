package com.thread;

import java.util.concurrent.TimeUnit;
/**
 * 安全的Shutdown线程
 * 示例在执行过程中， main线程通过中断操作和cancel()方法均可使CountThread得以终止。
这种通过标识位或者中断操作的方式能够使线程在终止时有机会去清理资源， 而不是武断地
将线程停止， 因此这种终止线程的做法显得更加安全和优雅。
 * @author Json
 *
 */
public class Shutdown {
	public static void main(String[] args) throws Exception {
		Runner one = new Runner();
		Thread countThread = new Thread(one, "CountThread");
		countThread.start();
		// 睡眠1秒， main线程对CountThread进行中断， 使CountThread能够感知中断而结束
		TimeUnit.SECONDS.sleep(1);
		countThread.interrupt();
		Runner two = new Runner();
		countThread = new Thread(two, "CountThread");
		countThread.start();
		// 睡眠1秒， main线程对Runner two进行取消， 使CountThread能够感知on为false而结束
		TimeUnit.SECONDS.sleep(4);
		two.cancel();  
	}

	private static class Runner implements Runnable {
		
		private long i;
		/**
		 * 关键字volatile可以用来修饰字段（成员变量） ， 就是告知程序任何对该变量的访问均需要
			从共享内存中获取， 而对它的改变必须同步刷新回共享内存， 它能保证所有线程对变量访问
			的可见性
		 */
		private volatile boolean on = true;

		@Override
		public void run() {
			while (on && !Thread.currentThread().isInterrupted()) {
				i++;
			}
			System.out.println("Count i = " + i);
		}

		public void cancel() {
			on = false;
		}
	}
}
