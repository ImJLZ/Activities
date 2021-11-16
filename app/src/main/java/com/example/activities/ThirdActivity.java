package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private EditText editText;
    private Intent intent;
    Button btnCloseThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        editText = findViewById(R.id.editText);
        btnCloseThird = findViewById(R.id.btnCloseThird);

        intent = getIntent();
        btnCloseThird.setOnClickListener(v -> {
            intent.putExtra("act3Key",editText.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}