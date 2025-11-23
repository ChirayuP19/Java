package JDBCMINIProject2.JDBC.logic;

import JDBCMINIProject2.JDBC.EmployeeDTO.EmployeeDto;
import JDBCMINIProject2.JDBC.crud.CRUD;

import java.util.Scanner;

public class Logic {


   private final int INSERT_DATA=1;
   private final int READ_DATA=2;
   private final int UPDATE_DATA=3;
   private final int DELETE_DATA=4;
   private final int EXIT=5;
   private final int MAX_ATTEMPTS=3;

   private String username;
    private String password;
    private String fullname;
    private String address;
    private int salary;

   private CRUD crud;
   public Logic(){
       crud=new CRUD();
   }

    public void doStart(){


        Scanner sc=new Scanner(System.in);
        int attempt=0;
        while (true) {
            System.out.println("\n======== MENU ==========");
            System.out.println("Press 1: INSERT DATA");
            System.out.println("Press 2: READ DATA");
            System.out.println("Press 3: UPDATE DATA");
            System.out.println("Press 4: DELETE DATA");
            System.out.println("Press 5: EXIT\n");


            System.out.println("================");
            System.out.print("Enter your choice: ");
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please take a number from 1 to 5. \n");
                sc.next();
                attempt++;
                if(attempt>MAX_ATTEMPTS){
                    System.out.println("Unauthorised Activity Found");
                    sc.close();
                    return;
                }
                continue;
            }
            switch (choice){
                case INSERT_DATA:

                    System.out.println("*******INSERT DATA********");
                    System.out.println("Enter USERNAME: ");
                     username=sc.next();
                    System.out.println("Enter PASSWORD: ");
                     password=sc.next();
                    sc.nextLine();
                    System.out.println("Enter FULLNAME: ");
                     fullname=sc.nextLine();
                    System.out.println("Enter ADDRESS: ");
                     address=sc.nextLine();
                    System.out.println("Enter SALARY: ");
                   salary=sc.nextInt();

                    EmployeeDto employeeDto = new EmployeeDto(username, password, fullname, address, salary);
                    crud.insert(employeeDto);
                    break;

                case READ_DATA:

                    System.out.println("Enter USERNAME: ");
                    username=sc.next();
                    System.out.println("Enter PASSWORD: ");
                    password=sc.next();
                    crud.read(username,password);
                    break;

                case UPDATE_DATA:
                    System.out.println("Enter USERNAME");
                    username=sc.next();
                    System.out.println("Enter SALARY TO UPDATE: ");
                    salary=sc.nextInt();
                    crud.update(username,salary);
                    break;

                case DELETE_DATA:
                    System.out.println("Enter USERNAME TO DELETE ");
                    username=sc.next();
                    System.out.println("Password required for security verification:");
                    password=sc.next();
                    crud.delete(username,password);

                    break;
                case EXIT:
                   try {
                       System.out.println("Wait...");
                       Thread.sleep(2000);
                       System.out.println("Shoutdown Successfully");
                       sc.close();
                   } catch (Exception e) {
                       e.printStackTrace();
                       sc.close();
                   }

                    return;
                   // when we write the return it will return where from it calling.

            }
        }
    }

}
