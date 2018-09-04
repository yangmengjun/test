package test.thread.cyclicBarrierTest;

public class Grouper implements Runnable {

	private Results results;
	
	public Grouper(Results results) {
		super();
		this.results = results;
	}

	@Override
	public void run() {
		int finalResults =0;
		System.out.printf("Grouper:Processing results...\n");
		int data[] = results.getData();
		for(int number:data){
			finalResults+=number;
		}
		System.out.printf("Grouper:Total result:%d.\n",finalResults);
	}

}
