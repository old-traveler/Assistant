package com.assistant.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.assistant.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


/**
 * Created by wan on 2016/10/16.
 * GridView的适配器
 */
public class AbsGridAdapter extends BaseAdapter {

    private Context mContext;

    private String[][] contents;

    private int rowTotal;

    private int columnTotal;

    private int positionTotal;

    public AbsGridAdapter(Context context) {
        this.mContext = context;
    }

    public int getCount() {
        return positionTotal;
    }

    public long getItemId(int position) {
        return position;
    }

    public Object getItem(int position) {
        //求余得到二维索引
        int column = position % columnTotal;
        //求商得到二维索引
        int row = position / columnTotal;
        return contents[row][column];
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if( convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grib_item, null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.text);
        //如果有课,那么添加数据
        if(!TextUtils.isEmpty((CharSequence) getItem(position))) {
            String data=(String)getItem(position);
            if (data.indexOf("~")>0){
                textView.setText(data.split("~")[0]);
                textView.setTextColor(Color.parseColor("#979595"));
                textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_no));
            }else {
                textView.setText(data);
                textView.setTextColor(Color.WHITE);
                Random random = new Random();
                switch( random.nextInt(8) ) {
                    case 0:
                        textView.setBackground(mContext.getResources().getDrawable(R.drawable.grid_item_bg));
                        break;
                    case 1:
                        textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_12));
                        break;
                    case 2:
                        textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_13));
                        break;
                    case 3:
                        textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_14));
                        break;
                    case 4:
                        textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_15));
                        break;
                    case 5:
                        textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_16));
                        break;
                    case 6:
                        textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_17));
                        break;
                    case 7:
                        textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_18));
                        break;
                }
            }

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int row = position / columnTotal;
                    int column = position % columnTotal;
                    String con = "当前选中的是" + contents[row][column] + "课";
                    Toast.makeText(mContext, con, Toast.LENGTH_SHORT).show();
                }
            });
        }
        return convertView;
    }

    /**
     * 设置内容、行数、列数
     */
    public void setContent(String[][] contents, int row, int column) {
        this.contents = contents;
        this.rowTotal = row;
        this.columnTotal = column;
        positionTotal = rowTotal * columnTotal;

    }
    /**
     * 设置内容、行数、列数
     */
    public void update(String[][] contents) {
        this.contents = contents;
        this.rowTotal = 5;
        this.columnTotal = 7;
        positionTotal = rowTotal * columnTotal;
        notifyDataSetChanged();
    }



}
