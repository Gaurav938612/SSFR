package com.android.gaurav.myproject.authentication;

import android.app.Activity;

import androidx.lifecycle.ViewModel;

import com.android.gaurav.myproject.models.ApiClient;
import com.android.gaurav.myproject.models.ApiInterFace;
import com.android.gaurav.myproject.models.LoadingDialog;
import com.android.gaurav.myproject.models.User;
import com.android.gaurav.myproject.tab_fragment.LoginFragment;
import com.android.gaurav.myproject.tab_fragment.RegisterFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginViewModel extends ViewModel implements FragmentCallbackListener{
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;
    private ViewModelToActivity mListener;
    private Activity activity;
   // public ObservableBoolean loading=new ObservableBoolean(false);

    public void setmListener(ViewModelToActivity mListener,Activity activity) {
        this.mListener = mListener;
        this.activity=activity;
    }

    public void createFragment() {
        loginFragment=new LoginFragment();
        registerFragment=new RegisterFragment();
    }
    public void serUpInterfaceListener(){
        loginFragment.setListener(this);
        registerFragment.setListener(this);
    }
    public LoginFragment getLoginFragment() {
        return loginFragment;
    }

    public RegisterFragment getRegisterFragment() {
        return registerFragment;
    }

    @Override
    public void performLogin(String userName, String password) {
        LoadingDialog.startLoading(activity,"validating");
        ApiInterFace interFace= ApiClient.getRetrofit().create(ApiInterFace.class);
        Call<User> call=interFace.getLoginInfo(userName,password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    mListener.Toaster("Connection Failed");
                    return;
                }
                User user=response.body();
                if(user!=null){
                    if(user.getUserStatus().equals("OK")){
                        mListener.Toaster("Logged in as "+user.getFirstName()+"  "+
                                    user.getLastName());
                        mListener.switchActivity();
                        SharedPreferenceConfig config=mListener.getSharedPreferenceConfig();
                        config.registerUserIdToDevice(user.getUserId());
                    }
                    else {
                        mListener.Toaster(user.getUserStatus());
                    }
                }
                LoadingDialog.hideLoading();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mListener.Toaster("Connection Failed");
                t.printStackTrace();
                LoadingDialog.hideLoading();
            }
        });
    }

    @Override
    public void performRegistration() {

    }
    interface ViewModelToActivity{
        void Toaster(String s);
        void switchActivity();
        SharedPreferenceConfig getSharedPreferenceConfig();
    }
}
