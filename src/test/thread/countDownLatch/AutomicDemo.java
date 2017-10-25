package test.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.AtomicLongMap;
/**
 * 原子操作的技术map
 * @author Json
 *
 */
public class AutomicDemo {

	private AtomicLongMap<String> urlCounter3 = AtomicLongMap.create();
	 
	public long increase3(String url) {
	    long newValue = urlCounter3.incrementAndGet(url);
	    return newValue;
	}
	 
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		final AutomicDemo demo = new AutomicDemo();
		int callTime = 100000;
		final String url = "http://localhost:8080/hello";
		final CountDownLatch countdownlatch = new CountDownLatch(callTime);
		for (int i = 0; i < callTime; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					demo.increase3(url); //打印的调用次数不会少 10000  10000
//					demo.increse(url); //打印的次数会变少，被覆盖了10000  9988
					countdownlatch.countDown();
				}
			});
		}
		
		try {
			countdownlatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		//等待所有线程统计完成后输出调用次数
        System.out.println("调用次数："+demo.getCount3(url)); //100000
	}
	 
	public Long getCount3(String url) {
	    return urlCounter3.get(url);
	}
}
