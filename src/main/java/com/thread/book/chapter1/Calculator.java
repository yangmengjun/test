package com.thread.book.chapter1;

import java.io.File;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Calculator implements Runnable {
	int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Calculator(int number){
		this.number = number;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s:%d*%d=%d\n",Thread.currentThread().getName(),i,number,i*number);
		}

	}
	public static void test1_1(){
		Thread.currentThread().getState();
		for (int i = 0; i < 10; i++) {
			Calculator c = new Calculator(5);
			new Thread(c).start();//调用到这里才会有另外的执行线程被创建
		}
	}

	public static void main(String[] args) {
		test1_2();
	}

	private static void test1_2() {
		Thread[] threads = new Thread[10];
		Thread.State[] states = new Thread.State[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator(i));
			if(i%2==0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else{
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread"+i);
		}
		try(PrintWriter pw = new PrintWriter(new File("t.txt"))) {
			for (int i = 0; i < states.length; i++) {
				pw.println("Main:state of Thread"+i+":"+threads[i].getState());
				states[i] = threads[i].getState();
			}
			for (int i = 0; i < 10; i++) {
				threads[i].start();
			}
			boolean finish = false;
			while(!finish){
				for (int i = 0; i < 10; i++) {
					if(states[i]!=threads[i].getState()){
						writeThreadInfo(pw,threads[i],states[i]);
						states[i] = threads[i].getState();
					}
				}
			}
			finish  =true;
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private static void writeThreadInfo(PrintWriter pw, Thread thread,
			State state) {
		pw.printf("Main: Id %d -%s\n", thread.getId(),thread.getName());
		pw.printf("Priority:  %d \n", thread.getId(),thread.getPriority());
		pw.printf("Old State: %s \n", thread.getId(),state);
		pw.printf("New State:  %s \n", thread.getId(),thread.getState());
		pw.printf("Main: ****************************************\n");
		
	}

}
