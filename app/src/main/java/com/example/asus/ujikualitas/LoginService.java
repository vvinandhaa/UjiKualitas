package com.example.asus.ujikualitas;
import android.content.Context;

import retrofit2.Callback;

/**
 * Created by Fegi on 8/20/2018.
 */

public class LoginService {
    private LoginInterface loginInterface;

    public LoginService(Context context) {
        loginInterface = RetrofitBuilder.builder(context)
                .create(LoginInterface.class);
    }

    public void doLogin(String username, String password, Callback callback) {
        loginInterface.login(username, password).enqueue(callback);
    }
}
