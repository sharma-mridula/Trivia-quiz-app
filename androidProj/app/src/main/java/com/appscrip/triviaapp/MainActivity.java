package com.appscrip.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.next1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                QuestionAnsData.list = new LinkedList<QuestionAnsData.QuestionAns>();
                QuestionAnsData.QuestionAns qa = new QuestionAnsData.QuestionAns();
                qa.que = "What is your name";
                qa.ans = ((EditText) findViewById(R.id.ans1)).getText().toString();
                QuestionAnsData.list.add(qa);
                goToSecondActivity();
            }
        });
    }

    private void goToSecondActivity() {
        Intent intent = new Intent(this, CricketActivity.class);
        startActivity(intent);
    }



}
