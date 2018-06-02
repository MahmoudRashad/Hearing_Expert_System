package com.hearing.hearingsys.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Ahmed on 5/26/2018.
 */

public class MYDialg {

    String msg,title,negative_btn_text, positive_btn_text;
    private Dialog dialog;
    Activity activity;

    public MYDialg( Activity activity) {
        this.activity=activity;
    }

    public MYDialg(Activity activity, String title, String msg, String negative_btn_text, String positive_btn_text) {
        this.activity=activity;
        this.title=title;
        this.msg=msg;
        this.negative_btn_text=negative_btn_text;
        this.positive_btn_text=positive_btn_text;
    }

    public void show_dialog(final result listener ){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setTitle(title)
                .setMessage(msg)
                .setPositiveButton(negative_btn_text, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        if (listener!=null)
                            listener.on_pos_btn();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(positive_btn_text, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        if (listener!=null)
                            listener.on_neg_btn();
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    public void get_text(final text_interface listener ,final String title){


        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);

// Set up the input
        LinearLayout linearLayout = new LinearLayout(activity);
        final EditText input = new EditText(activity);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);

//        LinearLayout butons = new LinearLayout(activity);
//
//        final Button OK = new Button(activity);
//        final Button cancel = new Button(activity);
//
//        butons.setOrientation(LinearLayout.HORIZONTAL);
//        butons.addView(OK);
//        butons.addView(cancel);
//
//        linearLayout.addView(input);
//        linearLayout.addView(input);



// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text

        builder.setView(input);


// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (input.getText().toString().length()<1)
                {
                    get_text(  listener , title);
                    input.setError("Required");
                }else {
                    if (listener!=null)
                        listener.on_text_enter(input.getText().toString());
                }

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();




    }

    public void get_show_text(final text_interface listener ,String title){


        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);



// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (listener!=null)
                listener.on_text_enter("ok ");

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();




    }



   public interface text_interface{
        void on_text_enter(String text);
    }
   public interface result{
        void on_pos_btn();
        void on_neg_btn();
    }
}
