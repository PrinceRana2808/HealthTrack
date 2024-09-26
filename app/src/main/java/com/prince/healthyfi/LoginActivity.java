package com.prince.healthyfi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText eduser,edpassword;
    Button submit;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eduser=findViewById(R.id.username);
        edpassword=findViewById(R.id.password);
        submit=findViewById(R.id.Login);
        tv=findViewById(R.id.register);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username=eduser.getText().toString();
                String Password=edpassword.getText().toString();
                Database db=new Database(getApplicationContext(),"Healthify",null,1);
                if(Username.length()==0||Password.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Enter username or password",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (db.Login(Username,Password)==1)
                    {
                        SharedPreferences sharedprefrences=getSharedPreferences("shared_prefer", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedprefrences.edit();
                        editor.putString("username",Username);
                        editor.apply();
                        Intent a=new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(a);

                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Login Unsuccessful Enter correct username or paassword", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivity(intent);
            }
        });
    }
}