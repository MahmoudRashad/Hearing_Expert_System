package com.hearing.hearingsys;

import com.example.ahmed.hearingexpretsystem.model.Test;
import com.hearing.hearingsys.model.Doctor;
import com.hearing.hearingsys.model.Patient_Information;

/**
 * Created by Ahmed on 5/26/2018.
 */

public class AppContext {

    public static mode_Type Mode;
    public static Patient_Information Patient;
    public static Test Testd;
    public static Doctor Test;

    public static enum mode_Type{
    complete, custom
}


}
