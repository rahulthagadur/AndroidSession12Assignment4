package com.example.thagadur.androidsession12assignment4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import static android.R.string.yes;
import static android.os.Build.VERSION_CODES.N;
import static com.example.thagadur.androidsession12assignment4.MainActivity.adapter;

/**
 * Created by Thagadur on 8/26/2017.
 */

public class CustomDialogClass extends Dialog {
    //Activity dialog;
    EditText name, dateOfBirth, phoneNum;
    Button yes, no;
    String fullName="", phNum="", DOB="";
    public static ArrayList<ListModel> windowData = new ArrayList<ListModel>();


    public CustomDialogClass(@NonNull Context context) {
        super(context);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        //Initialisations with Identifiers
        name = (EditText) findViewById(R.id.custom_name);
        dateOfBirth = (EditText) findViewById(R.id.custom_date_of_birth);
        phoneNum = (EditText) findViewById(R.id.custom_ph_number);
        yes = (Button) findViewById(R.id.save_button);
        no = (Button) findViewById(R.id.cancel_button);



        //Setting Onclick listner
        //adding items to arraylist
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullName = name.getText().toString();
                phNum = phoneNum.getText().toString();
                DOB = dateOfBirth.getText().toString();
                final ListModel addItems = new ListModel();
                if (!(fullName.equals("")&&phNum.equals("")&&DOB.equals(""))) {
                    addItems.setFullName(fullName);
                    addItems.setPhoneNumber(phNum);
                    addItems.setDOB(DOB);
                    windowData.add(addItems);
                    if (windowData.size() != 0) {
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getContext(), "save button clicked", Toast.LENGTH_SHORT).show();
                        dismiss();
                    } else
                        Toast.makeText(getContext(), "Enter the details", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getContext(), "Enter the details", Toast.LENGTH_SHORT).show();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Cancelled adding items to list", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

    }
}
