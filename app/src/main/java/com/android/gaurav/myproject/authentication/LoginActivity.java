package com.android.gaurav.myproject.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.gaurav.myproject.R;
import com.android.gaurav.myproject.activity.HomeActivity;
import com.android.gaurav.myproject.databinding.ActivityLoginBinding;
import com.android.gaurav.myproject.tab_adapter.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity implements LoginViewModel.ViewModelToActivity {
    ViewPager mViewPager;
    TabLayout mTabLayout;
    LoginViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(checkLoginActivity()!=null){
            return;
        }
        ActivityLoginBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_login);
        Toolbar toolbar=findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Project");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mViewPager=findViewById(R.id.viewPagerId);
        mTabLayout=findViewById(R.id.tabLayoutId);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        mViewModel.setmListener(this,this);
        if(savedInstanceState==null)
            mViewModel.createFragment();
        mViewModel.serUpInterfaceListener();
        setUpPageAdapter();
        binding.setViewmodel(mViewModel);
    }

    public void setUpPageAdapter(){
        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPageAdapter.addFragment(mViewModel.getLoginFragment(),"Login");
        viewPageAdapter.addFragment(mViewModel.getRegisterFragment(),"New User");
        mViewPager.setAdapter(viewPageAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void Toaster(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void switchActivity() {
        Intent intent=new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public SharedPreferenceConfig getSharedPreferenceConfig() {
        return new SharedPreferenceConfig(this);
    }
    private String checkLoginActivity() {
        SharedPreferenceConfig config=new SharedPreferenceConfig(this);
        if(config.readLoginStatus())
            return config.readUserId();
        return null;
    }
}
