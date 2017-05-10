package com.assistant.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.assistant.MainActivity;
import com.assistant.R;
import com.assistant.api.Api;
import com.assistant.bean.User;
import com.assistant.http.ApiCallback;
import com.assistant.http.ApiClient;
import com.assistant.util.UserUtil;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class LoginActivity extends AppCompatActivity {
    protected Api apiStores;
    private CompositeSubscription mCompositeSubscription;

    @Bind(R.id.ed_username)
    EditText edUsername;
    @Bind(R.id.ed_password)
    EditText edPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserUtil.init(LoginActivity.this);
        if (!TextUtils.isEmpty(UserUtil.getCurrentUser().getRemember_code_app())) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        apiStores = ApiClient.retrofit().create(Api.class);

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        if (!isFilled()) {
            Toast.makeText(this, "请填写好信息", Toast.LENGTH_SHORT).show();
            return;
        }
        addSubscription(apiStores.login(edUsername.getText().toString(), edPassword.getText().toString()), new ApiCallback<User>() {
            @Override
            public void onSuccess(User model) {
                if (model.getMsg().equals("ok")) {

                    UserUtil.setCurrentUser(model);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "请确认账号密码是否正确", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(String msg) {
                Toast.makeText(LoginActivity.this, "出错" + msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {

            }
        });

    }

    private boolean isFilled() {
        return !TextUtils.isEmpty(edUsername.getText().toString())
                && !TextUtils.isEmpty(edPassword.getText().toString());
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
