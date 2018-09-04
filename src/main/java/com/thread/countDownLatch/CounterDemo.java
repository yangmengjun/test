package com.thread.countDownLatch;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 文章出处：http://www.importnew.com/26035.html
 * @author Json
 *
 */
public class CounterDemo {

	private final Map<String,Long> urlCounter = new ConcurrentHashMap<String, Long>();
	
	//接口调用次数+1
	public long increse(String url){
		Long oldValue = urlCounter.get(url);
		Long newValue = oldValue==null?1L:oldValue+1;
		urlCounter.put(url, newValue);
		return newValue;
	}
	
	public long increseCAS(String url){
		Long oldValue,newValue;
		while(true){
			oldValue = urlCounter.get(url);
			if(oldValue==null){
				newValue = 1L;
				if(urlCounter.putIfAbsent(url, newValue)==null){
					break;
				}
			}else{
				newValue = oldValue + 1;
				/**
				 * 这其实就是一个最典型的CAS操作，except that the action is performed atomically.
				 * 这句话真是帮了大忙，我们可以保证比较和设置是一个原子操作，当A线程尝试在increase时，
				 * 旧值被修改的话就回导致replace失效，而我们只需要用一个循环，不断获取最新值，
				 * 直到成功replace一次，即可完成统计。
				 */
				if(urlCounter.replace(url, oldValue, newValue)){
					break;
				}
			}
		}
		return newValue;
	}
	
	 //获取调用次数
	public long getCount(String url){
		return urlCounter.get(url);
	}
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		final CounterDemo demo = new CounterDemo();
		int callTime = 10000;
		final String url = "http://localhost:8080/hello";
		final CountDownLatch countdownlatch = new CountDownLatch(callTime);
		for (int i = 0; i < callTime; i++) {
			final int j = i;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(j);
					demo.increseCAS(url); //打印的调用次数不会少 10000  10000
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
        System.out.println("调用次数："+demo.getCount(url));
	}
}
