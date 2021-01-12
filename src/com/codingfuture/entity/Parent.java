package com.codingfuture.entity;

/**
 * 家长类
 */
public class Parent {
    /**
     * 姓名
     */
    private String username;
    /**
     * 性别
     */
    private String sex;
    /**
     * 与学生关系
     */
    private String relation;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 联系方式
     */
    private String mobile;


    public Parent() {
    }


    public Parent(String username, String sex, String relation, Integer age, String mobile) {
        this.username = username;
        this.sex = sex;
        this.relation = relation;
        this.age = age;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", relation='" + relation + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
