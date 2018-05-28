package com.hearing.hearingsys.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.QuickContactBadge;
import android.widget.TextView;


import com.hearing.hearingsys.Fragment.MainFragments.Import_Export;
import com.hearing.hearingsys.Fragment.MainFragments.Select_Patient_History;
import com.hearing.hearingsys.Fragment.MainFragments.Start_Test;
import com.hearing.hearingsys.R;


public class HomeActivity extends AppCompatActivity {

    public static boolean Patient_His_Fragment=false ,Test_Fragment=false, IM_Ex_Fragment =false;
    TextView Patient_His_Fragment_tx,Test_Fragment_tx, IM_Ex_Fragment_tx ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        clicks();

        if (Patient_His_Fragment) {
            callfragment(new Select_Patient_History());
        }

        if (Test_Fragment) {
            callfragment(new Start_Test());
        }

        if (IM_Ex_Fragment) {
            callfragment(new Import_Export());
        }


    }

    private void clicks() {
        Patient_His_Fragment_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callfragment(new Select_Patient_History());
            }
        });
        Test_Fragment_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callfragment(new Start_Test());
            }
        });
        IM_Ex_Fragment_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callfragment(new Import_Export());
            }
        });
    }

    private void init() {

        Patient_His_Fragment_tx=findViewById(R.id.first_marker) ;
        Test_Fragment_tx=findViewById(R.id.sec_marker) ;
        IM_Ex_Fragment_tx =findViewById(R.id.third_marker) ;
    }
    private void callfragment(Select_Patient_History select_patient_history) {
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentView, select_patient_history).commit();
    }
    private void callfragment( Start_Test start_test) {
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentView, start_test).commit();
    }
    private void callfragment(Import_Export import_export) {
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentView, import_export).commit();
    }
}
