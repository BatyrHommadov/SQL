package practice;

import java.sql.*;

public class SQLDemo1 {
    public static void main(String[] args) {
        // API:Name of the database;//address of server:port/schema
        String dbURL = "jdbc:mysql://orangehrm.qedgetech.com:3306/orangehrm2022";
        String userName = "qedgehrm";
        String password = "12345";
        // We need a connection to the database before we can start executing the queries on
        // that database
        try (Connection connection = DriverManager.getConnection(dbURL, userName, password);
        ) {
            // Takes the queries from this java code executes them on the database and
            // brings back the results
            Statement statement = connection.createStatement();
            String query = "select * from employee";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String empId = resultSet.getString("empid");
                String salary = resultSet.getString("salary");
                String grade = resultSet.getString("grade");
                System.out.println(empId + " " + salary + " " + grade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
