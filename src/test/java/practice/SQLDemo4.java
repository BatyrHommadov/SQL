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
        List<Map<String, String>> data = DbUtils.fetch("select * from ohrm_skill where id=8;");
        System.out.println(data.get(0));
       /*Map<String,String> row0= data.get(0);
       String name=row0.get("name");
        System.out.println(name);*/

        Map<String,String> row0=data.get(0);
        String description=row0.get("description");
        System.out.println(description);



    }


}
