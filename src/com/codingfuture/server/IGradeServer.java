package com.codingfuture.server;

/**
 * 成绩接口
 *
 * @author quchao
 */
public interface IGradeServer {
    /**
     * 创建
     */
    void create();

    /**
     * 修改
     */
    void update();

    /**
     * 查询
     */
    void query();

    /**
     * 按照班级查询成绩
     */
    void queryGradeByClasses();

    /**
     * 按照班级查询及格的成绩
     */
    void queryPassGradeByClasses();

    /**
     * 查询每个班级的平均成绩
     */
    void queryAvgGrade();

    /**
     * 控制台
     */
    void console();
}
