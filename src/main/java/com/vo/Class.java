package com.vo;

import java.util.List;

public class Class {
    private int cid;
    private String cname;
    private String cteacher;
    private List<Student> studentsList;

    public Class(){};
    public Class(int cid, String cname, String cteacher) {
        this.cid = cid;
        this.cname = cname;
        this.cteacher = cteacher;
    }

    @Override
    public String toString() {
        return "Class{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cteacher='" + cteacher + '\'' +
                ", studentsList=" + studentsList +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCteacher() {
        return cteacher;
    }

    public void setCteacher(String cteacher) {
        this.cteacher = cteacher;
    }

    public List<Student> getEmplist() {
        return studentsList;
    }

    public void setEmplist(List<Student> emplist) {
        this.studentsList = emplist;
    }
}
