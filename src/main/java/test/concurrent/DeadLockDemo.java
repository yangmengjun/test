package test.concurrent;

/**
 * 死锁
 *  锁是个非常有用的工具， 运用场景非常多， 因为它使用起来非常简单， 而且易于理解。 但
同时它也会带来一些困扰， 那就是可能会引起死锁， 一旦产生死锁， 就会造成系统功能不可
用。 让我们先来看一段代码， 这段代码会引起死锁， 使线程t1和线程t2互相等待对方释放锁
 *
 */
public class DeadLockDemo {
	private static String A = "A";
	private static String B = "B";

	public static void main(String[] args) {
		new DeadLockDemo().deadLock();
	}

	private void deadLock() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (A) {
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (B) {
						System.out.println("1");
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (B) {
					synchronized (A) {
						System.out.println("2");
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
}