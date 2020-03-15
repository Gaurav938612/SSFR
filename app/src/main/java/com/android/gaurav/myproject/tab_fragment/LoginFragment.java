package com.android.gaurav.myproject.tab_fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.gaurav.myproject.R;
import com.android.gaurav.myproject.authentication.FragmentCallbackListener;
import com.android.gaurav.myproject.models.ApiClient;
import com.android.gaurav.myproject.models.ApiInterFace;
import com.android.gaurav.myproject.models.Config;
import com.android.gaurav.myproject.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment implements View.OnClickListener {
    View view;
    Button mLoginButton;
    TextView mUserName,mPassword;
    FragmentCallbackListener listener;


    public void setListener(FragmentCallbackListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.tab_login,container,false);
        mLoginButton = view.findViewById(R.id.loginButton);
        mUserName=view.findViewById(R.id.userName);
        mPassword=view.findViewById(R.id.password);
        mLoginButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.loginButton){
            if(this.listener!=null)
            listener.performLogin(mUserName.getText().toString(),mPassword.getText().toString());
        }
    }
}
