package com.example.loginreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnlogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.usenameID1);
        password=findViewById(R.id.passwordID1);
        btnlogin =findViewById(R.id.btnsigninID1);
        DB=new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String user=username.getText().toString();
String pass=password.getText().toString();

if(user.equals("")||pass.equals(""))
    Toast.makeText(LoginActivity.this, "Please enter all the field", Toast.LENGTH_SHORT).show();
else {
    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
    if(checkuserpass==true){
        Toast.makeText(LoginActivity.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
    }else{
        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
    }
}

            }
        });
    }
}