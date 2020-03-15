package com.android.gaurav.myproject.tab_fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.gaurav.myproject.R;
import com.android.gaurav.myproject.authentication.FragmentCallbackListener;

public class RegisterFragment extends Fragment {
    FragmentCallbackListener listener;

    public void setListener(FragmentCallbackListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_register,container,false);
    }
}
