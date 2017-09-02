package com.example.thagadur.androidsession12assignment4;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import static android.R.id.list;
import static com.example.thagadur.androidsession12assignment4.CustomDialogClass.windowData;

public class MainActivity extends AppCompatActivity {

    //Declaration of objects...
    public static CustomAdapter adapter;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.main_list);
        adapter = new CustomAdapter(MainActivity.this, windowData);
        list.setAdapter(adapter);
    }

    //To appear menu in action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.alert_menu, menu);
        return true;
    }

    //Listing the items that are there in the menu file
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.add_new_item:
                //Calling custom dialog class and showing it this activity
                CustomDialogClass customDialog = new CustomDialogClass(MainActivity.this);
                customDialog.show();
                break;
        }
        return true;
    }
}
