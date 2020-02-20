package com.shingo.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.amplify.generated.graphql.CreateTaskmasterMutation;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;

import type.CreateTaskmasterInput;

public class AddTask extends AppCompatActivity {

    String taskTitle, taskDetail;
    EditText titleInput;
    EditText detailInput;

    Button submitButton;

    private AWSAppSyncClient mAWSAppSyncClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        mAWSAppSyncClient = AWSAppSyncClient.builder()
                .context(getApplicationContext())
                .awsConfiguration(new AWSConfiguration(getApplicationContext()))
                .build();


        titleInput = (EditText) findViewById(R.id.editText);
        detailInput = (EditText) findViewById(R.id.editText2);

        submitButton = (Button) findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i("Shingo.Addtask", "it went in here");
                taskTitle = titleInput.getText().toString();
                taskDetail = detailInput.getText().toString();

                CreateTaskmasterInput input = CreateTaskmasterInput.builder()
                        .title(taskTitle)
                        .description(taskDetail)
                        .build();

                mAWSAppSyncClient.mutate(CreateTaskmasterMutation.builder().input(input).build())
                        .enqueue(new GraphQLCall.Callback<CreateTaskmasterMutation.Data>() {
                            @Override
                            public void onResponse(@Nonnull Response<CreateTaskmasterMutation.Data> response) {
                                Log.i("Shingo.Addtask", response.data().toString());
                            }

                            @Override
                            public void onFailure(@Nonnull ApolloException e) {

                            }
                        });


//                .add(taskTitle);
//                .add(taskDetail);

//                showToast(taskTitle);
//                showToast(taskDetail);

//                Intent intent = new Intent(AddTask.this,AllTask.class);
//                intent.putExtra("task title",taskTitle);
//                intent.putExtra("task detail",taskDetail);
//                startActivity(intent);


            }

        });

    }

    private void showToast(String text){
        Toast toast = Toast.makeText(AddTask.this,text,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL,70,0);
        toast.show();
    }




}
