package com.hearing.hearingsys.Fragment.MainFragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


import com.hearing.hearingsys.R;
import com.hearing.hearingsys.Sql.DatabaseHelper;
import com.hearing.hearingsys.model.Patient_List_Adapter;
import com.hearing.hearingsys.model.Patient_Test_Data;

import java.util.ArrayList;

import static com.hearing.hearingsys.Sql.DatabaseHelper.COLUMN_PATIENT_ID;
import static com.hearing.hearingsys.Sql.DatabaseHelper.COLUMN_PATIENT_NAME;
import static com.hearing.hearingsys.Sql.DatabaseHelper.COLUMN_TEST_PATIENT_ID;
import static com.hearing.hearingsys.Sql.DatabaseHelper.TABLE_PATIENT;
import static com.hearing.hearingsys.Sql.DatabaseHelper.TABLE_TEST;


/**
 * Created by Ahmed on 5/17/2018.
 */

public class Select_Patient_History extends Fragment {
    View view;

    EditText Patient_name;
    ImageView Search;
    ListView Patient_Information;
    ArrayList<Patient_Test_Data> patient_data;
    DatabaseHelper db;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.get_patient_history, container, false);
        init();
        Clicks();
        callserver("");

        return view;
    }

    private void callserver(String name ) {
        ///todo get data from database
        patient_data.clear();

        if (Patient_name.getText().toString()!=null){
            db=new DatabaseHelper(getActivity());
//            String selectpatientquery="SELECT * FROM "+TABLE_PATIENT +" WHERE "+COLUMN_PATIENT_NAME+" = '"+Patient_name.getText().toString()+"';";
           String selecttests_of_pation  = "SELECT * FROM "+TABLE_PATIENT +" p, " +TABLE_TEST+
                   " t where p."+COLUMN_PATIENT_ID+" = t."+COLUMN_TEST_PATIENT_ID+" and " +
                   " p."+COLUMN_PATIENT_NAME+
                   " LIKE  '%"+name+"%';";
           Cursor cursor= db.select(selecttests_of_pation);
//            JSONObject a =data;
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {


                        String[] columnNames = cursor.getColumnNames();
                        Patient_Test_Data tmp =new Patient_Test_Data();
                        for (String columnName : columnNames) {
                            switch (columnName){
                                case "patient_id":
                                    tmp.setP_ID(Integer.parseInt(cursor.getString(cursor.getColumnIndex(columnName))));
                                    break;
                                case "patient_name":
                                    tmp.setP_name(cursor.getString(cursor.getColumnIndex(columnName)));
                                    break;
                                case "patient_age":
                                    tmp.setP_age((cursor.getString(cursor.getColumnIndex(columnName))));
                                    break;
                                case "mender_doctor":
                                    tmp.setDr_name((cursor.getString(cursor.getColumnIndex(columnName))));
                                    break;
                                case "noise_type":
                                    tmp.setNoise_type((cursor.getString(cursor.getColumnIndex(columnName))));
                                    break;
                                case "patient_degree":
                                    tmp.setTest_Degree((cursor.getString(cursor.getColumnIndex(columnName))));
                                    break;
                            }
                        }
                        patient_data.add(tmp);
                    } while (cursor.moveToNext());
                }
            }

            Patient_List_Adapter adapter = new Patient_List_Adapter(getActivity(), patient_data);
            Patient_Information.setAdapter(adapter);

        }
    }

    private void Clicks() {
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Searsh_fn( Patient_name.getText().toString().toLowerCase());
            }
        });
        Patient_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Searsh_fn( s.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void Searsh_fn(String text) {
        if (Patient_name.getText().toString()==null){
            Patient_name.setError("Please Enter Patient Name");
//            Toast.makeText(getActivity(), "Please Enter Patient Name", Toast.LENGTH_SHORT).show();
        }else {
            callserver(text);
        }

    }


    private void init() {


        View header = getLayoutInflater().inflate(R.layout.patient_list_header, null);

        Patient_name=view.findViewById(R.id.Patient_Name);
        Search=view.findViewById(R.id.Search_btn);
        Patient_Information=view.findViewById(R.id.Patients_List);
        Patient_Information.addHeaderView(header);

        patient_data =new ArrayList<>();


    }
}
