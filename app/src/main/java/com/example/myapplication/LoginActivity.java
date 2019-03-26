package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button register;
    private Button login;
    private EditText userName,userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.editText_username);
        userPassword = findViewById(R.id.editText_Password);
        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.btnLogin);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this,MainActivity.class));
//            }
//        });
        connectView();
    }

    private void connectView(){

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals("admin") && userPassword.getText().toString().equals("admin")){
                    //Toast.makeText(LoginActivity.this,"Login Success",Toast.LENGTH_LONG).show();
                    login.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }
                     });
                }else{
                    Toast.makeText(LoginActivity.this,"Username / password not correct",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
