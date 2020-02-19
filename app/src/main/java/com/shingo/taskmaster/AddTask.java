package com.shingo.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTask extends AppCompatActivity {

    String taskTitle, taskDetail;
    EditText titleInput;
    EditText detailInput;

    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        titleInput = (EditText) findViewById(R.id.editText);
        detailInput = (EditText) findViewById(R.id.editText2);

        submitButton = (Button) findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                taskTitle = titleInput.getText().toString();
                taskDetail = detailInput.getText().toString();

//                .add(taskTitle);
//                .add(taskDetail);

//                showToast(taskTitle);
//                showToast(taskDetail);

                Intent intent = new Intent(AddTask.this,AllTask.class);
                intent.putExtra("task title",taskTitle);
                intent.putExtra("task detail",taskDetail);
                startActivity(intent);
            }

        });

    }

    private void showToast(String text){
        Toast toast = Toast.makeText(AddTask.this,text,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL,70,0);
        toast.show();
    }

}
