package irctcSoftware;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SoftwareIrctc {
	public static void main(String[] args) {
		Train train1 = new Train("Rajdhani Mumbai to Mehsana", 9);
		Train train2 = new Train("Sabarmati Superfast", 8);

		PassangerThread p1 = new PassangerThread(train1, "Neha", 4);
		PassangerThread p = new PassangerThread(train1, "Chirayu", 6);
		PassangerThread p2 = new PassangerThread(train2, "Kaju", 7);
		PassangerThread p4 = new PassangerThread(train2, "MISRi", 1);

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		executorService.submit(p1);
		executorService.submit(p);
		executorService.submit(p2);
		executorService.submit(p4);

		executorService.shutdown();
		try {
			executorService.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("All booking requests submitted.");
	}
}