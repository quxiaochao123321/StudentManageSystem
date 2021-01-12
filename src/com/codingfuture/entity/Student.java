package com.codingfuture.entity;

/**
 * 学生类
 *
 * @author quchao
 */
public class Student {
    /**
     * 姓名
     */
    private String username;
    /**
     * 性别
     */
    private String sex;
    /**
     * 学号
     */
    private String stuNo;
    /**
     * 班级
     */
    private String classNo;

    public Student() {
    }

    public Student(String username, String sex, String stuNo, String classNo) {
        this.username = username;
        this.sex = sex;
        this.stuNo = stuNo;
        this.classNo = classNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", classNo='" + classNo + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }
}
