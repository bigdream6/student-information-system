package com.geng.pojo;

public class User {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String classNo;
    private String ji;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", classNo='" + classNo + '\'' +
                ", ji='" + ji + '\'' +
                '}';
    }

    public User() {
    }

    public User(int id, String name, int age, String sex, String classNo, String ji) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.classNo = classNo;
        this.ji = ji;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getJi() {
        return ji;
    }

    public void setJi(String ji) {
        this.ji = ji;
    }
}
