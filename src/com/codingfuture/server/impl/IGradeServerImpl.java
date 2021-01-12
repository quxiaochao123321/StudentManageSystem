package com.codingfuture.server.impl;

import com.codingfuture.entity.Grade;
import com.codingfuture.entity.Operate;
import com.codingfuture.entity.SystemData;
import com.codingfuture.server.IGradeServer;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 成绩接口实现类
 *
 * @author quchao
 */
public class IGradeServerImpl implements IGradeServer {
    @Override
    public void create() {
//        获取当前系统中所有的数据集合
        List<Operate> operateList = SystemData.getOperateList();
//        遍历当前集合中的所有学生信息
        System.out.println("系统中的学生信息:");
//        在流中创建一个自增的索引,初始值是1
        AtomicInteger index = new AtomicInteger(1);
//        使用流的形式打印所有的信息
        operateList.forEach(item -> System.out.println("序号:" + index.getAndIncrement() + "\t姓名:" + item.getStudent().getUsername()));
//        输入需要增加人员的成绩的序号
        System.out.println("请输入需要增加人员成绩的序号:");
        int ii = new Scanner(System.in).nextInt();
        if (operateList.get(ii - 1).getGrade() != null) {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("选择的数据已经有成绩,录入的成绩将覆盖原有的成绩");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
        } else {
            operateList.get(ii - 1).setGrade(new Grade());
        }
//        获取输入的成绩信息
        System.out.println("请输入语文成绩:");
        double yuwen = new Scanner(System.in).nextDouble();
        System.out.println("请输入数学成绩:");
        double shuxue = new Scanner(System.in).nextDouble();
        System.out.println("请输入英语成绩:");
        double yingyu = new Scanner(System.in).nextDouble();
        System.out.println("请输入政治成绩:");
        double zhengzhi = new Scanner(System.in).nextDouble();
        operateList.get(ii - 1).setGrade(new Grade(yuwen, shuxue, yingyu, zhengzhi));
        System.out.println("成绩录入成功");
    }

    @Override
    public void update() {
//        获取当前系统中所有的数据集合
        List<Operate> operateList = SystemData.getOperateList();
//        遍历当前集合中的所有学生信息
        System.out.println("系统中的学生信息:");
//        在流中创建一个自增的索引,初始值是1
        AtomicInteger index = new AtomicInteger(1);
//        使用流的形式打印所有的信息
        operateList.forEach(item -> System.out.println("序号:" + index.getAndIncrement() + "\t姓名:" + item.getStudent().getUsername()));
//        输入需要增加人员的成绩的序号
        System.out.println("请输入需要增加人员成绩的序号:");
        int ii = new Scanner(System.in).nextInt();
        if (operateList.get(ii - 1).getGrade() == null) {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("你选择的学生暂未录入成绩,请录入成绩后再进行修改");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
            return;
        }
//        获取输入的成绩信息
        System.out.println("请输入语文成绩:\t原值" + operateList.get(ii - 1).getGrade().getYuWen());
        double yuwen = new Scanner(System.in).nextDouble();
        System.out.println("请输入数学成绩:\t原值" + operateList.get(ii - 1).getGrade().getShuXue());
        double shuxue = new Scanner(System.in).nextDouble();
        System.out.println("请输入英语成绩:\t原值" + operateList.get(ii - 1).getGrade().getYingYu());
        double yingyu = new Scanner(System.in).nextDouble();
        System.out.println("请输入政治成绩:\t原值" + operateList.get(ii - 1).getGrade().getZhengZhi());
        double zhengzhi = new Scanner(System.in).nextDouble();
        operateList.get(ii - 1).setGrade(new Grade(yuwen, shuxue, yingyu, zhengzhi));
        System.out.println("成绩修改成功");
    }

    @Override
    public void query() {
//        获取当前系统中所有的数据集合
        List<Operate> operateList = SystemData.getOperateList();
        System.out.println("所有学生成绩如下:");
        operateList.stream().filter(item -> item.getGrade() != null).map(item -> "姓名:" + item.getStudent().getUsername() + "\t语文:" + item.getGrade().getYuWen() + "\t数学:" + item.getGrade().getShuXue() + "\t英语:" + item.getGrade().getYingYu() + "\t政治:" + item.getGrade().getZhengZhi()).forEach(System.out::println);
    }

