package JDBCMINIProject2.JDBC.crud;

import JDBCMINIProject2.JDBC.EmployeeDTO.EmployeeDto;

import java.sql.*;

public class CRUD {

    public CRUD(){
        CreateTable();
    }

    public void insert(EmployeeDto employeeDto){
        Connection connection=null;

        PreparedStatement preparedStatement=null;
        try {
            String sql = "INSERT INTO employee(USERNAME,PASSWORD,FULLNAME,ADDRESS,SALARY)" +
                    "VALUES(?,?,?,?,?)";
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql); // here sql qurrey compline without data.

            int count=1;
            while(count<=5) {
                // here sql querry is alread complied here we just give data.
                preparedStatement.setString(1, employeeDto.getUsername());
                preparedStatement.setString(2, employeeDto.getPassword());
                preparedStatement.setString(3, employeeDto.getFullname());
                preparedStatement.setString(4, employeeDto.getAddress());
                preparedStatement.setInt(5, employeeDto.getSalary());

                preparedStatement.executeUpdate();

                System.out.println("DATA Inserted. ");
                count++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(preparedStatement);
            ConnectionFactory.close(connection);
        }
    }

    public void read(String username,String password){
        PreparedStatement preparedStatement=null;
        Connection connection=null;
        ResultSet resultSet=null;

        try {
            String sql="SELECT * FROM employee WHERE USERNAME=? AND PASSWORD=?";
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement(sql);


            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

           resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
            int sn = resultSet.getInt("sn");
            String getUsername = resultSet.getString("USERNAME");
            String getPassword = resultSet.getString("PASSWORD");
            String getFullname = resultSet.getString("FULLNAME");
            String getAddress = resultSet.getString("ADDRESS");
            int getSalary = resultSet.getInt("SALARY");

                System.out.println("+----+------------+----------------+----------------------+--------+");
                System.out.printf("| %-2s | %-10s | %-14s | %-20s | %-6s |\n", "SN", "USERNAME", "FULLNAME", "ADDRESS", "SALARY");
                System.out.println("+----+------------+----------------+----------------------+--------+");

                System.out.printf("| %-2d | %-10s | %-14s | %-20s | %-6d |\n", sn, getUsername, getFullname, getAddress, getSalary);

                System.out.println("+----+------------+----------------+----------------------+--------+");

            }else {
                System.out.println("USER not found..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(connection);
            ConnectionFactory.close(preparedStatement);

        }
    }

    public void update(String username, int salary){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            String sql="UPDATE employee SET SALARY=? WHERE USERNAME=?";
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setInt(1,salary);
            preparedStatement.setString(2,username);

            int i = preparedStatement.executeUpdate();
            if(i>0){
                System.out.println("DATA UPDATED..");
            }else
                System.out.println("USER NOT FOUND....");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(connection);
            ConnectionFactory.close(preparedStatement);

        }

    }

    public void delete(String username,String password){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            String sql = "DELETE from employee where USERNAME=? and PASSWORD=?";
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            int i1 = preparedStatement.executeUpdate();
            if(i1>0){
                System.out.print("DATA DELETEING");
                for (int i = 0; i < 5; i++) {
                    System.out.print(".");
                    Thread.sleep(2000);
                }
            }else
                System.out.println("USER NOT FOUND...........");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(connection);
            ConnectionFactory.close(preparedStatement);

        }
    }

    public void CreateTable(){
        Connection connection=null;

        PreparedStatement preparedStatement=null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql="CREATE TABLE IF NOT EXISTS employee (" +
                    "sn INT AUTO_INCREMENT PRIMARY KEY, " +
                    "USERNAME VARCHAR(30) NOT NULL UNIQUE, " +
                    "PASSWORD VARCHAR(30), " +
                    "FULLNAME VARCHAR(100), " +
                    "ADDRESS VARCHAR(200), " +
                    "SALARY INT)";
           preparedStatement=connection.prepareStatement(sql);
           preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
