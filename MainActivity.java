package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText TextPerson;
    private TextView logo;
    private Button mainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextPerson = findViewById(R.id.TextPerson);
        logo = findViewById(R.id.logo);
        mainBtn = findViewById(R.id.mainBtn);

        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextPerson.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, R.string.noInputUser, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}