    @Override
    public void queryGradeByClasses() {
//        获取当前系统中所有的数据集合
        List<Operate> operateList = SystemData.getOperateList();
//        获取现有数据中所有的班级信息
        System.out.println("请选择需要查询的班级的序号:");
//        将所有的学生信息所在的班级去重排序成一个数组
        List<String> list = operateList.stream().map(item -> item.getStudent().getClassNo()).distinct().sorted().collect(Collectors.toList());
//        创建自增索引
        AtomicInteger index = new AtomicInteger(1);
//        将去重之后的班级数组加上序号排列显示在控制台
        list.stream().map(item -> "序号:" + index.getAndIncrement() + "\t" + item + "\n").forEach(System.out::println);
//        获取需要查询的班级序号
        int ii = new Scanner(System.in).nextInt();
//        获取需要查询的学科信息
        System.out.println("请输入需要查询的学科:(1:语文;2:数学;3:英语;4:政治)");
        int is = new Scanner(System.in).nextInt();
        System.out.println("班级:" + list.get(ii - 1));
        switch (is) {
            case 1:
                System.out.println("学生的语文成绩分别是:");
                operateList.stream().filter(item -> item.getGrade() != null).filter(item -> list.get(ii - 1).equals(item.getStudent().getClassNo())).map(item -> "姓名:" + item.getStudent().getUsername() + "\t成绩:" + item.getGrade().getYuWen() + "\n").forEach(System.out::println);
                break;
            case 2:
                System.out.println("学生的数学成绩分别是:");
                operateList.stream().filter(item -> item.getGrade() != null).filter(item -> list.get(ii - 1).equals(item.getStudent().getClassNo())).map(item -> "姓名:" + item.getStudent().getUsername() + "\t成绩:" + item.getGrade().getShuXue() + "\n").forEach(System.out::println);
                break;
            case 3:
                System.out.println("学生的英语成绩分别是:");
                operateList.stream().filter(item -> item.getGrade() != null).filter(item -> list.get(ii - 1).equals(item.getStudent().getClassNo())).map(item -> "姓名:" + item.getStudent().getUsername() + "\t成绩:" + item.getGrade().getYingYu() + "\n").forEach(System.out::println);
                break;
            case 4:
                System.out.println("学生的政治成绩分别是:");
                operateList.stream().filter(item -> item.getGrade() != null).filter(item -> list.get(ii - 1).equals(item.getStudent().getClassNo())).map(item -> "姓名:" + item.getStudent().getUsername() + "\t成绩:" + item.getGrade().getZhengZhi() + "\n").forEach(System.out::println);
                break;
            default:
        }
    }

    @Override
    public void queryPassGradeByClasses() {
//        获取当前系统中所有的数据集合
        List<Operate> operateList = SystemData.getOperateList();
//        获取现有数据中所有的班级信息
        System.out.println("请选择需要查询的班级的序号:");
//        将所有的学生信息所在的班级去重排序成一个数组
        List<String> list = operateList.stream().map(item -> item.getStudent().getClassNo()).distinct().sorted().collect(Collectors.toList());
//        创建自增索引
        AtomicInteger index = new AtomicInteger(1);
//        将去重之后的班级数组加上序号排列显示在控制台
        list.stream().map(item -> "序号:" + index.getAndIncrement() + "\t" + item + "\n").forEach(System.out::println);
//        获取需要查询的班级序号
        int ii = new Scanner(System.in).nextInt();
//        获取需要查询的学科信息
        System.out.println("请输入需要查询的学科:(1:语文;2:数学;3:英语;4:政治)");
        int is = new Scanner(System.in).nextInt();
        System.out.println("班级:" + list.get(ii - 1));
        switch (is) {
            case 1:
                System.out.println("学生的语文及格成绩分别是:");
                operateList.stream().filter(item -> item.getGrade() != null).filter(item -> list.get(ii - 1).equals(item.getStudent().getClassNo()) && item.getGrade().getYuWen() >= 60).map(item -> "姓名:" + item.getStudent().getUsername() + "\t成绩:" + item.getGrade().getYuWen() + "\n").forEach(System.out::println);
                break;
            case 2:
                System.out.println("学生的数学及格成绩分别是:");
                operateList.stream().filter(item -> item.getGrade() != null).filter(item -> list.get(ii - 1).equals(item.getStudent().getClassNo()) && item.getGrade().getShuXue() >= 60).map(item -> "姓名:" + item.getStudent().getUsername() + "\t成绩:" + item.getGrade().getShuXue() + "\n").forEach(System.out::println);
                break;
            case 3:
                System.out.println("学生的英语及格成绩分别是:");
                operateList.stream().filter(item -> item.getGrade() != null).filter(item -> list.get(ii - 1).equals(item.getStudent().getClassNo()) && item.getGrade().getYingYu() >= 60).map(item -> "姓名:" + item.getStudent().getUsername() + "\t成绩:" + item.getGrade().getYingYu() + "\n").forEach(System.out::println);
                break;
            case 4:
                System.out.println("学生的政治及格成绩分别是:");
                operateList.stream().filter(item -> item.getGrade() != null).filter(item -> list.get(ii - 1).equals(item.getStudent().getClassNo()) && item.getGrade().getZhengZhi() >= 60).map(item -> "姓名:" + item.getStudent().getUsername() + "\t成绩:" + item.getGrade().getZhengZhi() + "\n").forEach(System.out::println);
                break;
            default:
        }
    }

