package com.hieu.myConst;

public class MyConst {

    private static MyConst myC;

    private MyConst() {

    }

    public static MyConst getMyConst() {
        if(myC == null)
            myC = new MyConst();

        return myC;
    }

    public final String driver = "com.mysql.jdbc.Driver"; // to load driver for my Sql
    public final String url = "jdbc:mysql://localhost:3306/studentmanagement?characterEncoding=latin1";
    public final String user = "root";
    public final String pass = "242003";

    public final String queryGetStudent = "select * from students";
}
