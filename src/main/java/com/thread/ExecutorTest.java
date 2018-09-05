package com.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
	
	public static void callabletest() throws InterruptedException, ExecutionException{
		Date date1 = new Date();  
		int taskSize = 5;
		//1.创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize); 
		//2.创建有多个返回值的任务
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < taskSize; i++) {
			Callable call = new MyCallable(i+"");//自定义MyCallable类，实现了Callable接口
			//3.执行并获取future对象
			Future future = pool.submit(call);
			list.add(future);
		}
		pool.shutdown();
		for(Future f:list){//循环所有的Future，全部拿到其结果才算是真正的结束
			System.out.println(f.get().toString());
		}
		Date date2 = new Date();  
		   System.out.println("----程序结束运行----，程序运行时间【"  
		     + (date2.getTime() - date1.getTime()) + "毫秒】");  
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		t();
	}
	
	public static void t() throws InterruptedException, ExecutionException{
		int poolSize = 10;
		long begin = System.currentTimeMillis();
		ExecutorService pool = Executors.newFixedThreadPool(poolSize);
		List<Future> results = new ArrayList<Future>();
		for (int i = 0; i < poolSize; i++) {
			Callable<String> call = new MyCallable("第"+(i+1)+"线程");
			results.add(pool.submit(call));
		}
		pool.shutdown();
		for(Future f : results){ //循环所有的Future，全部拿到其结果才算是真正的结束
			System.out.println(f.get().toString());
		}
		long end = System.currentTimeMillis();
		System.out.println("总耗时："+(end-begin));
	}

}
class MyCallable implements Callable{
	
	private String name;
	
	public MyCallable(String name){
		this.name = name;
	}

	public Object call() throws Exception {
		System.out.println(">>>" + name + "任务启动");  
		   Date dateTmp1 = new Date();  
		   Thread.sleep(1000);  
		   Date dateTmp2 = new Date();  
		   long time = dateTmp2.getTime() - dateTmp1.getTime();  
		   System.out.println(">>>" + name + "任务终止");  
		   return name + "任务返回运行结果,当前任务时间【" + time + "毫秒】"; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}