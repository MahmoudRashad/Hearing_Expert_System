package com.hearing.hearingsys.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.QuickContactBadge;
import android.widget.TextView;


import com.hearing.hearingsys.Fragment.MainFragments.Import_Export;
import com.hearing.hearingsys.Fragment.MainFragments.Main_menu;
import com.hearing.hearingsys.Fragment.MainFragments.Select_Patient_History;
import com.hearing.hearingsys.Fragment.MainFragments.Start_Test;
import com.hearing.hearingsys.R;


public class HomeActivity extends AppCompatActivity {

    public static boolean Patient_His_Fragment=false ,Test_Fragment=false, IM_Ex_Fragment =false,main_menu_Fragment=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        if (Patient_His_Fragment) {
            callfragment(new Select_Patient_History());
        }
        if (main_menu_Fragment) {
            callfragment(new Main_menu());
        }

        if (Test_Fragment) {
            callfragment(new Start_Test());
        }

        if (IM_Ex_Fragment) {
            callfragment(new Import_Export());
        }


    }

    private void callfragment(Main_menu main_menu) {
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentView, main_menu).commit();
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
