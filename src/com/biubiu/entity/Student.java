package com.biubiu.entity;

import java.util.Date;

public class Student {
    private Integer sid;
    private String  sname;
    private Integer age;
    private String sex;
    private String department;
    private String address;
    private String  birthplace;

    public Student() {
    }

    public Student(Integer sid, String sname, Integer age, String sex, String department, String address, String  birthplace) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.sex = sex;
        this.department = department;
        this.address = address;
        this.birthplace = birthplace;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String  getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String  birthplace) {
        this.birthplace = birthplace;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", address='" + address + '\'' +
                ", birthplace=" + birthplace +
                '}';
    }
}
