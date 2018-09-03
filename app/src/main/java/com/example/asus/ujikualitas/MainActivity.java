package com.example.asus.ujikualitas;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.asus.ujikualitas.ExpandableListDataPump.getData;


public class MainActivity extends AppCompatActivity {

    public static final String key_id = "data_id";
    public static final String key_no_trs = "data_no_trs";
    public static final String key_tgl_trs = "data_tgl_trs";
    public static final String key_obyek = "data_no_trs";
    public static final String key_rekanan = "data_no_trs";
    public static final String key_ket = "data_no_trs";
    public static final String key_cr_at = "data_no_trs";
    public static final String key_cr_by = "data_no_trs";
    public static final String key_versi = "data_no_trs";
    public static final String key_lokasi = "data_no_trs";



    public static final String URL = "http://36.66.205.251/report1/";
    private ProgressDialog progress;

    private List<Result> results = new ArrayList<>();
    private RecyclerViewAdapter viewAdapter;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
//    @BindView(R.id.progress_bar) ProgressBar progressBar;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        viewAdapter = new RecyclerViewAdapter(this, results);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        loadData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.view();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
//                progressBar.setVisibility(View.GONE);
//                if (value.equals("1")) {
                    results = response.body().getResult();
                    viewAdapter = new RecyclerViewAdapter(MainActivity.this, results);
                    recyclerView.setAdapter(viewAdapter);
//                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {

            }
        });
    }


    public void tambahUji(View view) {
        Intent intent = new Intent(this, PengujianBaru.class);
        startActivity(intent);
    }

    public void detailUji(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }
}
