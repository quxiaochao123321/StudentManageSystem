package com.codingfuture.server.impl;

import com.codingfuture.entity.Operate;
import com.codingfuture.entity.Student;
import com.codingfuture.entity.SystemData;
import com.codingfuture.server.IStudentServer;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 学生信息接口实现类
 *
 * @author quchao
 */
public class IStudentServerImpl implements IStudentServer {

    @Override
    public void create() {
//        获取当前系统中所有的数据集合
        List<Operate> operateList = SystemData.getOperateList();
//        在控制台中获取用户信息数据
        System.out.println("请输入姓名:");
        String username = new Scanner(System.in).next();
        System.out.println("请输入性别:(1:男;2女)");
        int sex = new Scanner(System.in).nextInt();
        System.out.println("请输入学号:");
        String no = new Scanner(System.in).next();
        System.out.println("请输入班级:");
        String classes = new Scanner(System.in).next();
//        如果想要添加一个用户信息,必然有一组对应的成绩和家长信息,所以要创建一个操作的类
        Operate operate = new Operate();
//        设置操作这个类的学生信息是一个新的学生对象
        operate.setStudent(new Student(username, sex == 1 ? "男" : "女", no, classes));
//        然后把操作类放置到全局唯一的集合数组中
        operateList.add(operate);
        System.out.println("数据添加成功");
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
//        获取想要删除值的序号
        System.out.println("请输入需要删除的学生的序号:");
        int ii = new Scanner(System.in).nextInt();
//        删除对应数据
        operateList.remove(--ii);
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
//        获取想要删除值的序号
        System.out.println("请输入需要更新的学生的序号:");
        int ii = new Scanner(System.in).nextInt();
//        在控制台中获取用户信息数据
        System.out.println("请输入姓名:\t原值:" + operateList.get(ii - 1).getStudent().getUsername());
        String username = new Scanner(System.in).next();
        System.out.println("请输入性别:(1:男;2女)\t原值:" + operateList.get(ii - 1).getStudent().getSex());
        int sex = new Scanner(System.in).nextInt();
        System.out.println("请输入学号:\t原值:" + operateList.get(ii - 1).getStudent().getStuNo());
        String no = new Scanner(System.in).next();
        System.out.println("请输入班级:\t原值:" + operateList.get(ii - 1).getStudent().getClassNo());
        String classes = new Scanner(System.in).next();
        operateList.get(ii - 1).setStudent(new Student(username, sex == 1 ? "男" : "女", no, classes));
        System.out.println("数据更新成功");
    }

    @Override
    public void query() {
        //        获取当前系统中所有的数据集合
        List<Operate> operateList = SystemData.getOperateList();
        System.out.println("所有人员的数据:");
        operateList.forEach(item -> System.out.println(item.getStudent()));
        System.out.println("按照班级查询的数据:");
        Map<String, List<Student>> map = new HashMap<>();
        operateList.forEach(item -> {
            if (map.containsKey(item.getStudent().getClassNo())) {
                map.get(item.getStudent().getClassNo()).add(item.getStudent());
            } else {
                List<Student> list = new ArrayList<>();
                list.add(item.getStudent());
                map.put(item.getStudent().getClassNo(), list);
            }
        });
        map.entrySet().stream().map(item -> "班级:" + item.getKey() + "\t姓名:" + item.getValue().stream().map(student -> student.getUsername() + "\t").collect(Collectors.joining())).forEach(System.out::println);
    }

    @Override
    public void console() {
        System.out.println("----- 学生信息管理 -----");
        System.out.println("请选择功能序号:");
        System.out.println("1:创建学生信息");
        System.out.println("2:修改学生信息");
        System.out.println("3:删除学生信息");
        System.out.println("4:查询学生信息");
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
