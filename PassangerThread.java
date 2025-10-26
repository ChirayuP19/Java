package irctcSoftware;

public class PassangerThread extends Thread {
	public Train train;
	public String passangerName;
	public int seatsTobook;

	public PassangerThread(Train train, String passangerName, int seatsTobook) {
		this.train = train;
		this.passangerName = passangerName;
		this.seatsTobook = seatsTobook;
	}

	@Override
	public void run() {
		train.bookingSeats(passangerName, seatsTobook);
	}
}
