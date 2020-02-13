package com.shingo.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    static String TAG = "shingo.main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // actually set the contents to be whatever's in the XML file called activity_main
        setContentView(R.layout.activity_main);
        // setup work
        // logging: verbose, debug, info, warning, error, wtf
        Log.d(TAG, "we are in onCreate");


        final Button buttonAddTask = findViewById(R.id.addTask);
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AddTask.class));
            }
        });


        final Button buttonAllTask = findViewById(R.id.allTasksButton);
        buttonAllTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"made it to onclick method");

                startActivity(new Intent(MainActivity.this, AllTask.class));
//                Intent goToAllTask = new Intent(MainActivity.this, AllTask.class);
//                MainActivity.this.startActivity(goToAllTask);

                Log.i(TAG,"inside start activity");
            }
        });

    }

}
