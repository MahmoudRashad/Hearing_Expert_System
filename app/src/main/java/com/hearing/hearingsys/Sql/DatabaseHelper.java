package com.hearing.hearingsys.Sql;

/**
 * Created by Ahmed on 5/10/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.hearing.hearingsys.model.Doctor;
import com.hearing.hearingsys.model.Patient_Information;
import com.hearing.hearingsys.model.noise;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

//    public DatabaseHelper context=DatabaseHelper.this;

    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "Hearing_Database";

    // DOCTOR table name
    public static final String TABLE_DOCTOR = "doctor";


    // DOCTOR Table Columns names
    public static final String COLUMN_DOCTOR_ID = "doctor_id";
    public static final String COLUMN_DOCTOR_NAME = "doctor_name";
    public static final String COLUMN_DOCTOR_EMAIL = "doctor_email";
    public static final String COLUMN_DOCTOR_PASSWORD = "doctor_password";

    // create table DOCTOR
    public String CREATE_DOCTOR_TABLE = "CREATE TABLE " + TABLE_DOCTOR + "("
            + COLUMN_DOCTOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_DOCTOR_NAME + " TEXT,"
            + COLUMN_DOCTOR_EMAIL + " TEXT," + COLUMN_DOCTOR_PASSWORD + " TEXT" + ")";

    // drop table sql query DOCTOR
    public String DROP_DOCTOR_TABLE = "DROP TABLE IF EXISTS " + TABLE_DOCTOR;





    // Patient table Patient
    public static final String TABLE_PATIENT = "patient";

    // patient Table Columns names
    public static final String COLUMN_PATIENT_ID = "patient_id";
    public static final String COLUMN_PATIENT_NAME = "patient_name";
    public static final String COLUMN_PATIENT_AGE = "patient_age";
    public static final String COLUMN_MENDER_DOCTOR = "mender_doctor";
    public static final String COLUMN_PHONE = "PHONE";

    // create table patient
    public String  CREATE_Patient_TABLE = "CREATE TABLE " + TABLE_PATIENT + "("
            + COLUMN_PATIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_PATIENT_NAME + " TEXT,"
            + COLUMN_PATIENT_AGE + " INTEGER," + COLUMN_MENDER_DOCTOR + " TEXT,"  + COLUMN_PHONE + " TEXT" + ")";

    // drop table sql query
    public String DROP_PATIENT_TABLE = "DROP TABLE IF EXISTS " + TABLE_PATIENT;




    // test table name
    public static final String TABLE_TEST = "test";

    // patient Table Columns names
    public static final String COLUMN_TEST_ID = "test_id";
    public static final String COLUMN_TEST_PATIENT_ID = "patient_id";
    public static final String COLUMN_TEST_DOCTOR_ID = "doctor_id";
    public static final String COLUMN_TETS_NOISE_TYPE = "noise_type";
    public static final String COLUMN_TETS_PATIENT_DEGREE = "patient_degree";

    // create table patient
    public String CREATE_TEST_TABLE = "CREATE TABLE " + TABLE_TEST + "("
            + COLUMN_TEST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_TEST_PATIENT_ID + " INTEGER,"
            + COLUMN_TEST_DOCTOR_ID + " INTEGER," +COLUMN_TETS_PATIENT_DEGREE + " TEXT," + COLUMN_TETS_NOISE_TYPE + " TEXT" + ")";

    // drop table sql query
    public String DROP_TEST_TABLE = "DROP TABLE IF EXISTS " + TABLE_TEST;




    // test table Signals
    public static final String TABLE_SIGNALS = "signals";

    // patient Table Columns names
    public static final String COLUMN_SIGNALS_ID = "signals_id";
    public static final String COLUMN_SIGNALS_TEXT = "signals_text";
    public static final String COLUMN_SIGNALS_TEST_ID = "signals_test_id";
    public static final String COLUMN_SIGNALS_IMAGE_ID = "signals_Image_id";


    // create table patient
    public String CREATE_SIGNALS_TABLE = "CREATE TABLE " + TABLE_SIGNALS + "("
            + COLUMN_SIGNALS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_SIGNALS_TEXT + " TEXT," + COLUMN_SIGNALS_TEST_ID + " INTEGER ," +COLUMN_SIGNALS_IMAGE_ID + " INTEGER " + ");";

    // drop table sql query
    public String DROP_SIGNALS_TABLE = "DROP TABLE IF EXISTS " + TABLE_SIGNALS;





    // test table imaged
    public static final String TABLE_IMAGES = "images";

    // patient Table Columns names
    public static final String COLUMN_IMAGES_ID = "images_id";
    public static final String COLUMN_IMAGES_PATH = "IMAGES_PATH";
    public static final String COLUMN_IMAGES_TEST_ID = "IMAGES_TEST_ID";
    public static final String COLUMN_IMAGES_QUESTION_ID = "IMAGES_QUESTION_ID";


    // create table patient
    public String CREATE_IMAGES_TABLE = "CREATE TABLE " + TABLE_IMAGES + "("
            + COLUMN_IMAGES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_IMAGES_PATH + " TEXT,"
            + COLUMN_IMAGES_TEST_ID + " INTEGER,"  + COLUMN_IMAGES_QUESTION_ID + " INTEGER" + ");";

    // drop table sql query
    public String DROP_IMAGES_TABLE = "DROP TABLE IF EXISTS " + TABLE_IMAGES;

    // NOISE_TABLE
    public static final String NOISE_TABLE = "NOISE_TABLE";

    // patient Table Columns names
    public static final String COLUMN_NOISE_ID = "NOISE_ID";
    public static final String COLUMN_NOISE_NAME = "NOISE_NAME";
    public static final String COLUMN_NOISE_TEST_ID = "NOISE_TEST_ID";



    // create table patient
    public String CREATE_NOISE_TABLE = "CREATE TABLE " + NOISE_TABLE + "("
            + COLUMN_NOISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NOISE_NAME + " TEXT, "
            + COLUMN_NOISE_TEST_ID + " INTEGER"  + ");";

    // drop table sql query
    public String DROP_NOISE_TABLE = "DROP TABLE IF EXISTS " + NOISE_TABLE;




    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        instance=new DatabaseHelper(context);
    }

    public static DatabaseHelper singleton;



    public static DatabaseHelper init(Context context) {

            singleton= new DatabaseHelper(context);
            return  singleton;

    }

    public static DatabaseHelper getInstance()   {

        return singleton;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DOCTOR_TABLE);
        db.execSQL(CREATE_Patient_TABLE);
        db.execSQL(CREATE_TEST_TABLE);
        db.execSQL(CREATE_SIGNALS_TABLE);
        db.execSQL(CREATE_IMAGES_TABLE);
        db.execSQL(CREATE_NOISE_TABLE);





        db.execSQL("INSERT INTO " + NOISE_TABLE + " VALUES (1,'Brown_Noise',1);");
        db.execSQL("INSERT INTO " + NOISE_TABLE + " VALUES (2,'Brown_Noise',2);");
        db.execSQL("INSERT INTO " + NOISE_TABLE + " VALUES (3,'Brown_Noise',3);");





        db.execSQL("INSERT INTO " + TABLE_SIGNALS + " VALUES (1, ' الولد يلعب بالكره ',1,1 );");
        db.execSQL("INSERT INTO " + TABLE_SIGNALS + " VALUES (2, 'ارنب ياكل جزره',1,2 );");
        db.execSQL("INSERT INTO " + TABLE_SIGNALS + " VALUES (3, 'البنت تسرح شعرها',1,3 );");
        db.execSQL("INSERT INTO " + TABLE_SIGNALS + " VALUES (4, 'الفرخه باضت بيضه',1,4 );");
        db.execSQL("INSERT INTO " + TABLE_SIGNALS + " VALUES (5, 'القطه تلعب بالكره',1,5 );");
        db.execSQL("INSERT INTO " + TABLE_SIGNALS + " VALUES (6, 'الدب ياكل عسل',1,6 );");
        db.execSQL("INSERT INTO " + TABLE_SIGNALS + " VALUES (7, 'الكلب يشرب مياه',1,7 );");
        db.execSQL("INSERT INTO " + TABLE_SIGNALS + " VALUES (8, 'الزرافه رقبتها طويله',1,8 );");
        db.execSQL("INSERT INTO " + TABLE_SIGNALS + " VALUES (9, 'الفيل حجمه كبير',1,9 );");
        db.execSQL("INSERT INTO " + TABLE_SIGNALS + " VALUES (10, 'الفيل يلعب بالكره',1,10 );");





        db.execSQL("INSERT INTO " + TABLE_IMAGES + " VALUES (1, 'path',1,1 );");
        db.execSQL("INSERT INTO " + TABLE_IMAGES + " VALUES (2, 'path',1,2 );");
        db.execSQL("INSERT INTO " + TABLE_IMAGES + " VALUES (3, 'path',1,3 );");
        db.execSQL("INSERT INTO " + TABLE_IMAGES + " VALUES (4, 'path',1,4 );");
        db.execSQL("INSERT INTO " + TABLE_IMAGES + " VALUES (5, 'path',1,5 );");
        db.execSQL("INSERT INTO " + TABLE_IMAGES + " VALUES (6, 'path',1,6 );");
        db.execSQL("INSERT INTO " + TABLE_IMAGES + " VALUES (7, 'path',1,7 );");
        db.execSQL("INSERT INTO " + TABLE_IMAGES + " VALUES (8, 'path',1,8 );");
        db.execSQL("INSERT INTO " + TABLE_IMAGES + " VALUES (9, 'path',1,9 );");
        db.execSQL("INSERT INTO " + TABLE_IMAGES + " VALUES (10, 'path',1,10 );");




        db.execSQL("INSERT INTO " + TABLE_TEST + " VALUES (1, 1 , 1 ,'70%', 'cafa' );");
        db.execSQL("INSERT INTO " + TABLE_TEST + " VALUES (2, 1 , 1 ,'60%', 'cafa' );");
        db.execSQL("INSERT INTO " + TABLE_TEST + " VALUES (3, 1 , 1 ,'50%', 'cafa' );");
        db.execSQL("INSERT INTO " + TABLE_TEST + " VALUES (4, 1 , 1 ,'100%', 'cafa' );");
        db.execSQL("INSERT INTO " + TABLE_TEST + " VALUES (5, 2 , 1 ,'70%', 'cafa' );");
        db.execSQL("INSERT INTO " + TABLE_TEST + " VALUES (6, 3 , 1 ,'70%', 'cafa' );");
        db.execSQL("INSERT INTO " + TABLE_TEST + " VALUES (7, 4 , 1 ,'70%', 'cafa' );");
        db.execSQL("INSERT INTO " + TABLE_TEST + " VALUES (8, 4 , 1 ,'70%', 'cafa' );");



        db.execSQL("INSERT INTO " + TABLE_DOCTOR + " VALUES (1, 'reham', 'reham@app.com', '123' );");


        db.execSQL("INSERT INTO " + TABLE_PATIENT + " VALUES (1, 'ali1', 6, '6ahmed','0253513676 ');");
        db.execSQL("INSERT INTO " + TABLE_PATIENT + " VALUES (2, 'ahmed', 9, '8ahmed','01253513676' );");
        db.execSQL("INSERT INTO " + TABLE_PATIENT + " VALUES (3, 'ali3', 4, '5ahmed','01553513676' );");
        db.execSQL("INSERT INTO " + TABLE_PATIENT + " VALUES (4, 'mahmoud4', 9, '5ahmed','01253513676' );");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop Doctor Table if exist
        db.execSQL(DROP_DOCTOR_TABLE);
        db.execSQL(DROP_PATIENT_TABLE);
        db.execSQL(DROP_TEST_TABLE);
        db.execSQL(DROP_SIGNALS_TABLE);
        db.execSQL(DROP_IMAGES_TABLE);
        db.execSQL(CREATE_NOISE_TABLE);
        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create doctor record
     *
     * @param doctor
     */
    public void addUser(Doctor doctor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DOCTOR_NAME, doctor.getName());
        values.put(COLUMN_DOCTOR_EMAIL, doctor.getEmail());
        values.put(COLUMN_DOCTOR_PASSWORD, doctor.getPassword());

        // Inserting Row
        long v =db.insert(TABLE_DOCTOR, null, values);
        db.close();
    }

    /**
     * This method is to fetch all DOCTOR and return the list of DOCTOR records
     *
     * @return list
     */
    public List<Doctor> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_DOCTOR_ID,
                COLUMN_DOCTOR_EMAIL,
                COLUMN_DOCTOR_NAME,
                COLUMN_DOCTOR_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_DOCTOR_NAME + " ASC";
        List<Doctor> doctorList = new ArrayList<Doctor>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_DOCTOR, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Doctor doctor = new Doctor();
                doctor.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_DOCTOR_ID))));
                doctor.setName(cursor.getString(cursor.getColumnIndex(COLUMN_DOCTOR_NAME)));
                doctor.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_DOCTOR_EMAIL)));
                doctor.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_DOCTOR_PASSWORD)));
                // Adding doctor record to list
                doctorList.add(doctor);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return doctorList;
    }

    /**
     * This method to update doctor record
     *
     * @param doctor
     */
    public void updateUser(Doctor doctor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DOCTOR_NAME, doctor.getName());
        values.put(COLUMN_DOCTOR_EMAIL, doctor.getEmail());
        values.put(COLUMN_DOCTOR_PASSWORD, doctor.getPassword());

        // updating row
        db.update(TABLE_DOCTOR, values, COLUMN_DOCTOR_ID + " = ?",
                new String[]{String.valueOf(doctor.getId())});
        db.close();
    }

    /**
     * This method is to delete doctor record
     *
     * @param doctor
     */
    public void deleteUser(Doctor doctor) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete doctor record by id
        db.delete(TABLE_DOCTOR, COLUMN_DOCTOR_ID + " = ?",
                new String[]{String.valueOf(doctor.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_DOCTOR_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_DOCTOR_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_DOCTOR, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param name
     * @param password
     * @return true/false
     */
    public boolean checkUser(String name, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_DOCTOR_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_DOCTOR_NAME+ " = ?" + " AND " + COLUMN_DOCTOR_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {name, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_DOCTOR, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


    public Cursor select(String queryString) {

            SQLiteDatabase database = this.getReadableDatabase();

//            JSONObject Patient1 = new JSONObject();
//
//            List<Object> list = new ArrayList<Object>();
            Cursor cursor = database.rawQuery(queryString, null);

//            if (cursor != null) {
//                if (cursor.moveToFirst()) {
//                    do {
//                        ContentValues content = new ContentValues();
//                        String[] columnNames = cursor.getColumnNames();
//                        for (String columnName : columnNames) {
//                            content.put(columnName, cursor.getString(cursor
//                                    .getColumnIndex(columnName)));
//                        }
//                        list.add(content);
//                    } while (cursor.moveToNext());
//                }
//            }
            try {
//                cursor.close();

            }catch (Exception e){
                Log.d("select_exception", e.getMessage());
                e.printStackTrace();
            }
            try {
//                database.close();

            }catch (Exception e)
            {
                Log.d( "close  database ",e.getMessage());
                e.printStackTrace();
            }
            return cursor;


    }


    public  ArrayList<Patient_Information> load_patint_by(String id) {
        String Quary ="select * from "+TABLE_PATIENT+" where "+ COLUMN_PATIENT_ID+" = '"+id+"';";
        ArrayList<Patient_Information> list= new ArrayList<>();
        Cursor cursor=select(Quary);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String[] columnNames = cursor.getColumnNames();
                    Patient_Information tmp =new Patient_Information();
                    for (String columnName : columnNames) {
                        switch (columnName){
                            case COLUMN_PATIENT_ID :
                                tmp.setPatient_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(columnName))));
                                break;
                            case COLUMN_PATIENT_NAME:
                                tmp.setPatient_name(cursor.getString(cursor.getColumnIndex(columnName)));
                                break;
                            case COLUMN_PATIENT_AGE:
                                tmp.setPatient_age((cursor.getString(cursor.getColumnIndex(columnName))));
                                break;
                            case COLUMN_MENDER_DOCTOR:
                                tmp.setMender_doctor((cursor.getString(cursor.getColumnIndex(columnName))));
                                break;
                            case COLUMN_PHONE:
                                tmp.setPHONE((cursor.getString(cursor.getColumnIndex(columnName))));
                                break;
                        }
                    }
                    list.add(tmp);
                } while (cursor.moveToNext());

            }
            return list;

        }
        return null;
    }

    public  ArrayList<noise> select_noise_by_level(int id) {
        String Quary ="select * from "+NOISE_TABLE+" where "+ COLUMN_NOISE_TEST_ID +" = "+id+";";
        ArrayList<noise> list= new ArrayList<>();
        Cursor cursor=select(Quary);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String[] columnNames = cursor.getColumnNames();
                    noise tmp =new noise();
                    for (String columnName : columnNames) {
                        switch (columnName){
                            case COLUMN_NOISE_ID :
                                tmp.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(columnName))));
                                break;
                            case COLUMN_NOISE_NAME :
                                tmp.setName(cursor.getString(cursor.getColumnIndex(columnName)));
                                break;
                            case COLUMN_NOISE_TEST_ID :
                                tmp.setTest_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(columnName))));

                                break;

                        }
                    }
                    list.add(tmp);
                } while (cursor.moveToNext());
            }
            return list;
        }
        return null;
    }
}
