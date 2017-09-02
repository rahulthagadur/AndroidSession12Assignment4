package com.example.thagadur.androidsession12assignment4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.data;

/**
 * Created by Thagadur on 8/28/2017.
 */

public class CustomAdapter extends BaseAdapter {
    //Declaration of objects...
    Activity activity;
    ArrayList arrayList;
    ListModel tempValues = null;
    private static LayoutInflater inflater = null;
    //creates constructor to initialise the objects
    public CustomAdapter(Activity activity, ArrayList arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //checking the size of arralist
    @Override
    public int getCount() {
        if (arrayList.size() <= 0)
            return 1;
        else
            return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //Holder Calss holding Text view items
    public static class Holder {
        public TextView name;
        public TextView phoneNumber;
        public TextView dateOfBirth;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.custom_list, null);

            holder = new Holder();
            holder.name = (TextView) view.findViewById(R.id.name_text);
            holder.phoneNumber = (TextView) view.findViewById(R.id.phnm_text);
            holder.dateOfBirth = (TextView) view.findViewById(R.id.date_text);
            view.setTag(holder);
        } else
            holder = (Holder) view.getTag();

        if (arrayList.size() <= 0) {
            holder.name.setText("");

        } else {
            /***** Get each Model object from Arraylist ********/
            tempValues = null;
            tempValues = (ListModel) arrayList.get(i);

            /************  Set Model values in Holder elements ***********/

            holder.name.setText(tempValues.getFullName());
            holder.phoneNumber.setText(tempValues.getPhoneNumber());
            holder.dateOfBirth.setText(tempValues.getDOB());

        }
        return view;
    }
}

