package com.careblock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDoctorRecords extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor_records);

        EditText name = findViewById(R.id.ediText);
        EditText id = findViewById(R.id.ediText2);
        EditText password = findViewById(R.id.ediText3);
        EditText summary = findViewById(R.id.ediText4);

        Button submit = findViewById(R.id.button1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
