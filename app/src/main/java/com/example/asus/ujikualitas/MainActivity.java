package com.example.asus.ujikualitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {



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
