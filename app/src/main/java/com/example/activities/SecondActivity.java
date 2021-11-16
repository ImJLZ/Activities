package com.example.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtMessage;
    ActivityResultLauncher launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtMessage = findViewById(R.id.txtMessage);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent i = result.getData();
                    assert i != null;
                    String s = i.getStringExtra("act3Key");
                    txtMessage.setText(s);
                }
        );

        Intent intent = getIntent();
        String message = intent.getStringExtra("Hilsen");
        txtMessage.setText(message);

        Button btnToMain = findViewById(R.id.btnToMain);
        Button btnToThird = findViewById(R.id.btnToThird);

        btnToMain.setOnClickListener(v -> {
            finish();
        });
        btnToThird.setOnClickListener(v -> {
            Intent newIntent = new Intent(SecondActivity.this, ThirdActivity.class);
            launcher.launch(newIntent);
        });
    }
}