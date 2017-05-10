package com.assistant;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.assistant.api.Api;
import com.assistant.bean.DataBean;
import com.assistant.bean.Schedule;
import com.assistant.bean.User;
import com.assistant.http.ApiCallback;
import com.assistant.http.ApiClient;
import com.assistant.ui.LoginActivity;
import com.assistant.util.ScheduleUtil;
import com.assistant.util.UserUtil;
import com.assistant.view.AbsGridAdapter;
import com.assistant.view.WeekTitle;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {
    protected Api apiStores;
    private CompositeSubscription mCompositeSubscription;

    private Spinner spinner;

    private GridView detailCource;

    private String[][] contents;

    private AbsGridAdapter secondAdapter;

    private List<String> dataList;

    private ArrayAdapter<String> spinnerAdapter;

    private WeekTitle weekTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.switchWeek);
        weekTitle= (WeekTitle) findViewById(R.id.week);
        detailCource = (GridView)findViewById(R.id.courceDetail);
        apiStores= ApiClient.retrofit().create(Api.class);
        User user= UserUtil.getCurrentUser();
        Connector.getDatabase();
        if (ScheduleUtil.isNeedGetData()){
            Log.i("TAG",user.getData().getStudentKH()+user.getRemember_code_app());
            addSubscription(apiStores.loadSchedule(user.getData().getStudentKH(), user.getRemember_code_app()), new ApiCallback<Schedule>() {
                @Override
                public void onSuccess(Schedule model) {
                    if (model.getMsg().equals("ok")){
                        ScheduleUtil.saveSchedule(model.getData());
                        initView();
                    }else {
                        Toast.makeText(MainActivity.this, model.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(String msg) {
                    Toast.makeText(MainActivity.this, "查询出错"+msg, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFinish() {

                }
            });
        }else {
                initView();
        }


    }

    private void initView(){
        contents=ScheduleUtil.loadSchedule(ScheduleUtil.getCycle());
        secondAdapter = new AbsGridAdapter(this);
        secondAdapter.setContent(contents, 5, 7);
        detailCource.setAdapter(secondAdapter);
        fillDataList();
        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dataList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection (ScheduleUtil.getCycle()-1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                if (position==20){
                    UserUtil.clearCurrentUser();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
                secondAdapter.update(ScheduleUtil.loadSchedule(position+1));
                Log.i("TAG","position-1"+(position-1)+"cycle"+ScheduleUtil.getCycle());
                if (position!=ScheduleUtil.getCycle()-1){
                    weekTitle.setThisWeek(false);
                }else {
                    weekTitle.setThisWeek(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }



    public void fillDataList() {
        dataList = new ArrayList<>();
        for(int i = 1; i < 21; i++) {
            dataList.add("第" + i + "周");
        }
        dataList.add("退出登录");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onUnSubscribe();
    }

    //RXjava取消注册，以避免内存泄露
    public void onUnSubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }


    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}
