package com.example.asus.ujikualitas;

import android.content.Context;
import android.content.Intent;
import android.preference.EditTextPreference;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by ASUS on 15/08/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Result> results;

    private static final String TAG = "RecyclerViewAdapter";

    public RecyclerViewAdapter(Context context, List<Result> results) {
        this.context = context;
        this.results = results;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Result result = results.get(position);
        holder.textViewId.setText(result.getid());
        holder.textViewNo_Trs.setText(result.getno_trs());
        holder.textViewTglPeng.setText(result.gettgl_trs());
        holder.textViewObyek.setText(result.getobyek());
        holder.textViewKet.setText(result.getket());
        holder.textViewTgl_pem.setText(result.getcr_at());
        holder.textViewLokasi.setText(result.getlokasi());

        holder.textViewRekanan.setText(result.getrekanan());
        holder.textViewCr_by.setText(result.getcr_by());
        holder.textViewVersi.setText(result.getversi());

        Log.d(TAG, "onBindViewHolder: called.");

        holder.Cardcrdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("sendID", results.get(position).getid());
                intent.putExtra("sendTRS", results.get(position).getno_trs());
                intent.putExtra("sendtgl_trs", results.get(position).gettgl_trs());
                intent.putExtra("sendobyek", results.get(position).getobyek());
                intent.putExtra("sendket", results.get(position).getket());
                intent.putExtra("sendcr_at", results.get(position).getcr_at());
                intent.putExtra("sendlokasi", results.get(position).getlokasi());
                intent.putExtra("sendrekanan", results.get(position).getrekanan());
                intent.putExtra("sendcr_by", results.get(position).getcr_by());
                intent.putExtra("sendversi", results.get(position).getversi());


                context.startActivity(intent);
            }
        });

    }




    @Override
    public int getItemCount() {
        return results.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        @BindView(R.id.textID) TextView textViewId;
        @BindView(R.id.textNo_Trs) TextView textViewNo_Trs;
        @BindView(R.id.textTglPeng) TextView textViewTglPeng;
        @BindView(R.id.textObyek) TextView textViewObyek;
        @BindView(R.id.textKet) TextView textViewKet;
        @BindView(R.id.textTgl_pem) TextView textViewTgl_pem;
        @BindView(R.id.textLokasi) TextView textViewLokasi;
        @BindView(R.id.crdv) CardView Cardcrdv;
        @BindView(R.id.textRek) TextView textViewRekanan;
        @BindView(R.id.textBy) TextView textViewCr_by;
        @BindView(R.id.textVrs) TextView textViewVersi;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
////            String npm = textViewNPM.getText().toString();
////            String nama = textViewNama.getText().toString();
////            String kelas = textViewKelas.getText().toString();
////            String sesi = textViewSesi.getText().toString();
//
//            String no_trs = textViewNo_Trs.getText().toString();
//            String tgl_trs = textViewTglPeng.getText().toString();
//            int obyek = Integer.valueOf(textViewObyek.getText().toString());
//            int rekanan = Integer.valueOf(textViewRekanan.getText().toString());
//            String ket = textViewKet.getText().toString();
//            String cr_at = textViewTgl_pem.getText().toString();
//            String cr_by = textViewCr_by.getText().toString();
//            int versi = Integer.valueOf(textViewVersi.getText().toString());
//            String lokasi = textViewLokasi.getText().toString();
//
//            Intent i = new Intent(context, UpdateDataActivity.class);
//            i.putExtra("sno_trs", no_trs);
//            i.putExtra("stgl_trs", tgl_trs);
//            i.putExtra("sobyek", obyek);
//            i.putExtra("srekanan", rekanan);
//            i.putExtra("sket", ket);
//            i.putExtra("scr_at", cr_at);
//            i.putExtra("scr_by", cr_by);
//            i.putExtra("sversi", versi);
//            i.putExtra("slokasi", lokasi);
//
//            context.startActivity(i);
//        }


    }


}