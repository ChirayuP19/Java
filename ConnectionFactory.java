package JDBCMINIProject2.JDBC.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String DB_URl="jdbc:mysql://localhost:3306/mystudent";
    private static final String DB_USERNAME="root";
    private static final String DB_PASSWORD="Chirayu@1911";

    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(DB_URl,DB_USERNAME,DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
    public static void close(AutoCloseable resource){
        try {
            if(resource!=null)
                resource.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
