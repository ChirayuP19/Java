package irctcSoftware;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(() -> 80);
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {

			e.printStackTrace();
		}
		executorService.shutdown();
	}

}
