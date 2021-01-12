package com.codingfuture.run;

import com.codingfuture.server.IGradeServer;
import com.codingfuture.server.IParentServer;
import com.codingfuture.server.IStudentServer;
import com.codingfuture.server.impl.IGradeServerImpl;
import com.codingfuture.server.impl.IParentServerImpl;
import com.codingfuture.server.impl.IStudentServerImpl;

import java.util.Scanner;

/**
 * 程序运行类
 *
 * @author quchao
 */
public class ProgramRun {
    private final IStudentServer iStudentServer = new IStudentServerImpl();
    private final IGradeServer iGradeServer = new IGradeServerImpl();
    private final IParentServer iParentServer = new IParentServerImpl();

    public static void main(String[] args) {
        new ProgramRun().console();
    }

    /**
     * 页面信息打印
     */
    public void console() {
        System.out.println("----- 学生信息管理系统 -----");
        System.out.println("请选择功能序号:");
        System.out.println("1:学生信息管理");
        System.out.println("2:学生成绩管理");
        System.out.println("3:家长信息管理");
        System.out.println("4:退出系统");
        System.out.println("-------------------------");

        int ii = new Scanner(System.in).nextInt();
        switch (ii) {
            case 1:
                iStudentServer.console();
                break;
            case 2:
                iGradeServer.console();
                break;
            case 3:
                iParentServer.console();
                break;
            case 4:
                System.exit(0);
                break;
            default:
        }
        this.console();
    }
}
