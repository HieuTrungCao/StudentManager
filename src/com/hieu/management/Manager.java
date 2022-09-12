package com.hieu.management;

import com.hieu.myConst.MyConst;
import com.hieu.student.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    ArrayList<Student> students;
    Scanner sc;
    Connection connect;
    Statement state;

    public Manager() {
        students = new ArrayList<>();
        sc = new Scanner(System.in);
        setConnect();
    }

    public void start() {
        getStudentFromSQL();
        short c;
        do {
            showMenu();
            c = sc.nextShort();

            switch (c) {
                case 1 :
                    addStudent();
                    break;
                case 2 :
                    deleteStudent();
                    break;
                case 3 :
                    prepairStudent();
                    break;
                case 4 :
                    showStudent();
                    break;
            }
        } while ( c <= 4 && c > 0);

    }
    private void setConnect(){
        connect = com.hieu.connection.MyConnection.getMyConnection()
                .getConnection(MyConst.getMyConst().url, MyConst.getMyConst().user, MyConst.getMyConst().pass);

        try {
            state = connect.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showMenu(){
        System.out.println("==================================================");
        System.out.println("= 1 : Them hoc sinh                              =");
        System.out.println("= 2 : Xoa hoc sinh                               =");
        System.out.println("= 3 : Chinh sua thong tin hoc sinh               =");
        System.out.println("= 4 : Hien thi danh sach hoc sinh                =");
        System.out.println("= 5 : Thoat chuong trinh                         =");
        System.out.println("==================================================");
        System.out.print(" Choice : ");
    }

    private void getStudentFromSQL() {
        try {
            ResultSet sr = state.executeQuery(MyConst.getMyConst().queryGetStudent);

            while (sr.next()){
                Student student = new Student(
                        sr.getString(1), sr.getString(2),
                        sr.getString(3), sr.getString(4),
                        sr.getString(5));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void addStudent() {
        String id, name, birthday, stuClass, email;
        sc.nextLine();
        System.out.print("Nhap Id : ");
        id = sc.nextLine();
        System.out.print("Nhap name : ");
        name = sc.nextLine();
        System.out.print("Nhap birthday : ");
        birthday = sc.nextLine();
        System.out.print("Nhap class : ");
        stuClass = sc.nextLine();
        System.out.print("Nhap email : ");
        email = sc.nextLine();

        students.add(new Student(id, name, birthday, stuClass, email));

        String query = "INSERT INTO students VALUES ('" + id + "', '" + name + "', '" + birthday
                                             + "', '" + stuClass + "', '" + email + "')";
        updateStudentToSQL(query);
    }

    private void updateStudentToSQL(String query) {
        try {
            state.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteStudent() {
        sc.nextLine();
        System.out.print("Nhap id sinh vien can xoa: ");
        String id = sc.nextLine();

        students.remove(new Student(id));

        String query = "delete from students where id = "+ id;
        updateStudentToSQL(query);
    }

    private void prepairStudent() {
        System.out.println("chinh sua thong tin hoc sinh\nLuu ban chi duoc sua name, birthday");
        sc.nextLine();
        System.out.print("Nhap Id cua sinh vien can thay : ");
        String id = sc.nextLine();
        System.out.print("Nhap ten can sua : ");
        String name = sc.nextLine();
        System.out.print("Nhap ngay sinh can sua : ");
        String birthday = sc.nextLine();

        for(Student student : students) {
            if(student.getId().equals(id)) {
                student.setName(name);
                student.setBirthday(birthday);
            }
        }

        String query = "UPDATE students SET Name = '" + name + "', Birthday = '" + birthday + "' WHERE Id = '" + id + "'";

        updateStudentToSQL(query);
    }

    private void showStudent() {
        System.out.println("Table of students");
        for(Student s : students){
            System.out.println(s);
        }
    }
}

/**
 * nhiem vu
 * them hoc sinh vao co so du lieu
 * lay hoc sinh tu co so du lieu
 * xoa hoc sinh roi cap nhat
 * chinh sua thong tin cua hoc sinh
 * in ta ca hoc sinh ra cmd
 */
