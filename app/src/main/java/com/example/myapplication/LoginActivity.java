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
    private Database dataHelper = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dataHelper.createAdminUser();
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
                if (dataHelper.getUserLogin(userName.getText().toString(),userPassword.getText().toString())){
                    //Toast.makeText(LoginActivity.this,"Login Success",Toast.LENGTH_LONG).show();

                        startActivity(new Intent(LoginActivity.this,MainActivity.class));

                }else{
                    Toast.makeText(LoginActivity.this,"Username / password not correct",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
