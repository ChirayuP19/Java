import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HotelReservationSystem {

	private static final String url = "jdbc:mysql://localhost:3306/hotel_db";

	private static final String username = "root";

	private static final String password = "Chirayu@1911";

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			while (true) {
				System.out.println();
				System.out.println("PATEL MOTEL MANAGEMENT SYSTEM");
				Scanner scanner = new Scanner(System.in);
				System.out.println("1. Reserve a room");
				System.out.println("2. View Reservations");
				System.out.println("3. Get Room Number");
				System.out.println("4. Update Reservastions");
				System.out.println("5. Delete Revervations");
				System.out.println("0. Exit ");
				System.out.println("Choose an Option: ");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					reserveRoom(connection, scanner, statement);
					break;

				case 2:
					viewReservation(connection, statement);
					break;
				case 3:
					getRoomNumber(connection, scanner, statement);
					break;
				case 4:
					updateReservation(connection, scanner, statement);
					break;
				case 5:
					deleteReservation(connection, scanner, statement);
					break;
				case 0:
					exit();
					break;
				}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void reserveRoom(Connection connection, Scanner scanner, Statement stament) {
		try {
			System.out.println("Enter guest name: ");
			String guestName = scanner.next();
			scanner.nextLine();
			System.out.println("Enter room number: ");
			int roomNumber = scanner.nextInt();
			System.out.println("Enter contact number: ");
			String contactNumber = scanner.next();

			String sql = "INSERT INTO reservation (guest_name, room_number, contact_number) " + "VALUES ('" + guestName
					+ "', " + roomNumber + ", '" + contactNumber + "')";

			try {
				int affectedRows = stament.executeUpdate(sql);

				if (affectedRows > 0) {
					System.out.println("Reservation successful ! ");
				} else {
					System.out.println("Reservstion failed ❌ ");
				}
			} catch (SQLException e) {
				System.out.println("SQL Error: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} finally {

		}
	}

	private static void viewReservation(Connection connection, Statement stament) throws SQLException {
		String sql = "SELECT reservation_id, guest_name, room_number,contact_number,reservation_date FROM reservation ";
		try {
			// here we use result set Interface to store the table.
			ResultSet resultSet = stament.executeQuery(sql);

			System.out.println("Current Reservations: ");
			System.out.println(
					"+----------------+-----------------+---------------+----------------------+-------------------------+");
			System.out.println(
					"| Reservation ID | Guest           | Room Number   | Contact Number      | Reservation Date        |");
			System.out.println(
					"+----------------+-----------------+---------------+----------------------+-------------------------+");

			while (resultSet.next()) {

				int reservationId = resultSet.getInt("reservation_id");
				String guestName = resultSet.getString("guest_name");
				int roomNumber = resultSet.getInt("room_number");
				String contactNumber = resultSet.getString("contact_number");
				String reservationDate = resultSet.getTimestamp("reservation_date").toString();

				System.out.printf("| %-14d | %-15s | %-13d | %-20s | %-19s   |\n", reservationId, guestName, roomNumber,
						contactNumber, reservationDate);
			}
			System.out.println(
					"+----------------+-----------------+---------------+----------------------+-------------------------+");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void getRoomNumber(Connection connection, Scanner scanner, Statement statement) {
		try {
			System.out.print("Enter reservation ID: ");
			int reservationId = scanner.nextInt();
			System.out.print("Enter guest name: ");
			String guestName = scanner.next();

			String sql = "SELECT room_number FROM reservation " + "WHERE reservation_id = " + reservationId
					+ " AND guest_name = '" + guestName + "'";

			try {
				ResultSet resultSet = statement.executeQuery(sql);

				if (resultSet.next()) {
					int roomNumber = resultSet.getInt("room_number");
					System.out.println("Room number for Reservation ID " + reservationId + " and Guest " + guestName
							+ " is: " + roomNumber);
				} else {
					System.out.println("Reservation not found for the given ID and guest name.");
				}
			} finally {

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void updateReservation(Connection connection, Scanner scanner, Statement statement) {
		try {
			System.out.println("Please enter reservstion ID to update: ");
			int reservationID = scanner.nextInt();
			scanner.nextLine();

			if (!reservationExists(connection, reservationID, statement)) {
				System.out.println("Reservation not found for the given ID");
				return;
			}
			System.out.println("Enter new guest name ");
			String newGuestName = scanner.nextLine();
			System.out.println("Enter room number");
			int newRoomNuber = scanner.nextInt();
			System.out.println("Enter new contact number ");
			String newContactNumber = scanner.next();

			String sql = "UPDATE reservation SET guest_name = '" + newGuestName + "', " + "room_number = "
					+ newRoomNuber + ", " + "contact_number = '" + newContactNumber + "' " + "WHERE reservation_id = "
					+ reservationID;
			try {
				int affectedRows = statement.executeUpdate(sql);

				if (affectedRows > 0) {
					System.out.println("Reservation update Successfully! ");
				} else {
					System.out.println("Reservation update failed.");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		} catch (Exception e) {

		}

	}

	private static boolean reservationExists(Connection connection, int reservationID, Statement statement) {
		String sql = "SELECT reservation_id from reservation WHERE reservation_id= " + reservationID;
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			{
				return resultSet.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	private static void deleteReservation(Connection connection, Scanner scanner, Statement statement) {
		try {
			System.out.println("Enter reservation ID to delete: ");
			int reservationID = scanner.nextInt();

			if (!reservationExists(connection, reservationID, statement)) {
				System.out.println("Reservation not found for the givien ID ");
				return;
			}

			String sql = "DELETE FROM reservation WHERE reservation_id= " + reservationID;

			try {
				int affectdRow = statement.executeUpdate(sql);

				if (affectdRow > 0) {
					System.out.println("Reservation delete successfully!");
				} else {
					System.out.println("Reservation deletion failed. ");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void exit() throws InterruptedException {
		System.out.print("Exiting System");
		int i = 5;
		while (i != 0) {
			System.out.print(".");
			Thread.sleep(1000);
			i--;
		}
		System.out.println();
		System.out.println("Thank you for using the Hotal Reservation System 😊");
	}
}
