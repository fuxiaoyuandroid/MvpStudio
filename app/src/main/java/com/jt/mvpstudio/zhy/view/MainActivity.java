package com.jt.mvpstudio.zhy.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jt.mvpstudio.R;
import com.jt.mvpstudio.zhy.model.User;
import com.jt.mvpstudio.zhy.presenter.UserLoginPresenter;

public class MainActivity extends AppCompatActivity implements IUserLoginView {
    private EditText username,password;
    private Button login,clear;
    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        clear = findViewById(R.id.clear);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clear();
            }
        });
    }


    @Override
    public String getUsername() {
        return username.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return password.getText().toString().trim();
    }

    @Override
    public void clearUsername() {
        username.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }

    @Override
    public void toLoginSuccess(User user) {
        Toast.makeText(this,"测试登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toShowFail() {
        Toast.makeText(this,"测试登录失败",Toast.LENGTH_SHORT).show();
    }
}
