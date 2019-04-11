package com.careblock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_records);

        final EditText name = findViewById(R.id.editText);
        final EditText id = findViewById(R.id.editText2);
        final EditText password = findViewById(R.id.editText3);
        final EditText summary = findViewById(R.id.editText4);

        Button submit = findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddRecordsActivity.this,UserRecords.class);
                intent.putExtra("name",name.getText());
                intent.putExtra("id",id.getText());
                intent.putExtra("pass",password.getText());
                intent.putExtra("summary",summary.getText());
                startActivity(intent);
            }
        });
    }
}
