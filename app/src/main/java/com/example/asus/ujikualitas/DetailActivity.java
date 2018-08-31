package com.example.asus.ujikualitas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DetailActivity extends AppCompatActivity {

    String iId;
    String itrs;
    String itgltrs;
    String iobyek;
    String iket;
    String icr_at;
    String ilokakasi;
    String irekanan;
    String iversi;
    String icr_by;

    private static final String TAG = "GalleryActivity";

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Log.d(TAG, "onCreate: started.");
        getIncomingIntent();

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });





    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("sendID") && getIntent().hasExtra("sendTRS")&& getIntent().hasExtra("sendtgl_trs")
                && getIntent().hasExtra("sendobyek") && getIntent().hasExtra("sendket")
                && getIntent().hasExtra("sendcr_at") && getIntent().hasExtra("sendlokasi")
                && getIntent().hasExtra("sendrekanan") && getIntent().hasExtra("sendcr_by") && getIntent().hasExtra("sendversi") ){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            iId = getIntent().getStringExtra("sendID");
            itrs = getIntent().getStringExtra("sendTRS");
            itgltrs = getIntent().getStringExtra("sendtgl_trs");
            iobyek = getIntent().getStringExtra("sendobyek");
            iket = getIntent().getStringExtra("sendket");
            icr_at = getIntent().getStringExtra("sendcr_at");
            ilokakasi = getIntent().getStringExtra("sendlokasi");
            irekanan = getIntent().getStringExtra("sendrekanan");
            icr_by = getIntent().getStringExtra("sendcr_by");
            iversi = getIntent().getStringExtra("sendversi");
//            itgltrs,

            setImage(iId, itrs, itgltrs, iobyek,iket, icr_at, ilokakasi, irekanan, icr_by, iversi );
        }
    }

    private void setImage(String iId, String itrs, String itgltrs, String iobyek, String iket, String icr_at, String ilokakasi, String irekanan, String icr_by, String iversi){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView dataid = findViewById(R.id.txtID);
        dataid.setText(iId);

        TextView datatrs = findViewById(R.id.txtNoTrs);
        datatrs.setText(itrs);

        TextView datatgltrs = findViewById(R.id.txtTglPeng);
        datatgltrs.setText(itgltrs);

        TextView dataobyek = findViewById(R.id.txtObyek);
        dataobyek.setText(iobyek);

        TextView dataket = findViewById(R.id.txtKet);
        dataket.setText(iket);

        TextView datacr_at = findViewById(R.id.txtTglPem);
        datacr_at.setText(icr_at);

        TextView datalokakasi = findViewById(R.id.txtLokasi);
        datalokakasi.setText(ilokakasi);

        TextView datarekanan = findViewById(R.id.txtRekanan);
        datarekanan.setText(irekanan);

        TextView datacr_by = findViewById(R.id.txtBy);
        datacr_by.setText(icr_by);

        TextView dataversi = findViewById(R.id.txtVersi);
        dataversi.setText(iversi);


//        ImageView image = findViewById(R.id.image);
//        Glide.with(this)
//                .asBitmap()
//                .load(imageUrl)
//                .into(image);
    }

    public void EditData(View view) {
        Intent intent = new Intent(this, UpdateDataActivity.class);
        intent.putExtra("id", iId);
        intent.putExtra("trs", itrs);
        intent.putExtra("tgltrs", itgltrs);
        intent.putExtra("ket", iket);
        intent.putExtra("crat", icr_at);
        intent.putExtra("lok", ilokakasi);
        intent.putExtra("oby", iobyek);
        intent.putExtra("rek", irekanan);
        intent.putExtra("ver", iversi);
        intent.putExtra("crby", icr_by);

        startActivity(intent);

    }

    public void EditParam(View view) {
        Intent intent = new Intent(this, UpdateParamActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
//        loadData();
    }



}
