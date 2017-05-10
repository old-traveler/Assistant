package com.assistant.util;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.assistant.bean.DataBean;

import org.litepal.crud.DataSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by hyc on 2017/5/10 16:46
 */

public class ScheduleUtil {

    public static String[][] loadSchedule(int selectCycle){
        String[][] schedule=new String[5][7];
        List<DataBean> lists=DataSupport.findAll(DataBean.class);
        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis()));
        int dayTime;
        try {
            dayTime=daysOfTwo(stringToDate("2017/2/20"),stringToDate(today));
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("TAG","日期格式出错");
            dayTime = -1;
        }
        int cycle;
        cycle=selectCycle;

        for (DataBean list : lists) {
            if (cycle % 2 == 0 && list.getDsz().equals("单")
                    || cycle % 2 != 0 && list.getDsz().equals("双")
                    || cycle < Integer.parseInt(list.getQsz())
                    || cycle > Integer.parseInt(list.getJsz())) {

                if (TextUtils.isEmpty(schedule[(Integer.parseInt(list.getDjj()) + 1) / 2 - 1]
                        [Integer.parseInt(list.getXqj()) - 1])){
                    schedule[(Integer.parseInt(list.getDjj()) + 1) / 2 - 1]
                            [Integer.parseInt(list.getXqj()) - 1] = list.getName() + "@" + list.getRoom() + "~";
                }
            }else {
                schedule[(Integer.parseInt(list.getDjj()) + 1) / 2 - 1]
                        [Integer.parseInt(list.getXqj()) - 1] = list.getName() + "@" + list.getRoom() ;
            }
        }
        return schedule;
    }

    public static void saveSchedule(List<DataBean> dataBeens){
        for (DataBean dataBean : dataBeens) {
            dataBean.save();
        }
    }
    public static boolean isNeedGetData(){
        return DataSupport.findAll(DataBean.class).size()==0;
    }/**
     * 将String类型的日期转化为Date型数据
     * @param time
     * @return
     * @throws ParseException  格式错误对象
     */
    public static Date stringToDate(String time) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy/MM/dd");
        return formatter.parse(time);
    }

    /**
     * 计算两个Date日期对象之间相差的天数
     * @param fDate
     * @param oDate
     * @return
     */
    public static int daysOfTwo(Date fDate, Date oDate) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(fDate);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(oDate);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        return day2 - day1;
    }

    public static int getCycle(){
        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis()));
        int dayTime;
        try {
            dayTime=daysOfTwo(stringToDate("2017/2/20"),stringToDate(today));
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("TAG","日期格式出错");
            dayTime = -1;
        }
        return dayTime/7+1;
    }

}