    @Override
    public void queryAvgGrade() {
//        获取当前系统中所有的数据集合
        List<Operate> operateList = SystemData.getOperateList();
//        获取现有数据中所有的班级信息
//        将所有的学生信息所在的班级去重排序成一个数组
        List<String> list = operateList.stream().map(item -> item.getStudent().getClassNo()).distinct().sorted().collect(Collectors.toList());
//        获取需要查询的学科信息
        System.out.println("请输入需要查询的学科:(1:语文;2:数学;3:英语;4:政治)");
        int is = new Scanner(System.in).nextInt();
        switch (is) {
            case 1:
                list.stream().map(item -> "班级:" + item + "的语文平均成绩是:" + operateList.stream().filter(grade -> grade.getGrade() != null).filter(operate -> item.equals(operate.getStudent().getClassNo())).mapToDouble(value -> value.getGrade().getYuWen()).summaryStatistics().getAverage()).forEach(System.out::println);
                break;
            case 2:
                list.stream().map(item -> "班级:" + item + "的数学平均成绩是:" + operateList.stream().filter(grade -> grade.getGrade() != null).filter(operate -> item.equals(operate.getStudent().getClassNo())).mapToDouble(value -> value.getGrade().getShuXue()).summaryStatistics().getAverage()).forEach(System.out::println);
                break;
            case 3:
                list.stream().map(item -> "班级:" + item + "的英语平均成绩是:" + operateList.stream().filter(grade -> grade.getGrade() != null).filter(operate -> item.equals(operate.getStudent().getClassNo())).mapToDouble(value -> value.getGrade().getYingYu()).summaryStatistics().getAverage()).forEach(System.out::println);
                break;
            case 4:
                list.stream().map(item -> "班级:" + item + "的政治平均成绩是:" + operateList.stream().filter(grade -> grade.getGrade() != null).filter(operate -> item.equals(operate.getStudent().getClassNo())).mapToDouble(value -> value.getGrade().getZhengZhi()).summaryStatistics().getAverage()).forEach(System.out::println);
                break;
            default:
        }
    }

    @Override
    public void console() {
        System.out.println("----- 学生成绩管理 -----");
        System.out.println("请选择功能序号:");
        System.out.println("1:学生成绩录入");
        System.out.println("2:学生成绩修改");
        System.out.println("3:学生成绩查询");
        System.out.println("4:单独门科成绩查询");
        System.out.println("5:某科及格人员成绩查询");
        System.out.println("6:每个班某学科平均成绩");
        System.out.println("7:退回到主菜单");
        System.out.println("----------------------");
        int ii = new Scanner(System.in).nextInt();
        switch (ii) {
            case 1:
                this.create();
                break;
            case 2:
                this.update();
                break;
            case 3:
                this.query();
                break;
            case 4:
                this.queryGradeByClasses();
                break;
            case 5:
                this.queryPassGradeByClasses();
                break;
            case 6:
                this.queryAvgGrade();
                break;
            case 7:
                return;
            default:
        }
        this.console();
    }
}
