package irctcSoftware;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class LamdaExpression {
	public static void main(String[] args) {
		// create a thread pool with 3 thread....

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 1; i <= 10; i++) {
			int finalI = i;

			Future<?> future = executorService.submit(() -> {
				System.out.println(Thread.currentThread().getName() + "is executing task " + finalI);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				System.out.println("Task " + finalI + " completed by " + Thread.currentThread().getName());
			});
		}
		executorService.shutdown();
		try {
			executorService.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("All Task submitted ");
	}
}
