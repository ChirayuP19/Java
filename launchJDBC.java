package JDBCMINIProject2.JDBC.start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class launchJDBC {
    public static void main(String[] args)  {
        try {
            // this is an optional we can remove it after 4 update.
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ulr="jdbc:mysql://localhost:3306";
            String username="root";
            String password="Chirayu@1911";
            try {
                // FATCORY DESIGN PATTEN.
                Connection connection = DriverManager.getConnection(ulr, username, password);
                System.out.println(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
