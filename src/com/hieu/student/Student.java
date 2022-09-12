package com.hieu.student;

public class Student {
    private String id;
    private String name;
    private String birthday;
    private String stuClass;
    private String email;

    public Student(String id) {
        this.setId(id);
        this.setName("No Name");
        this.setBirthday("No birthday");
        this.setStuClass("No Class");
        this.setEmail("No email");
    }

    public Student(String id, String name, String birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.setStuClass("No Class");
        this.setEmail("No email");
    }

    public Student(String id, String name, String birthday, String stuClass, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.stuClass = stuClass;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student){
            return this.id.equals(((Student) obj).getId());
        }

        return false;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.name + " - " + this.birthday + " - " + this.stuClass + " - " + this.email;
    }
}
