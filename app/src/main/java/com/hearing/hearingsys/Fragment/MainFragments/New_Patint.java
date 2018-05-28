package com.hearing.hearingsys.Fragment.MainFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hearing.hearingsys.R;

public class New_Patint  extends Fragment {

    private View view;
    EditText Name_ET,Age_ET,Phone_ET;
    Button add_new_patint_Btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_new_patint, container, false);

        init();
        Clicks();
        callserver();


        return view;
    }

    private void callserver() {

    }

    private void Clicks() {

        add_new_patint_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validation()){

                }
            }
        });
    }

    private boolean Validation() {
        if(Name_ET.getText().toString().length() < 1)
        {
            Name_ET.setError(getString(R.string.required));
            return false;
        }

        if(Age_ET.getText().toString().length() < 1)
        {
            Age_ET.setError(getString(R.string.required));
            return false;
        }

        if(Phone_ET.getText().toString().length() < 1)
        {
            Phone_ET.setError(getString(R.string.required));
            return false;
        }
        return true;
    }

    private void init() {
        Name_ET= view.findViewById(R.id.Name_ET);
        Age_ET= view.findViewById(R.id.age_ET);
        Phone_ET= view.findViewById(R.id.Phone_ET);
        add_new_patint_Btn= view.findViewById(R.id.add_new_patint_Btn);

    }
}