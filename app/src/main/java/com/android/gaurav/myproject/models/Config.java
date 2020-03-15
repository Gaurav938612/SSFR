package com.android.gaurav.myproject.models;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

public class Config {
    public static User user;
    private static AlertDialog alertDialog;
    private static ProgressBar progressBar;
    public static void showAlertDialog(Context context,String title,String message){

        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.show();
    }
    public static void dismissDialog(){
        if(alertDialog!=null)
            alertDialog.dismiss();
    }
    public static void  setUser(User user){
        Config.user=user;
    }
}
