package com.hearing.hearingsys.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

/**
 * Created by Ahmed on 5/26/2018.
 */

public class Question  {

    String msg,title,negative_btn_text, positive_btn_text;
    private Dialog dialog;
    Activity activity;

    public Question(Activity activity,String title, String msg, String negative_btn_text, String positive_btn_text) {
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

   public interface result{
        void on_pos_btn();
        void on_neg_btn();
    }
}
