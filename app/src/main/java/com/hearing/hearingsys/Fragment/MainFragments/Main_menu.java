package com.hearing.hearingsys.Fragment.MainFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hearing.hearingsys.R;

public class Main_menu  extends Fragment {

    private View view;
    TextView Patient_His_Fragment_tx,Test_Fragment_tx, IM_Ex_Fragment_tx ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_main_menu, container, false);

        init();
        clicks();
        callserver();


        return view;
    }

    private void callserver() {

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

        Patient_His_Fragment_tx=view.findViewById(R.id.first_marker) ;
        Test_Fragment_tx=view.findViewById(R.id.sec_marker) ;
        IM_Ex_Fragment_tx =view.findViewById(R.id.third_marker) ;
    }
    private void callfragment(Select_Patient_History select_patient_history) {
        getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentView, select_patient_history).commit();
    }
    private void callfragment( Start_Test start_test) {
        getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentView, start_test).commit();
    }
    private void callfragment(Import_Export import_export) {
        getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentView, import_export).commit();
    }
}