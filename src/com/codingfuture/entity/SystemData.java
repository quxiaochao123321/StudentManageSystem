package com.codingfuture.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统类
 *
 * @author quchao
 */
public class SystemData {
    /**
     * 全局唯一的操作数据列表
     */
    private static List<Operate> operateList;

    static {
        operateList = new ArrayList<>();
    }

    private SystemData() {
    }


    public static List<Operate> getOperateList() {
        return operateList;
    }

    public static void setOperateList(List<Operate> operateList) {
        SystemData.operateList = operateList;
    }
}
