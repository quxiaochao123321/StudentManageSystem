package com.codingfuture.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作使用的类
 * 每一组数据对应一个学生信息,一个成绩信息,一组家长信息
 *
 * @author quchao
 */
public class Operate {
    /**
     * 学生信息
     */
    private Student student;
    /**
     * 成绩信息
     */
    private Grade grade;
    /**
     * 家长信息
     */
    private List<Parent> parentList = new ArrayList<>();

    @Override
    public String toString() {
        return "Operate{" +
                "student=" + student +
                ", grade=" + grade +
                ", parentList=" + parentList +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }
}
