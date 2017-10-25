package test.thread;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

/**
 * 
 * @author Json
 * @since 1.0.0
 * <code class="hljs" cs="">public enum State {
    //线程刚创建
    NEW,
 
    //在JVM中正在运行的线程
    RUNNABLE,
 
    //线程处于阻塞状态，等待监视锁，可以重新进行同步代码块中执行
    BLOCKED,
 
    //等待状态
    WAITING,
 
    //调用sleep() join() wait()方法可能导致线程处于等待状态
    TIMED_WAITING,
 
    //线程执行完毕，已经退出
    TERMINATED;
}</code>
 */
public class BaseTest {
	public static void main(String[] args) {
		test();
	}
	public static void main1(){
		Thread[] t = new Thread[10];
		Thread.State status[] = new Thread.State[10];
		PrintWriter pw = null;
		for (int i = 0; i < 10; i++) {
			t[i] = new Calculator(i);
			status[i] = t[i].getState();
			t[i].setName("My Calculator"+i);
			if(i%2==0){
				t[i].setPriority(Thread.MAX_PRIORITY);
			}else{
				t[i].setPriority(Thread.MIN_PRIORITY);
			}
		}
		try {
			pw = new PrintWriter(new FileWriter("d:/thread.txt"));
			for (int i = 0; i < 10; i++) {
				t[i].start();
				status[i] = t[i].getState();
				pw.write("my status is:"+status[i]);
			}
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			pw.close();
		}
		
		boolean finish = false;
		while(finish){
			for (int i = 0; i < 10; i++) {
				if(t[i].getState()!=status[i]){
					wtiteThreadInfo(pw,t[i],status[i]);
					status[i] = t[i].getState();
				}
			}
		}
		Thread.State[] sixstates = new Thread.State[]{State.NEW,State.WAITING,
				State.RUNNABLE,State.BLOCKED,State.TIMED_WAITING,State.TERMINATED};
		
	}

	private static void wtiteThreadInfo(PrintWriter pw, Thread thread,
			State state) {
		// TODO Auto-generated method stub
		
	}
	
	public static void test(){
		new Thread(new Runnable() {
			
			public void run() {
				System.out.println("runnable run");
			}
		}){
			@Override
			public void run() {
				System.out.println("thread run");
			}
		}.start();
	}
}
class Calculator extends Thread{
	private int count;
	public Calculator(int count){
		this.count = count;
	}
	
	@Override
	public void run(){
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s : %d * %d = %d,my status is:%s",Thread.currentThread().getName(),i,count,i*count,Thread.currentThread().getState());
		}
	}
	
}