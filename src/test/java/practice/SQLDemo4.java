package practice;

import utils.ConfigFileReader;
import utils.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SQLDemo4 {
    public static void main(String[] args) {
       List<Map<String,String>> data=DbUtils.fetch("select * from person");
        System.out.println(data.get(1));

    }


}
