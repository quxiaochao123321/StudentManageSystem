package com.codingfuture.server.impl;

import com.codingfuture.entity.Operate;
import com.codingfuture.entity.Parent;
import com.codingfuture.entity.SystemData;
import com.codingfuture.server.IParentServer;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 家长信息接口实现类
 *
 * @author quchao
 */
public class IParentServerImpl implements IParentServer {
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
        System.out.println("请输入需要增加家长信息的人员序号:");
        int ii = new Scanner(System.in).nextInt();
        if (operateList.get(ii - 1).getParentList().size() != 0) {
            System.out.println("原有家长信息如下:");
            operateList.get(ii - 1).getParentList().forEach(System.out::println);
        }
        System.out.println("请输入新增的家长信息");
        System.out.println("请输入家长姓名:");
        String username = new Scanner(System.in).next();
        System.out.println("请输入家长性别:(1:男;2女)");
        int sex = new Scanner(System.in).nextInt();
        System.out.println("请输入家长与学生的关系:");
        String relation = new Scanner(System.in).next();
        System.out.println("请输入家长的年龄:");
        int age = new Scanner(System.in).nextInt();
        System.out.println("请输入家长的联系方式:");
        String mobile = new Scanner(System.in).next();
        operateList.get(ii - 1).getParentList().add(new Parent(username, sex == 1 ? "男" : "女", relation, age, mobile));
        System.out.println("数据新增成功");
    }

    @Override
    public void delete() {
//        获取当前系统中所有的数据集合
        List<Operate> operateList = SystemData.getOperateList();
//        遍历当前集合中的所有学生信息
        System.out.println("系统中的学生信息:");
//        在流中创建一个自增的索引,初始值是1
        AtomicInteger index = new AtomicInteger(1);
//        使用流的形式打印所有的信息
        operateList.forEach(item -> System.out.println("序号:" + index.getAndIncrement() + "\t姓名:" + item.getStudent().getUsername()));
//        输入需要增加人员的成绩的序号
        System.out.println("请输入需要删除家长信息的人员序号:");
        int ii = new Scanner(System.in).nextInt();
        if (operateList.get(ii - 1).getParentList().size() == 0) {
            System.out.println("你选择的人员暂无家长信息");
            return;
        }
        System.out.println("已录入家长信息如下:");
        AtomicInteger parentIndex = new AtomicInteger(1);
        operateList.get(ii - 1).getParentList().stream().map(parent -> "序号:" + parentIndex.getAndIncrement() + "\t" + parent).forEach(System.out::println);
        System.out.println("请选择要删除信息的序号:");
        int is = new Scanner(System.in).nextInt();
        operateList.get(ii - 1).getParentList().remove(is - 1);
        System.out.println("数据删除成功");
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
        System.out.println("请输入需要更新家长信息的人员序号:");
        int ii = new Scanner(System.in).nextInt();
        if (operateList.get(ii - 1).getParentList().size() == 0) {
            System.out.println("你选择的人员暂无家长信息");
            return;
        }
        System.out.println("已录入家长信息如下:");
        AtomicInteger parentIndex = new AtomicInteger(1);
        operateList.get(ii - 1).getParentList().stream().map(parent -> "序号:" + parentIndex.getAndIncrement() + "\t" + parent).forEach(System.out::println);
        System.out.println("请选择要更新信息的序号:");
        int is = new Scanner(System.in).nextInt();
        System.out.println("请输入家长姓名:\t原值" + operateList.get(ii - 1).getParentList().get(is - 1).getUsername());
        String username = new Scanner(System.in).next();
        System.out.println("请输入家长性别:(1:男;2女)\t原值" + operateList.get(ii - 1).getParentList().get(is - 1).getSex());
        int sex = new Scanner(System.in).nextInt();
        System.out.println("请输入家长与学生的关系:\t原值" + operateList.get(ii - 1).getParentList().get(is - 1).getRelation());
        String relation = new Scanner(System.in).next();
        System.out.println("请输入家长的年龄:\t原值" + operateList.get(ii - 1).getParentList().get(is - 1).getAge());
        int age = new Scanner(System.in).nextInt();
        System.out.println("请输入家长的联系方式:\t原值" + operateList.get(ii - 1).getParentList().get(is - 1).getMobile());
        String mobile = new Scanner(System.in).next();
        operateList.get(ii - 1).getParentList().set(is - 1, new Parent(username, sex == 1 ? "男" : "女", relation, age, mobile));
        System.out.println("数据修改成功");
    }

    @Override
    public void query() {
//        获取当前系统中所有的数据集合
        List<Operate> operateList = SystemData.getOperateList();
//        遍历当前集合中的所有学生信息
        System.out.println("系统中的学生信息:");
//        在流中创建一个自增的索引,初始值是1
        AtomicInteger index = new AtomicInteger(1);
//        使用流的形式打印所有的信息
        operateList.forEach(item -> System.out.println("序号:" + index.getAndIncrement() + "\t姓名:" + item.getStudent().getUsername()));
//        输入需要增加人员的成绩的序号
        System.out.println("请输入需要查询家长信息的人员序号:");
        int ii = new Scanner(System.in).nextInt();
        if (operateList.get(ii - 1).getParentList().size() == 0) {
            System.out.println("你选择的人员暂无家长信息");
            return;
        }
        operateList.get(ii - 1).getParentList().forEach(System.out::println);
    }

    @Override
    public void console() {
        System.out.println("----- 家长信息管理 -----");
        System.out.println("请选择功能序号:");
        System.out.println("1:家长信息录入");
        System.out.println("2:家长信息修改");
        System.out.println("3:家长信息删除");
        System.out.println("4:家长信息查询");
        System.out.println("5:退回到主菜单");
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
                this.delete();
                break;
            case 4:
                this.query();
                break;
            case 5:
                return;
            default:
        }
        this.console();
    }
}
