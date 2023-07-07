package practice;

import java.sql.*;

public class SQLDemo2 {
    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://orangehrm.qedgetech.com:3306/orangehrm2022";
        String userName = "qedgehrm";
        String password = "12345";

       try( Connection connection = DriverManager.getConnection(dbURL, userName, password);
        Statement statement = connection.createStatement();){
           String query="select * from person";

        ResultSet rs= statement.executeQuery(query);

        //column indexes start from 1
        while(rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }

       }catch (SQLException e){
           e.printStackTrace();
       }


    }
}
