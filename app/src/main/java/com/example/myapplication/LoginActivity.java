package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button register;
    private Button login;
    private EditText userName,userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.editText_username);
        userPassword = findViewById(R.id.editText_Password);
        connectView();
    }

    private void connectView(){
        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.btnLogin);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String textUserName = userName.getText().toString().trim();

//                String textPassword = userPassword.getText().toString().trim();
//                if (textUserName.equals("admin") && textPassword.equals("admin")){
                  startActivity(new Intent(LoginActivity.this,MainActivity.class));
//                }else{
//                    Toast.makeText(LoginActivity.this,"Tên đăng nhập / mật khẩu không đúng"+textPassword+" "+textUserName,Toast.LENGTH_LONG).show();
//                }
            }
        });
    }
}
