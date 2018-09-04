package com.concurrent;
/**
 * 并行一定比串行快吗？ 不一定，因为：因为线程有创建和上下文切换的开销
 * @author Json
 * 
 * 个人电脑测试情况如下：
 * 
 * 次数                         串                        并
 *1000        0ms      1ms
 *10000       0ms      1ms
 *100000      2ms      2ms
 *1000000     5ms      6ms
 *10000000    50ms     39ms
 *100000000   601ms    333ms
 */
public class ConcurrencyTest {
	private static final long COUNT = 10000L;

	public static void main(String[] args) throws InterruptedException {
		concurrency();
		serial();
	}

	private static void concurrency() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				int a = 0;
				for (long i = 0; i < COUNT; i++) {
					a += 5;
				}
			}
		});
		thread.start();
		int b = 0;
		for (long i = 0; i < COUNT; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		thread.join();
		System.out.println("concurrency : " + time + "ms, b=" + b);
	}

	private static void serial() {
		long start = System.currentTimeMillis();
		int a = 0;
		for (long i = 0; i < COUNT; i++) {
			a += 5;
		}
		int b = 0;
		for (long i = 0; i < COUNT; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("serial: " + time + "ms, b=" + b + ", a=" + a);
	}
}