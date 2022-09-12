package com.hieu.connection;

import com.hieu.myConst.MyConst;

import java.sql.DriverManager;
import java.sql.Connection;

public class MyConnection {

    private static MyConnection myConnection;

    private MyConnection() {

    }

    public static MyConnection getMyConnection() {
        if (myConnection == null) {
            myConnection = new MyConnection();
        }

        return  myConnection;
    }

    public Connection getConnection(String url, String user, String pass) {

        try {
            Class.forName(MyConst.getMyConst().driver);
            Connection connect = DriverManager.getConnection(url, user, pass);
            return connect;
        } catch (Exception e) {
            System.out.println("False to connecting");
        }

        return null;
    }
}
