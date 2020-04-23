package com.appscrip.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.EditText;

public class SummaryActivity extends AppCompatActivity {

   // DatabaseHelper dbHelper = new DatabaseHelper(this.getApplicationContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Button finButton = (Button) findViewById(R.id.finish);
        finButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToNextActivity();
            }
        });


        Button hisButton = (Button) findViewById(R.id.history);
        hisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHisActivity();
            }
        });

        //String name = ((EditText) findViewById(R.id.ans1)).getText().toString();
        ((TextView) findViewById(R.id.sumName)).setText("Answer: " + QuestionAnsData.list.get(0).ans);


        ((TextView) findViewById(R.id.sumBestCricketer)).setText("Answer: " + QuestionAnsData.list.get(1).ans);

        ((TextView) findViewById(R.id.sumColors)).setText("Answer: " + QuestionAnsData.list.get(2).ans);
    }





    private void goToNextActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToHisActivity() {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
}
