package com.example.asus.ujikualitas;
import com.example.asus.ujikualitas.User;
import com.example.asus.ujikualitas.Config;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Fegi on 8/20/2018.
 */

public interface LoginInterface {
    @FormUrlEncoded
    @POST(Config.API_LOGIN)
    Call<User> login(
            @Field("username") String username,
            @Field("password") String password);
}