package test.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 * 假若一个工厂有5台机器，但是有8个工人，一台机器同时只能被一个工人使用，只有使用完了，其他工人才能继续使用
 * @author Json
 * 
 * Semaphore可以用于做流量控制， 特别是公用资源有限的应用场景， 比如数据库连接。 
 * 
 * 总结：

1）CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：

CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；

而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；

另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。

2）Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。
 * 
 *
 */
public class SemaphoreTest {
	
	public static void main(String[] args) {
		int N = 8; //工人数
		int machine = 5; //机器数
		Semaphore semaphore = new Semaphore(machine);
		for (int i = 0; i < N; i++) {
			new Worker(i,semaphore).start();
		}
	}

}
class Worker extends Thread{
	
	private int i;

	private Semaphore semaphore;
	
	public Worker(int i,Semaphore semaphore){
		this.i = i;
		this.semaphore = semaphore;
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println("工人"+i+"占用一个机器在生产");
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		semaphore.release();
		System.out.println("工人"+i+"释放出机器");
	}
	
}