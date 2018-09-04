package test.thread;

import java.util.concurrent.TimeUnit;

/**
 * 如果一个线程A执行了thread.join()语句， 其含义是： 当前线程A等待thread线程终止之后才
从thread.join()返回。 线程Thread除了提供join()方法之外， 还提供了join(long millis)和join(long
millis,int nanos)两个具备超时特性的方法。 这两个超时方法表示， 如果线程thread在给定的超时
时间里没有终止， 那么将会从该超时方法中返回。
<br/>
当线程终止时， 会调用线程自 身的notifyAll()方法， 会通知所有等待在该线程对象上的线
程。 可以看到join()方法的逻辑结构与4.3.3节中描述的等待/通知经典范式一致， 即加锁、 循环
和处理逻辑3个步骤
 * @author Json
 *
 */
public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {
		Thread previous = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			// 每个线程拥有前一个线程的引用， 需要等待前一个线程终止， 才能从等待中返回
			Thread t = new Thread(new Domino(previous),String.valueOf(i));
			t.start();
			previous = t;
		}
		TimeUnit.SECONDS.sleep(5);
		System.out.println(Thread.currentThread().getName() + " terminate. ") ;
	}
	
	static class Domino implements Runnable{
		
		private Thread previous;
		
		public Domino(Thread previous){
			this.previous = previous;
		}
		
		@Override
		public void run() {
			try {
				previous.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("The Current Thread:"+Thread.currentThread().getName()+" terminated.");
		}
		
	}

}
