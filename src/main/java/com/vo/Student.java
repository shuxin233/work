package com.vo;

import java.util.List;

public class Student {
    private int id;
    private String sname;
    private int math;
    private int english;
    private int chinese;
    private int cid;
    private Class myclass;



    public Student(){}
    public Student(int id, String sname, int math, int english, int chinese, int cid) {
        this.id = id;
        this.sname = sname;
        this.math = math;
        this.english = english;
        this.chinese = chinese;
        this.cid = cid;
    }

    public Student(String sname, int math, int english, int chinese, int cid, Class myclass) {
        this.sname = sname;
        this.math = math;
        this.english = english;
        this.chinese = chinese;
        this.cid = cid;
        this.myclass = myclass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Class getMyclass() {
        return myclass;
    }

    public void setMyclass(Class myclass) {
        this.myclass = myclass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", math=" + math +
                ", english=" + english +
                ", chinese=" + chinese +
                ", cid=" + cid +
                '}';
    }
}
