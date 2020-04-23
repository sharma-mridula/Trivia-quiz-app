package com.appscrip.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.LinkedList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        Button button = (Button) findViewById(R.id.next3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                QuestionAnsData.QuestionAns qa = new QuestionAnsData.QuestionAns();
                qa.que = "What is your name";
                qa.ans = getSelectColors(); //this method will fetch all the colours from the views according to their Ids
                QuestionAnsData.list.add(qa);


                goToNextActivity();
            }
        });
    }

    private void goToNextActivity() {
        Intent intent = new Intent(this, SummaryActivity.class);
        startActivity(intent);
    }

    private String getSelectColors(){
        CheckBox opt1 = ((CheckBox) findViewById(R.id.white));
        CheckBox opt2 = ((CheckBox) findViewById(R.id.yellow));
        CheckBox opt3 = ((CheckBox) findViewById(R.id.orange));
        CheckBox opt4 = ((CheckBox) findViewById(R.id.green));

        String selected = "";
        if(opt1.isChecked()){
            selected += opt1.getText().toString() + ",";
        }
        if(opt2.isChecked()){
            selected += opt2.getText().toString() + ",";
        }
        if(opt3.isChecked()){
            selected += opt3.getText().toString() + ",";
        }
        if(opt4.isChecked()){
            selected += opt4.getText().toString() + ",";
        }
        return selected;

    }
}
