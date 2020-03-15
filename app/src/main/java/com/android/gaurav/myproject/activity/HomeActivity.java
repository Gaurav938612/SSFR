package com.android.gaurav.myproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.gaurav.myproject.R;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public String getPageTitle() {
        return "Home Page";
    }
}
