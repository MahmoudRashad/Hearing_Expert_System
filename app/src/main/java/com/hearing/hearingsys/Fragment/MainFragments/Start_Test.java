package com.hearing.hearingsys.Fragment.MainFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.hearing.hearingsys.AppContext;
import com.hearing.hearingsys.Dialogs.Question;
import com.hearing.hearingsys.R;


/**
 * Created by Ahmed on 5/17/2018.
 */

public class Start_Test extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_test, container, false);

        init();
        Clicks();
        callserver();


        return view;
    }

    private void callserver() {

    }

    private void Clicks() {

    }

    private void init() {

        setconfig();
    }

    private void setconfig() {
        Question question= new Question(getActivity(),
                getString(R.string.scenario_Question_title),
                getString(R.string.scenario_Question_msg),
                getString(R.string.scenario_Question_pos),
                getString(R.string.scenario_Question_neg)
        );
        question.show_dialog(new Question.result() {
            @Override
            public void on_pos_btn() {
                AppContext.Mode= AppContext.mode_Type.complete;
                get_P_info();
            }

            @Override
            public void on_neg_btn() {
                AppContext.Mode= AppContext.mode_Type.custom;
                get_P_info();
            }
        });
    }

    public  void get_P_info(){
        Question question= new Question(getActivity(),
                getString(R.string.check_P_title),
                getString(R.string.check_P_msg),
                getString(R.string.check_P_pos),
                getString(R.string.check_P_neg)
        );
        question.show_dialog(new Question.result() {
            @Override
            public void on_pos_btn() {
                get_P_info();
            }

            @Override
            public void on_neg_btn() {
                get_P_info();
            }
        });
    }


}
