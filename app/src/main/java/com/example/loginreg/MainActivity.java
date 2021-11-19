package com.example.loginreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText username, password,repassword;
Button signup,signIn;
DBHelper DB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.usenameID);
        password=findViewById(R.id.passwordID);
        repassword=findViewById(R.id.repasswordID);
        signup=findViewById(R.id.btnsignupID);
        signIn=findViewById(R.id.btnsigninID);
        DB=new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if (user.equals("")||pass.equals("")||repass.equals(""))
                Toast.makeText(MainActivity.this, "Please Enter all Fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                       Boolean checkuser=DB.Checkusername(user);
                       if(checkuser==false){
                           Boolean insert=DB.insertData(user,pass);
                           if(insert==true){
                               Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
//                               Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
//                               startActivity(intent);
                           }else{
                               Toast.makeText(MainActivity.this, "Registration Faild", Toast.LENGTH_SHORT).show();
                           }
                       }
                       else{
                           Toast.makeText(MainActivity.this, "User already Exist Please sign in", Toast.LENGTH_SHORT).show();
                       }
                    }else{
                        Toast.makeText(MainActivity.this, "Password Not Maching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}