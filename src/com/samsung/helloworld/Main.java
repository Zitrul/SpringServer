package com.samsung.helloworld;


import com.samsung.helloworld.db.SQLiteJDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.ResultSet;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class);
        System.out.println("Hello world!");
    }
}