package com.wyk.taobao.ui;

import static android.content.ContentValues.TAG;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wyk.taobao.MainActivity;
import com.wyk.taobao.R;
import com.wyk.taobao.http.CommonCallback;
import com.wyk.taobao.http.UserBiz;
import com.wyk.taobao.model.bean.User;
import com.wyk.taobao.utils.T;


/**
 * 登陆页控制类
 */
public class LoginActivity extends AppCompatActivity {
    EditText password;
    EditText username;
    Button login;
    TextView toRegister;
    TextView toUserFound;
    UserBiz userBiz;

    private ProgressDialog eLoadingDialog;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpToolBar();
        setTitle("登录");
        initView();
        initEvent();
        eLoadingDialog = new ProgressDialog(this);
        eLoadingDialog.setMessage("加载中...");
    }

    private void stopLoadingProgress() {
        if(eLoadingDialog != null && eLoadingDialog.isShowing()) eLoadingDialog.dismiss();
    }
    private void startLoadingProgress() {
        eLoadingDialog.show();
    }
    private void setUpToolBar() {
        toolbar = findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBackPressed();
                    }
                }
        );
    }

    private void initEvent() {
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               toRegisterActivity();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = username.getText().toString();
                String passWord = password.getText().toString();
                if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)){
                    T.showToast("密码或账号不能为空哦~");
                    return;
                }
                startLoadingProgress();
                userBiz.login(userName, passWord, new CommonCallback<User>() {
                    @Override
                    public void onError(Exception e) {
                        stopLoadingProgress();
                        Log.d(TAG, "onError: "+e.getMessage());
                        T.showToast(e.getMessage());
                    }

                    @SuppressLint("SuspiciousIndentation")
                    @Override
                    public void onSuccess(User response) {
                        stopLoadingProgress();
                        T.showToast("登录成功~" + response.isManager());
//                        UserInfoHolder.getInstance().setUser(response);
                        toBasicInfoActivity();
                    }
                });

            }
        });

        toUserFound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toUserFoundActivity();
            }
        });
    }

    private void toBasicInfoActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    private void toUserFoundActivity() {
//        Intent intent = new Intent(this,PasswordFoundActivity.class);
//        startActivity(intent);
    }

    private void toRegisterActivity() {
//        Intent intent = new Intent(this,RegisterActivity.class);
//        startActivity(intent);
    }

    private void initView() {
        password = findViewById(R.id.id_et_password);
        username = findViewById(R.id.id_et_username);
        login = findViewById(R.id.id_btn_login);
        toRegister = findViewById(R.id.id_tv_register);
        toUserFound = findViewById(R.id.id_tv_found);
        userBiz = new UserBiz();
    }
}