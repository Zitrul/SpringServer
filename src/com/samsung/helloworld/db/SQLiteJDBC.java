package com.samsung.helloworld.db;
import java.sql.*;

public class SQLiteJDBC {
    public static void Create(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:login.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE AUTH " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " LOGIN           TEXT    NOT NULL, " +
                    " PASSWORD            INT     NOT NULL," +
                    " X                 DOUBLE  NOT NULL," +
                    " Y                 DOUBLE  NOT NULL," +
                    "EMAIL              TEXT   NOT NULL," +
                    "PHONE              TEXT   NOT NULL," +
                    "TG                  TEXT  NOT NULL) ";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public static String write(int id, String login,String password,Double x, Double y, String email, String phone, String tg) {
        Connection c = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:login.db");
            System.out.println("Opened database successfully");

            String sql = "INSERT INTO AUTH (ID,LOGIN,PASSWORD,X,Y,EMAIL,PHONE,TG) " +
                    "VALUES (?,?,?,?,?,?,?,?)";
            ;
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, login);
            stmt.setString(3, password);
            stmt.setDouble(4,x );
            stmt.setDouble(5,y );
            stmt.setString(6,email );
            stmt.setString(7,phone );
            stmt.setString(8,tg );
            stmt.executeUpdate();
            stmt.close();
            c.close();
            System.out.println(login);
            System.out.println(password);
            System.out.println(x);
            System.out.println(y);
            System.out.println(email);
            System.out.println(phone);
            System.out.println(tg);
            c = DriverManager.getConnection("jdbc:sqlite:login.db");
            stmt = null;
            sql = "SELECT * FROM AUTH WHERE LOGIN = '"+login+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                return "LOGIN ALlREADY IN USE";


            }


            stmt.close();
            c.close();
            return "OK";
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
        return "ERROR";
    }
    public static ResultSet exec( String command ) {
        Connection c = null;
        Statement stmt = null;
        ResultSet r1= null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:login.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = command;
            ResultSet rs = stmt.executeQuery(sql);

            r1 = rs;
            rs.close();
            stmt.close();
            c.close();
            return r1;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return r1;
    }
    public static String check_password(String login){
        Connection c = null;
        Statement stmt = null;
        String password = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:login.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "SELECT * FROM AUTH WHERE LOGIN = '"+login+"';";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("LOGIN");
                password = rs.getString("PASSWORD");

                break;
            }
            rs.close();
            stmt.close();
            c.close();
            return password;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return "";
    }
}