package com.hearing.hearingsys.Fragment.MainFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.hearing.hearingsys.AppContext;
import com.hearing.hearingsys.Dialogs.MYDialg;
import com.hearing.hearingsys.R;
import com.hearing.hearingsys.Sql.DatabaseHelper;
import com.hearing.hearingsys.model.Image;
import com.hearing.hearingsys.model.Qustion_model;
import com.hearing.hearingsys.model.SIGNAL;
import com.hearing.hearingsys.model.noise;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static com.hearing.hearingsys.AppContext.Curr_question;
import static com.hearing.hearingsys.AppContext.databaseHelper;


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
        MYDialg question= new MYDialg(getActivity(),
                getString(R.string.scenario_Question_title),
                getString(R.string.scenario_Question_msg),
                getString(R.string.scenario_Question_pos),
                getString(R.string.scenario_Question_neg)
        );
        question.show_dialog(new MYDialg.result() {
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
        //ask for patint
        final MYDialg question= new MYDialg(getActivity(),
                getString(R.string.check_P_title),
                getString(R.string.check_P_msg),
                getString(R.string.check_P_pos),//Old Patient
                getString(R.string.check_P_neg)//new Patient
        );
        question.show_dialog(new MYDialg.result() {
            @Override
            public void on_pos_btn() {

                //TODO load patient from database

                question.get_text(new MYDialg.text_interface() {
                    @Override
                    public void on_text_enter(String text) {

                        AppContext.Patient_Information= databaseHelper.load_patint_by (text).get(0);
                        if ( AppContext.Mode== AppContext.mode_Type.complete)
                        {
                            load_level(1);
                        }
                        else {
                            //get level id
                            question.get_text(new MYDialg.text_interface() {
                                @Override
                                public void on_text_enter(String text) {
                                    AppContext.Curr_level_id= Integer.parseInt(text);
                                    load_level(Integer.parseInt(text));

                                }
                            },getActivity().getString(R.string.chooseLevel));
                        }

                    }
                },getActivity().getString(R.string.patient_id));


            }

            @Override
            public void on_neg_btn() {
                //TODO add new  patient

                callfragment(new New_Patint());


            }
        });
    }

    private   void load_level(int j) {


        AppContext.Curr_level_id=j;
        String [] s_text= new String[]{ "الولد يلعب بالكره "
                , "ارنب ياكل جزره "
                ,"البنت تسرح شعرها"
                ,"الفرخه باضت بيضه"
                ,"القطه تلعب بالكره"
                ,"الدب ياكل عسل"
                ,"الكلب يشرب مياه"
                ,"الزرافه رقبتها طويله"
                ,"الفيل حجمه كبير "
                ,"الفيل يلعب بالكره"
        };
//        noise noise = new noise(1,"\"/hearingsystem/noise/Brown_Noise.mp3\"","Brown_Noise");
        noise noise = AppContext.databaseHelper.select_noise_by_level(j).get(0);
        for (int i = 1;i<11;i++){
            SIGNAL signal=new SIGNAL(""+i,s_text[i-1],""+j,""+i);


            Qustion_model qustion_model= new Qustion_model(signal,noise);


            ArrayList<Image> images= new ArrayList<>();
            for (int k =1 ; k<10 ; k++)
            {
                Image image = new Image(""+k, "/hearingsystem/level"+j+"/imgs/");
                images.add(image);
            }
            qustion_model.setChoices(images);
            qustion_model.setCorr_img_id(i);
            AppContext.Curr_Test_Questions.add(qustion_model);
        }

        AppContext.Curr_question=  AppContext.Curr_Test_Questions.get(0);


        callfragment(new Question_Fragment());
    }

    private void  callfragment(Question_Fragment question_fragment) {
        getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentView, question_fragment).commit();
    }
    private void callfragment(New_Patint new_patint) {
        getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentView, new_patint).commit();
    }

}
