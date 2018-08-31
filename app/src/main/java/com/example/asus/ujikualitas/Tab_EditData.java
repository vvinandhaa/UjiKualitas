package com.example.asus.ujikualitas;

/**
 * Created by ASUS on 07/08/2018.
 */
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Tab_EditData extends android.support.v4.app.Fragment {

    DatePickerDialog picker;
    EditText eText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.xml_editdata, container, false);
        return rootView;


    }


}
