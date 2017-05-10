package com.assistant.bean;

/**
 * Created by hyc on 2017/5/10 10:04
 */

public class User {

    /**
     * remember_code_app : 登录令牌
     * data : {"studentKH":"15408300210","school":"衡南一中","TrueName":"贺宇成","username":"尼古拉斯·赵磊","dep_name":"计算机学院","class_name":"软件工程1502","address":"湖南省","active":"1","last_login":"2017-04-18 20:23","login_cnt":"10","head_pic":"/uploads/headpics/201702/1487659374.273182200.png","sex":"男","user_id":"24838","head_pic_thumb":"/uploads/headpics/201702/1487659374.273182200_thumb.png"}
     * msg : 请求状态
     * code : 请求状态代码
     */

    private String remember_code_app;
    private DataBean data;
    private String msg;
    private int code;

    public String getRemember_code_app() {
        return remember_code_app;
    }

    public void setRemember_code_app(String remember_code_app) {
        this.remember_code_app = remember_code_app;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * studentKH : 学号
         * school : 高中
         * TrueName : 真实姓名
         * username : 用户名
         * dep_name : 学院
         * class_name : 班级号
         * address : 地址
         * active : 1
         * last_login : 上次登录时间
         * login_cnt : 10
         * head_pic : 头像
         * sex : 性别
         * user_id : 用户id
         * head_pic_thumb : /uploads/headpics/201702/1487659374.273182200_thumb.png
         */

        private String studentKH;
        private String school;
        private String TrueName;
        private String username;
        private String dep_name;
        private String class_name;
        private String address;
        private String active;
        private String last_login;
        private String login_cnt;
        private String head_pic;
        private String sex;
        private String user_id;
        private String head_pic_thumb;

        public String getStudentKH() {
            return studentKH;
        }

        public void setStudentKH(String studentKH) {
            this.studentKH = studentKH;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getTrueName() {
            return TrueName;
        }

        public void setTrueName(String TrueName) {
            this.TrueName = TrueName;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getDep_name() {
            return dep_name;
        }

        public void setDep_name(String dep_name) {
            this.dep_name = dep_name;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getLast_login() {
            return last_login;
        }

        public void setLast_login(String last_login) {
            this.last_login = last_login;
        }

        public String getLogin_cnt() {
            return login_cnt;
        }

        public void setLogin_cnt(String login_cnt) {
            this.login_cnt = login_cnt;
        }

        public String getHead_pic() {
            return head_pic;
        }

        public void setHead_pic(String head_pic) {
            this.head_pic = head_pic;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getHead_pic_thumb() {
            return head_pic_thumb;
        }

        public void setHead_pic_thumb(String head_pic_thumb) {
            this.head_pic_thumb = head_pic_thumb;
        }
    }
}
