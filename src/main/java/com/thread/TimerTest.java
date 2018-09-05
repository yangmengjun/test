package com.thread;

import java.util.Collection;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class TimerTest {
	public static void excuteATask(final long time){
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("5s后当前时间："+new Date().toGMTString());
				excuteATask(time);
			}
		}, time);
	}
	public static void main(String[] args) {
		excuteATask(2000);
	}
	
	public static void printCollection(Collection<?> c){
		for(Object obj : c){
			System.out.println(obj);
		}
		System.out.println(c.size());
		
		//c = new Vector<Integer>(); 可以编译通过而已
	}
	//向上限定符，向下限定符
	public static void t(){
		Vector<? extends Object> v = new Vector<String>();
		Vector<? extends Number> v1 = new Vector<Integer>();
		//Vector<? extends Integer> v = new Vector<Number>();错误
		//Vector<? super Object> v = new Vector<String>();错误
		Vector<? super Float> v4 = new Vector<Number>();
		
	}

	public static void main1(String[] args) {
		Timer t = new Timer();  
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("5s后当前时间："+new Date().toGMTString());
			}
		};
		//	t.schedule(task, 1000,2000); //调度，每隔2s执行一次
		//	t.schedule(task, 1000); //调度,执行一次
		//	
			//如果想灵活的执行间隔，如：2s执行 3s执行  2s执行 	，可以在定时器里面加定时器
		class MyTimerTask extends TimerTask{
			private long time;
			public MyTimerTask(long time){
				this.time = time;
			}
			@Override
			public void run() {
				new Timer().schedule(new TimerTask() {
					
					@Override
					public void run() {
						new Timer().schedule(new MyTimerTask(time), time);
						System.out.println("5s后当前时间："+new Date().toGMTString());
					}
				}, time);
				
			}
		} 
	//	TimerTask t1 = new MyTimerTask();
		
	}
}
