package com.assistant.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by wan on 2016/10/12.
 * 自定义标题栏，用来显示周一到周日
 */
public class WeekTitle extends View {

    //保存当前的日期
    private int day;

    private Paint mPaint;

    private Paint linePaint;

    private String[] days = {"一", "二", "三", "四", "五", "六", "日"};

    public void setThisWeek(boolean thisWeek) {
        isThisWeek = thisWeek;
        invalidate();
    }

    public boolean isThisWeek() {
        return isThisWeek;
    }

    private boolean isThisWeek=true;

    public WeekTitle(Context context)
    {
        super(context);
    }

    public WeekTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        day = 0;
        mPaint = new Paint();
        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setColor(Color.parseColor("#b48f8f8f"));
        linePaint.setStrokeWidth(0.5f);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        day = c.get(Calendar.DAY_OF_WEEK)-2;
        if (day<0){
            day=6;
        }
    }

    /**
     * 重写测量函数，否则在设置wrap_content的时候默认为match_parent
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void onDraw(Canvas canvas) {
        //获得当前View的宽度
        int width = getWidth();
        int height = getHeight();
        int offset = width / 7;
        int currentPosition = offset;
        //设置要绘制的字体
        mPaint.setTypeface(Typeface.create(Typeface.DEFAULT_BOLD, Typeface.BOLD));
        mPaint.setTextSize(30);
        mPaint.setColor(Color.rgb(0, 134, 139));
        for (int i = 0; i < 7; i++) {
            if (day==i&&isThisWeek){
                Paint paint=new Paint();
                paint.setAntiAlias(true);
                paint.setColor(Color.parseColor("#718dcaca"));
                canvas.drawRect(i*offset,0,(i+1)*offset,height,paint);
            }
            canvas.drawLine(i * offset, 0, i * offset, height, linePaint);
            canvas.drawText(days[i], currentPosition - offset / 2 - 15, getHeight()/2+15, mPaint);
            currentPosition += offset;
        }
        //调用父类的绘图方法
        super.onDraw(canvas);
    }


}
