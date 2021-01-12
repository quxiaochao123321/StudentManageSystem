package com.codingfuture.entity;

/**
 * 成绩类
 *
 * @author quchao
 */
public class Grade {
    /**
     * 语文
     */
    private Double yuWen;
    /**
     * 数学
     */
    private Double shuXue;
    /**
     * 英语
     */
    private Double yingYu;
    /**
     * 政治
     */
    private Double zhengZhi;

    public Grade() {
    }

    public Grade(Double yuWen, Double shuXue, Double yingYu, Double zhengZhi) {
        this.yuWen = yuWen;
        this.shuXue = shuXue;
        this.yingYu = yingYu;
        this.zhengZhi = zhengZhi;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "yuWen=" + yuWen +
                ", shuXue=" + shuXue +
                ", yingYu=" + yingYu +
                ", zhengZhi=" + zhengZhi +
                '}';
    }

    public Double getYuWen() {
        return yuWen;
    }

    public void setYuWen(Double yuWen) {
        this.yuWen = yuWen;
    }

    public Double getShuXue() {
        return shuXue;
    }

    public void setShuXue(Double shuXue) {
        this.shuXue = shuXue;
    }

    public Double getYingYu() {
        return yingYu;
    }

    public void setYingYu(Double yingYu) {
        this.yingYu = yingYu;
    }

    public Double getZhengZhi() {
        return zhengZhi;
    }

    public void setZhengZhi(Double zhengZhi) {
        this.zhengZhi = zhengZhi;
    }
}
