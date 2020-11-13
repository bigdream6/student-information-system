package com.geng.pojo;

public class totalOne {
    private String classNo;
    private int count;

    public totalOne() {
    }

    public totalOne(String classNo, int count) {
        this.classNo = classNo;
        this.count = count;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
