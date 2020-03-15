package com.android.gaurav.myproject.authentication;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;

import static android.provider.Settings.*;

public class SharedPreferenceConfig {
    private SharedPreferences mSharedPreferences;
    private Context mContext;

    public SharedPreferenceConfig(Context context){
        mContext=context;
        mSharedPreferences=context.getSharedPreferences("com.android.abc",Context.MODE_PRIVATE);
    }
    public boolean readLoginStatus(){
        String android_id = Secure.getString(mContext.getContentResolver(),Secure.ANDROID_ID);
        String storedId=mSharedPreferences.getString("deviceId",null);
        if(android_id.equals(storedId)){
            return mSharedPreferences.getBoolean("loginStatus",false);
        }
        return false;
    }
    public String readUserId(){
        return mSharedPreferences.getString("userId",null);
    }

    public void registerUserIdToDevice(String userId){
        String deviceId=Secure.getString(mContext.getContentResolver(), Secure.ANDROID_ID);
        SharedPreferences.Editor editor=mSharedPreferences.edit();
        editor.putBoolean("loginStatus",true);
        editor.putString("userId",userId);
        editor.putString("deviceId",deviceId);
        editor.apply();
    }

}
