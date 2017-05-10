package com.assistant.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.assistant.bean.DataBean;
import com.assistant.bean.User;

import org.litepal.crud.DataSupport;

/**
 * Created by hyc on 2017/5/10 16:15
 */

public class UserUtil {
    private static Context mContext;

    public static void init(Context context){
        mContext=context;
    }

    public static void setCurrentUser(User user) {
        SharedPreferences.Editor editor = mContext
                .getSharedPreferences("user", Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.putString("name", user.getData().getStudentKH());
        editor.putString("key", user.getRemember_code_app());
        editor.apply();
    }

    public static User getCurrentUser() {
        SharedPreferences pref = mContext
                .getSharedPreferences("user", Context.MODE_PRIVATE);
        User user = new User();
        user.setData(new User.DataBean());
        user.setRemember_code_app(pref.getString("key",""));
        user.getData().setStudentKH(pref.getString("name",""));
        return user;
    }

    public static void clearCurrentUser() {
        SharedPreferences.Editor editor = mContext
                .getSharedPreferences("user", Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();
        DataSupport.deleteAll(DataBean.class);
    }


}
