package com.hearing.hearingsys.Adopters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.hearing.hearingsys.R;
import com.hearing.hearingsys.model.Image;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Question_adopter extends BaseAdapter {

    Activity activity;
    ArrayList<Image> DataSet ;

    public Question_adopter(Activity activity, ArrayList<Image> dataSet) {
        this.activity = activity;
        DataSet = dataSet;
    }

    @Override
    public int getCount() {
        return DataSet.size() ;
    }

    @Override
    public Image getItem(int position) {
        return DataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View row = new View(activity);
            row = inflater.inflate(R.layout.layout_image_grid_item, null);
        ImageView imageView= row.findViewById(R.id.img_IV);
        imageView.setImageBitmap(DataSet.get(position).img);

        return row;
    }
}
