package com.example.loginandsignupexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginandsignupexample.config.APIConnect;
import com.example.loginandsignupexample.config.ApiUtils;
import com.example.loginandsignupexample.config.RetrofitClient;
import com.example.loginandsignupexample.models.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    TextView tvRegister;
    public static List<Account> accounts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }
    public void getData() {
        ApiUtils.getAPIService().getToken(edtUsername.getText().toString(), edtPassword.getText().toString()).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus().equals("true")) {
                        accounts = Collections.singletonList(response.body());
                        startActivity(new Intent(getApplicationContext(), Main3Activity.class));
                        finish();
                    } else {
                        if(response.body().getStatus().equals("false") && response.body().getMessage().equals("Account not found")) {
                            Toast.makeText(MainActivity.this, "Tài khoản không có", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Mật khẩu sai", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Không kết nối được", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
