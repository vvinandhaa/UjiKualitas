package com.example.asus.ujikualitas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
        private EditText UserText;
        private EditText PassText;
        private Button btn_Login;

    private LoginService loginService;

    public static void start(Context context) {
        Intent intent = new Intent(context, Login.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(isSessionLogin()) {
            MainActivity.start(this);
            Login.this.finish();
        }

        UserText = findViewById(R.id.UserText);
        PassText = findViewById(R.id.PassText);
        btn_Login = findViewById(R.id.btn_login);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginAct();
            }
        });
        }

    void loginAct() {
        String username = UserText.getText().toString();
        String password = PassText.getText().toString();

        if(TextUtils.isEmpty(username)) {
            UserText.setError("Username cannot be empty!");
            return;
        }

        if(TextUtils.isEmpty(password)) {
            PassText.setError("Password cannot be empty");
            return;
        }

        loginService = new LoginService(this);
        loginService.doLogin(username, password, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                User user = (User) response.body();

                if(user != null) {
                    if(!user.isError()) {
                        PrefUtil.putUser(Login.this, PrefUtil.USER_SESSION, user);
                        MainActivity.start(Login.this);
                        Login.this.finish();
                    }

                    Toast.makeText(Login.this, user.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(Login.this, "An error occurred!"+ t, Toast.LENGTH_LONG).show();
                Log.e("msg", "error =" +t);
            }
        });

    }

    boolean isSessionLogin() {
        return PrefUtil.getUser(this, PrefUtil.USER_SESSION) != null;
    }
}

