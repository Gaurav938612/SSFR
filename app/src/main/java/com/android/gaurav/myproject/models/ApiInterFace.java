package com.android.gaurav.myproject.models;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterFace {
    @GET("New Folder/login.php")
    Call<User> getLoginInfo(@Query("username") String userName ,@Query("password") String password);

}
