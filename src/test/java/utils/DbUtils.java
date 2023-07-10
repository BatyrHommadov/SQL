package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {
    public static List<Map<String, String>> fetch(String query) {
        List<Map<String, String>> tableData = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(ConfigFileReader.getPropertyV("dbURL"),
                ConfigFileReader.getPropertyV("dbUserName"), ConfigFileReader.getPropertyV("dbPassword"));
             Statement statement = connection.createStatement();) {

            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();


            while (rs.next()) {
                LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
                for (int i = 1; i <= colCount; i++) {
                    String key = resultSetMetaData.getColumnName(i);
                    String value = rs.getString(i);
                    rowData.put(key,value);
                }
                tableData.add(rowData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableData;


    }
    public static void update(String query) {
        try (Connection connection = DriverManager.getConnection(ConfigFileReader.getPropertyV("dbURL"),
                ConfigFileReader.getPropertyV("dbUserName"), ConfigFileReader.getPropertyV("dbPassword"));
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
