package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button register,back;
    private EditText username, password, repass, email;
    private Database dataHelper = new Database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.Userpassword);
        repass = (EditText) findViewById(R.id.repass);
        email = (EditText) findViewById(R.id.Useremail);
        register();
        back();
    }
    private void back(){
        back = (Button) findViewById(R.id.btnback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
    private void register() {
        register = (Button) findViewById(R.id.btnregister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!password.getText().toString().equals(repass.getText().toString()))
                    Toast.makeText(RegisterActivity.this,"Nhập lại mật khẩu không đúng",Toast.LENGTH_LONG).show();
                else{
                    User u = new User(username.getText().toString(),password.getText().toString(),email.getText().toString());
                    dataHelper.INSERT_User(u);
                    Toast.makeText(RegisterActivity.this,"Đăng ký tài khoản thành công",Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
}
