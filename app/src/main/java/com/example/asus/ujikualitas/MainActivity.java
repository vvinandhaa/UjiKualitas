package com.example.asus.ujikualitas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tambahUji(View view) {
        Intent intent = new Intent(this, PengujianBaru.class);
        startActivity(intent);

    }

    public void detailUji(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);

    }


}
