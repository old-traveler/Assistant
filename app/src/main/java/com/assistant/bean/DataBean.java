package com.assistant.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by hyc on 2017/5/10 16:43
 */

public class DataBean extends DataSupport {
    /**
     * xh : 学号
     * xqj : 星期几
     * djj : 第几节
     * dsz : 单双周
     * qsz : 起始周
     * jsz : 结束周
     * name : 课程名
     * teacher : 教室姓名
     * room : 上课教室
     */

    private String xh;
    private String xqj;
    private String djj;
    private String dsz;
    private String qsz;
    private String jsz;
    private String name;
    private String teacher;
    private String room;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXqj() {
        return xqj;
    }

    public void setXqj(String xqj) {
        this.xqj = xqj;
    }

    public String getDjj() {
        return djj;
    }

    public void setDjj(String djj) {
        this.djj = djj;
    }

    public String getDsz() {
        return dsz;
    }

    public void setDsz(String dsz) {
        this.dsz = dsz;
    }

    public String getQsz() {
        return qsz;
    }

    public void setQsz(String qsz) {
        this.qsz = qsz;
    }

    public String getJsz() {
        return jsz;
    }

    public void setJsz(String jsz) {
        this.jsz = jsz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}