package com.example.asus.ujikualitas;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.sql.Date.valueOf;

public class PengujianBaru extends AppCompatActivity {




    DatePickerDialog picker;
    EditText eText;

    public static final String URL = "http://36.66.205.251/report1/";
    private ProgressDialog progress;

    @BindView(R.id.ednomor) EditText ednomor;
    @BindView(R.id.edtgl_pengujian) EditText edtgl_pengujian;
    @BindView(R.id.edobject) EditText edobject;
    @BindView(R.id.edrekanan) EditText edrekanan;
    @BindView(R.id.edket) EditText edket;
    @BindView(R.id.edcr_at) EditText edcr_at;
    @BindView(R.id.edcr_by) EditText edcr_by;
    @BindView(R.id.edversi) EditText edversi;
    @BindView(R.id.edlokasi) EditText edlokasi;



    @OnClick(R.id.buttonadd) void daftar() {


        //mengambil data dari edittext
        String no_trs = ednomor.getText().toString();
        String tgl_trs = edtgl_pengujian.getText().toString();
        int obyek = Integer.valueOf(edobject.getText().toString());
        int rekanan = Integer.valueOf(edrekanan.getText().toString());
        String ket = edket.getText().toString();
        String cr_at = edcr_at.getText().toString();
        String cr_by = edcr_by.getText().toString();
        int versi = Integer.valueOf(edversi.getText().toString());
        String lokasi = edlokasi.getText().toString();





        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.daftar(no_trs, tgl_trs, obyek, rekanan, ket, cr_at, cr_by, versi, lokasi);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
//                progress.dismiss();
                if (value.equals("1")) {
                    Toast.makeText(PengujianBaru.this, message, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PengujianBaru.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(PengujianBaru.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(PengujianBaru.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengujian_baru);

        ButterKnife.bind(this);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd-MMM-yyyy");
        String tglpem =  mdformat.format(calendar.getTime());

        EditText edtglpem = findViewById(R.id.edcr_at);
        edtglpem.setText(tglpem);

        eText = (EditText) findViewById(R.id.edtgl_pengujian);
        eText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                picker = new DatePickerDialog(PengujianBaru.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                Calendar calendar = Calendar.getInstance();
                                calendar.set(year, monthOfYear, dayOfMonth);
                                SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                                String dateString = format.format(calendar.getTime());
                                eText.setText(dateString);
                            }
                        }, mYear, mMonth, mDay);
                picker.show();
            }
        });

     


    }







}
