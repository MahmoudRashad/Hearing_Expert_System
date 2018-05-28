package com.hearing.hearingsys.Fragment.MainFragments;

import android.Manifest;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.hearing.hearingsys.Adopters.Question_adopter;
import com.hearing.hearingsys.AppContext;
import com.hearing.hearingsys.R;
import com.hearing.hearingsys.model.Image;
import com.hearing.hearingsys.model.Qustion_model;
import com.hearing.hearingsys.model.SIGNAL;
import com.hearing.hearingsys.model.noise;

import java.util.ArrayList;

import static com.hearing.hearingsys.AppContext.Curr_question;

public class Question_Fragment extends Fragment {



    private View view;
    Button replay_btn,close ;
    TextView question_TV;
    GridView images_GV;

    SoundPool signal_sp,noise_sp ;
    int signal_flag,noise_flag ;


    int Qusetion_id ;
    private int file_req_code=676;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_question, container, false);


        get_permation ();

        //remove after test
        init_curr_question ();





        init();
        Clicks();



        return view;
    }

    private void get_permation() {

        ActivityCompat.requestPermissions(getActivity(),
                new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                },file_req_code);

    }

    private void init_curr_question() {
        SIGNAL signal= new SIGNAL("1","الولد يلعب الكره ","1","1");

        Curr_question = new Qustion_model(signal,noise.Fixed_pattern_noise);
        ArrayList<Image>images= new ArrayList<>();
        for (int i =1 ; i<10 ; i++)
        {
            Image image = new Image(""+i, "/Music/");
            images.add(image);
        }
        Curr_question.setChoices(images);
        Curr_question.setCorr_img_id(1);

    }



    private void Clicks() {
        replay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play_Qustion();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signal_sp.autoPause();
                noise_sp.autoPause();
                noise_sp.release();
                signal_sp.release();


                finish_test();
            }
        });

    }

    private void play_Qustion() {
        init_sound_pool();
    }

    private void finish_test() {
        getActivity().finish();
        // TODO update context
        //TODO Save status
       //TODO  finish test
       //TODO call test result

    }

    private void init() {
        replay_btn=view.findViewById(R.id.replay_btn);
        close= view.findViewById(R.id.close_btn) ;
        question_TV= view.findViewById(R.id.question_TV) ;
        images_GV= view.findViewById(R.id.images_GV) ;

        if (Curr_question!=null)
        {
            question_TV.setText(Curr_question.getSignal().getSIGNALS_TEXT());
            Question_adopter question_adopter= new Question_adopter(getActivity(),Curr_question.getChoices());
            images_GV.setAdapter(question_adopter);
            init_sound_pool();


        }

    }

    private void init_sound_pool() {


        signal_sp = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        noise_sp = new SoundPool(1, AudioManager.STREAM_MUSIC,1);

        signal_flag=signal_sp.load(Environment.getExternalStorageDirectory().getPath()+"/Music/maine.mp3",1);
//        noise_flag=noise_sp.load(Environment.getExternalStorageDirectory().getPath()+"/Music/maine.mp3",1);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
//                if (signal_flag==1&&noise_flag==1) {
                    signal_sp.play(signal_flag, (float) 0.5, (float) 0.5, 1, 0, 1);
//                    noise_sp.play(noise_flag, (float) 0.5, (float)0.5, 1, -1, 1);
//                }
            }
        }, 1000);








    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
