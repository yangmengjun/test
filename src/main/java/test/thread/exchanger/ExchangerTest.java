package test.thread.exchanger;

import java.util.concurrent.Exchanger;

/**
 * 线程之间交换数据
 * 
 * 在两个线程之间传输数据，Exchanger中的public V exchange(Vx)
 * 方法被调用后等待另一个线程到达交换点（如果当前线程没有被中断），然后将已知的对象传给它，返回接收的对象。
 * 
 */
public class ExchangerTest {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		ThreadA ta = new ThreadA(exchanger);
		ThreadB tb = new ThreadB(exchanger);
		ta.start();
		tb.start();
		/**
		 将会打印：
		 ThreadA:BBBBB
		 ThreadB:AAAAA
		 */
	}
}

class ThreadA extends Thread {
	private Exchanger<String> exchanger;

	public ThreadA(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			System.out.println("ThreadA:" + exchanger.exchange("AAAAA"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadB extends Thread {
	private Exchanger<String> exchanger;

	public ThreadB(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			System.out.println("ThreadB:" + exchanger.exchange("BBBBB"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}