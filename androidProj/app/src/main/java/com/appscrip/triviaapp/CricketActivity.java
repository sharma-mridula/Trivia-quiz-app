package com.appscrip.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.LinkedList;

public class CricketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);

        Button button = (Button) findViewById(R.id.next2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                QuestionAnsData.QuestionAns qa = new QuestionAnsData.QuestionAns();
                qa.que = "What is your name";
                qa.ans = getSelectCrickter();
                QuestionAnsData.list.add(qa);




                goToNextActivity();
            }
        });
    }

    private void goToNextActivity() {
        Intent intent = new Intent(this, ColorsActivity.class);
        startActivity(intent);
    }


    private String getSelectCrickter(){

        RadioButton opt1 = ((RadioButton) findViewById(R.id.c1));
        RadioButton opt2 = ((RadioButton) findViewById(R.id.c2));
        RadioButton opt3 = ((RadioButton) findViewById(R.id.c3));
        RadioButton opt4 = ((RadioButton) findViewById(R.id.c4));
        RadioButton selected = null;
        if(opt1.isChecked()){
            selected = opt1;
        }else if(opt2.isChecked()){
            selected = opt2;
        }else if(opt3.isChecked()){
            selected = opt3;
        }else if(opt4.isChecked()){
            selected = opt4;
        }

        return selected.getText().toString();

    }
}
