package com.prince.healthyfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedprefrences=getSharedPreferences("shared_prefer", Context.MODE_PRIVATE);
        String username=sharedprefrences.getString("username","Username").toString();
        Toast.makeText(getApplicationContext(),"Welcome"+username,Toast.LENGTH_SHORT).show();
        CardView exit=findViewById(R.id.Logout);
        CardView find=findViewById(R.id.Finddoctor);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor= sharedprefrences.edit();
                editor.clear();
                editor.apply();;
                Intent a=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(a);
            }
        });
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,FindActivity.class);
                startActivity(i);
            }
        });
        CardView labTest=findViewById(R.id.Labtest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(HomeActivity.this,LabTestActivity.class);
                startActivity(j);
            }
        });
    }

}