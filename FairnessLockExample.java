package irctcSoftware;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {
	private final Lock lock = new ReentrantLock(true);

	public void accessResource() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "Aquried the lock");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			System.out.println(Thread.currentThread().getName() + "released the lock ");
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		FairnessLockExample fr = new FairnessLockExample();

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				fr.accessResource();
			}
		};
		Thread thread1 = new Thread(runnable, "I am thread 1 ");
		Thread thread2 = new Thread(runnable, "I am thread 2 ");
		Thread thread3 = new Thread(runnable, "I am thread 3 ");

		thread1.start();
		thread2.start();
		thread3.start();
	}

}
