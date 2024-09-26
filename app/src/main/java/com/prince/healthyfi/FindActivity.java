package com.prince.healthyfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CardView a;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        CardView c=findViewById(R.id.out);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FindActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
        a=findViewById(R.id.dentist);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FindActivity.this,DoctorActivity.class);
                i.putExtra("title","DENTIST");
                startActivity(i);

            }
        });
        CardView surgeon=findViewById(R.id.surgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FindActivity.this,DoctorActivity.class);
                i.putExtra("title","SURGEON");
                startActivity(i);
            }
        });
        CardView cardialogist=findViewById(R.id.cardiologist);
        cardialogist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FindActivity.this,DoctorActivity.class);
                i.putExtra("title","CARDIOLOGIST");
                startActivity(i);
            }
        });
        CardView dietician=findViewById(R.id.dietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FindActivity.this,DoctorActivity.class);
                i.putExtra("title","DIETICIAN");
                startActivity(i);
            }
        });
        CardView physician=findViewById(R.id.familyphysician);
        physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FindActivity.this,DoctorActivity.class);
                i.putExtra("title","FAMILY PHYSICIAN");
                startActivity(i);
            }
        });
    }
}