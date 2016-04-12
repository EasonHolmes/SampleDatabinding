package com.cui.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cui.mvvms.BR;
import com.cui.mvvms.R;
import com.cui.mvvms.databinding.ActivityMainBinding;

import com.cui.databinding.entity.User;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.toolbar.setTitle(R.string.app_name);
        setSupportActionBar(dataBinding.toolbar);
    }

    public void onClickToSecondActivity(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }

    public void onClickChangeTxt(View view) {
        User user = new User();
        user.setName("Eason");
        dataBinding.setUser(user);
        //两种方法选其一
//        dataBinding.setVariable(BR.user, user);
//        dataBinding.executePendingBindings();
    }
}
