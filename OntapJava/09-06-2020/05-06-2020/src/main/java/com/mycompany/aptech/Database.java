package com.mycompany.aptech;

import com.mycompany.aptech.models.Product;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Database {
    //prevent constructor
    private Database() {

    }
    public static final Integer PORT = 3306;
    public static final String DATABASE_NAME = "javatutorials";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:"+PORT+"/"+DATABASE_NAME+
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String MAX_POOL = "250";
    //make Database object thanh global
    private static Database instance;
    public static Database getInstance() {
        //singleton
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public Connection getConnection() {
        Properties properties = new Properties();
        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("MaxPooledStatements", MAX_POOL);
        try {
            return DriverManager.getConnection(DATABASE_URL, properties);
        }catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Statement statement = this.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tblProduct");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer productId = resultSet.getInt("id");
                Double price = resultSet.getDouble("price");
                Integer amount = resultSet.getInt("amount");
                products.add(new Product(name, price, amount));
            }
            return products;
        }catch (Exception e) {
            return products;
        }
    }
}
