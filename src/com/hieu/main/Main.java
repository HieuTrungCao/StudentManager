package com.hieu.main;

import com.hieu.management.Manager;
import com.hieu.myConst.MyConst;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Manager mg = new Manager();
        mg.start();
    }
}
