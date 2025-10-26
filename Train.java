package irctcSoftware;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Train {
	private String nameOfTrain;
	private int avalibleSeats;
	public final Lock lock = new ReentrantLock();

	public Train(String nameOfTrain, int avalibleSeats) {
		this.nameOfTrain = nameOfTrain;
		this.avalibleSeats = avalibleSeats;
	}

	public void bookingSeats(String passangerName, int numberOfSeats) {
		System.out.println(passangerName + " trying to book " + numberOfSeats + " seats...");

		if (lock.tryLock()) {
			try {
				if (avalibleSeats >= numberOfSeats) {
					System.out.println(passangerName + " is processing to book ticket in " + nameOfTrain + "\n");
					System.out.println("have pacetion IRCTC loading Data.....\n");
					Thread.sleep(5000);
					avalibleSeats -= numberOfSeats;
					System.out.println(Thread.currentThread().getName() + " sucessfully booked " + numberOfSeats
							+ " ticket in " + nameOfTrain);
					System.out.println(" ");
					System.out.println("Avalible seats in " + nameOfTrain + " : " + avalibleSeats);
				} else {
					throw new NotenoughseatsInItrain(
							"Not enough Seats for " + passangerName + "can't book your ticket. ");
				}
			} catch (NotenoughseatsInItrain e) {
				System.out.println(e.getMessage());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		} else {
			System.out.println("Train system busy for " + passangerName + ", please try again later.");
		}
		System.out.println("--------------------------------");
	}
}
