package com.hearing.hearingsys;


import com.hearing.hearingsys.Sql.DatabaseHelper;
import com.hearing.hearingsys.model.Doctor;
import com.hearing.hearingsys.model.Patient_Information;
import com.hearing.hearingsys.model.Qustion_model;
import com.hearing.hearingsys.model.Test;

import java.util.ArrayList;

/**
 * Created by Ahmed on 5/26/2018.
 */

public class AppContext {

    public static mode_Type Mode;
    public static DatabaseHelper databaseHelper;
    public static Patient_Information Patient;
    public static Test Testd;
    public static Doctor Doctor;
    public static ArrayList<Qustion_model> Curr_Test_Questions= new ArrayList<>();

    public static Qustion_model Curr_question ;
    public static Patient_Information Patient_Information ;
    public static int Curr_level_id;
    public static int Curr_level_score=0;


    public static enum mode_Type{
    complete, custom
}


}
