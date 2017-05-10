package com.assistant.bean;


import java.util.List;

/**
 * Created by hyc on 2017/5/10 09:54
 */

public class Schedule {

    /**
     * msg : ok
     * data : [{"xh":"14408400127","xqj":"4","djj":"5","dsz":"","qsz":"1","jsz":"12","name":"网络程序设计","teacher":"欧阳旻","room":"计通楼512"},{"xh":"14408400127","xqj":"5","djj":"7","dsz":"","qsz":"1","jsz":"12","name":"网络程序设计","teacher":"欧阳旻","room":"计通楼512"},{"xh":"14408400127","xqj":"3","djj":"7","dsz":"","qsz":"1","jsz":"11","name":"管理会计","teacher":"刘湘","room":"公共517"},{"xh":"14408400127","xqj":"1","djj":"7","dsz":"单","qsz":"1","jsz":"11","name":"管理会计","teacher":"刘湘","room":"计通楼510"},{"xh":"14408400127","xqj":"4","djj":"3","dsz":"","qsz":"1","jsz":"2","name":"网络操作系统","teacher":"张龙信","room":"计通楼512"},{"xh":"14408400127","xqj":"2","djj":"3","dsz":"","qsz":"1","jsz":"3","name":"网络操作系统","teacher":"张龙信","room":"公共516"},{"xh":"14408400127","xqj":"4","djj":"1","dsz":"","qsz":"1","jsz":"12","name":"网络安全","teacher":"洪升彪","room":"计通楼510"},{"xh":"14408400127","xqj":"2","djj":"1","dsz":"","qsz":"1","jsz":"12","name":"网络安全","teacher":"洪升彪","room":"公共517"},{"xh":"14408400127","xqj":"1","djj":"9","dsz":"","qsz":"2","jsz":"5","name":"大学生就业指导","teacher":"叶胜茂","room":"公共332"},{"xh":"14408400127","xqj":"3","djj":"5","dsz":"","qsz":"3","jsz":"11","name":"嵌入式系统及应用","teacher":"龙永新","room":"公共515"},{"xh":"14408400127","xqj":"1","djj":"5","dsz":"","qsz":"3","jsz":"11","name":"嵌入式系统及应用","teacher":"龙永新","room":"计通楼512"},{"xh":"14408400127","xqj":"4","djj":"3","dsz":"","qsz":"4","jsz":"8","name":"网络操作系统","teacher":"张龙信","room":"计通楼512"},{"xh":"14408400127","xqj":"4","djj":"7","dsz":"","qsz":"5","jsz":"10","name":"无线通信与网络","teacher":"吴岳忠","room":"计通楼512"},{"xh":"14408400127","xqj":"2","djj":"3","dsz":"","qsz":"5","jsz":"7","name":"网络操作系统","teacher":"张龙信","room":"公共516"},{"xh":"14408400127","xqj":"5","djj":"5","dsz":"","qsz":"5","jsz":"7","name":"无线通信与网络","teacher":"吴岳忠","room":"计通楼512"},{"xh":"14408400127","xqj":"5","djj":"5","dsz":"","qsz":"9","jsz":"10","name":"无线通信与网络","teacher":"吴岳忠","room":"计通楼512"},{"xh":"14408400127","xqj":"4","djj":"7","dsz":"","qsz":"11","jsz":"14","name":"无线通信与网络","teacher":"吴岳忠","room":"公共302"},{"xh":"14408400127","xqj":"5","djj":"5","dsz":"","qsz":"11","jsz":"14","name":"无线通信与网络","teacher":"吴岳忠","room":"公共311"},{"xh":"14408400127","xqj":"1","djj":"5","dsz":"","qsz":"15","jsz":"15","name":"无线通信与网络","teacher":"吴岳忠","room":"计通楼512"}]
     */

    private String msg;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


}
