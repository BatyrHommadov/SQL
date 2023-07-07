package practice;

import java.sql.*;

public class SQLDemo3 {
    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://orangehrm.qedgetech.com:3306/orangehrm2022";
        String userName = "qedgehrm";
        String password = "12345";

        try (Connection connection = DriverManager.getConnection(dbURL, userName, password);
             Statement statement = connection.createStatement();) {
            String query = "select * from person";

            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();
            System.out.println(colCount);
            for (int i = 1; i <= colCount; i++) {
                System.out.print(resultSetMetaData.getColumnName(i) + " ");
            }
            System.out.println();
            //column indexes start from 1
            while (rs.next()) {
                for (int i = 1; i <= colCount; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
