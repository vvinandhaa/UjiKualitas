package com.example.asus.ujikualitas;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateDataActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText eText;
    String sid;
    String strs;
    String stgltrs;
    String sket;
    String scrat;
    String slok;
    String soby;
    String srek;
    String sver;
    String scrby;

    public static final String URL = "http://36.66.205.251/report1/";
    private ProgressDialog progress;
    @BindView(R.id.edid) TextView edid;
    @BindView(R.id.ednomor) EditText ednomor;
    @BindView(R.id.edtgl_pengujian) EditText edtgl_pengujian;
    @BindView(R.id.edobject) EditText edobject;
    @BindView(R.id.edrekanan) EditText edrekanan;
    @BindView(R.id.edket) EditText edket;
    @BindView(R.id.edcr_at) EditText edcr_at;
    @BindView(R.id.edcr_by) EditText edcr_by;
    @BindView(R.id.edversi) EditText edversi;
    @BindView(R.id.edlokasi) EditText edlokasi;


    @OnClick(R.id.buttonadd) void ubah() {
        //membuat progress dialog
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        //mengambil data dari edittext
        String id = edid.getText().toString();
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
        Call<Value> call = api.ubah(id, no_trs, tgl_trs, obyek, rekanan, ket, cr_at, cr_by, versi, lokasi);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progress.dismiss();
                if (value.equals("1")) {
                    Toast.makeText(UpdateDataActivity.this, message, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateDataActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(UpdateDataActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                t.printStackTrace();
                progress.dismiss();
                Toast.makeText(UpdateDataActivity.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        ButterKnife.bind(this);

        Intent intent = getIntent();
//        String id = intent.getStringExtra("id");
//        String xno_trs = intent.getStringExtra("sno_trs");
//        String xtgl_trs = intent.getStringExtra("stgl_trs");
//        String xobyek = intent.getStringExtra("sobyek");
//        String xrekanan = intent.getStringExtra("srekanan");
//        String xket = intent.getStringExtra("sket");
//        String xcr_at = intent.getStringExtra("scr_at");
//        String xcr_by = intent.getStringExtra("scr_by");
//        String xversi = intent.getStringExtra("sversi");
//        String xlokasi = intent.getStringExtra("slokasi");

//        System.out.print("++++no trs+++++"+xno_trs);

        sid= intent.getStringExtra("id");
        strs= intent.getStringExtra("trs");
        stgltrs= intent.getStringExtra("tgltrs");
        sket= intent.getStringExtra("ket");
        scrat= intent.getStringExtra("crat");
        soby= intent.getStringExtra("oby");
        srek= intent.getStringExtra("rek");
        slok= intent.getStringExtra("lok");
        scrat= intent.getStringExtra("crat");
        scrby= intent.getStringExtra("crby");
        sver= intent.getStringExtra("ver");

        edid.setText(sid);
        ednomor.setText(strs);
        edtgl_pengujian.setText(stgltrs);
        edobject.setText(soby);
        edrekanan.setText(srek);
        edket.setText(sket);
        edcr_at.setText(scrat);
        edcr_by.setText(scrby);
        edversi.setText(sver);
        edlokasi.setText(slok);


//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat mdformat = new SimpleDateFormat("dd-MMM-yyyy");
//        String tglpem =  mdformat.format(calendar.getTime());
//
//        EditText edtglpem = findViewById(R.id.edcr_at);
//        edtglpem.setText(tglpem);

        eText = (EditText) findViewById(R.id.edtgl_pengujian);
        eText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                picker = new DatePickerDialog(UpdateDataActivity.this,
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
