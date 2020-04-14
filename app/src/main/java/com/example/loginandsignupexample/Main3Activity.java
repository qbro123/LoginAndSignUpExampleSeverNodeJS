package com.example.loginandsignupexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.loginandsignupexample.MainActivity.accounts;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView tvFullname = findViewById(R.id.tvFullname);
        TextView tvUsername = findViewById(R.id.tvUsername);
        Button btnLogOut = findViewById(R.id.btnLogOut);
        tvFullname.setText(accounts.get(0).getFullname());
        tvUsername.setText(accounts.get(0).getUsername());
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }
}
