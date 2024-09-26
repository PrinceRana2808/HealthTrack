package com.prince.healthyfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorActivity extends AppCompatActivity {
    private  String[][] doctor_detail1 = {
            {"Doctor Name: Dr. Smith", "Hospital Address: 123 Main St, City Hospital", "Experience: 10 years", "Mobile Number: 555-1234", "Price: $100"},
            {"Doctor Name: Dr. Johnson", "Hospital Address: 456 Oak St, Community Clinic", "Experience: 8 years", "Mobile Number: 555-5678", "Price: $80"},
            {"Doctor Name: Dr. Williams", "Hospital Address: 789 Pine St, Medical Center", "Experience: 15 years", "Mobile Number: 555-9876", "Price: $120"},
            {"Doctor Name: Dr. Davis", "Hospital Address: 321 Elm St, County Hospital", "Experience: 5 years", "Mobile Number: 555-4321", "Price: $90"},
            {"Doctor Name: Dr. Anderson", "Hospital Address: 654 Birch St, Private Practice", "Experience: 12 years", "Mobile Number: 555-8765", "Price: $110"}
    };
    private  String[][] doctor_detail2 = {
            {"Doctor Name: Dr. Miller", "Hospital Address: 234 Oak St, General Hospital", "Experience: 7 years", "Mobile Number: 555-1111", "Price: $95"},
            {"Doctor Name: Dr. White", "Hospital Address: 567 Pine St, Urgent Care", "Experience: 9 years", "Mobile Number: 555-2222", "Price: $85"},
            {"Doctor Name: Dr. Harris", "Hospital Address: 890 Elm St, Children's Hospital", "Experience: 14 years", "Mobile Number: 555-3333", "Price: $130"},
            {"Doctor Name: Dr. Martin", "Hospital Address: 123 Maple St, Private Clinic", "Experience: 6 years", "Mobile Number: 555-4444", "Price: $75"},
            {"Doctor Name: Dr. Taylor", "Hospital Address: 456 Birch St, Women's Health Center", "Experience: 11 years", "Mobile Number: 555-5555", "Price: $105"}
    };

    private  String[][] doctor_detail3 = {
            {"Doctor Name: Dr. Brown", "Hospital Address: 789 Cedar St, Surgical Center", "Experience: 13 years", "Mobile Number: 555-6666", "Price: $115"},
            {"Doctor Name: Dr. Clark", "Hospital Address: 012 Pine St, Cardiology Clinic", "Experience: 8 years", "Mobile Number: 555-7777", "Price: $90"},
            {"Doctor Name: Dr. Turner", "Hospital Address: 345 Oak St, Family Medicine", "Experience: 10 years", "Mobile Number: 555-8888", "Price: $100"},
            {"Doctor Name: Dr. King", "Hospital Address: 678 Maple St, Sports Medicine", "Experience: 5 years", "Mobile Number: 555-9999", "Price: $80"},
            {"Doctor Name: Dr. Green", "Hospital Address: 901 Birch St, Neurology Center", "Experience: 12 years", "Mobile Number: 555-0000", "Price: $110"}
    };

    private  String[][] doctor_detail4 = {
            {"Doctor Name: Dr. Turner", "Hospital Address: 123 Willow St, Dermatology Clinic", "Experience: 11 years", "Mobile Number: 555-1122", "Price: $105"},
            {"Doctor Name: Dr. Baker", "Hospital Address: 456 Cedar St, Psychiatry Center", "Experience: 9 years", "Mobile Number: 555-3344", "Price: $95"},
            {"Doctor Name: Dr. Mitchell", "Hospital Address: 789 Elm St, Gastroenterology Clinic", "Experience: 14 years", "Mobile Number: 555-5566", "Price: $125"},
            {"Doctor Name: Dr. Nelson", "Hospital Address: 012 Pine St, Orthopedic Center", "Experience: 6 years", "Mobile Number: 555-7788", "Price: $85"},
            {"Doctor Name: Dr. Murphy", "Hospital Address: 345 Cedar St, Ophthalmology Clinic", "Experience: 10 years", "Mobile Number: 555-9900", "Price: $100"}
    };

    private  String[][] doctor_detail5 = {
            {"Doctor Name: Dr. Cooper", "Hospital Address: 678 Willow St, Endocrinology Clinic", "Experience: 12 years", "Mobile Number: 555-1122", "Price: $110"},
            {"Doctor Name: Dr. Hall", "Hospital Address: 901 Cedar St, Urology Center", "Experience: 7 years", "Mobile Number: 555-3344", "Price: $95"},
            {"Doctor Name: Dr. Bennett", "Hospital Address: 234 Elm St, Rheumatology Clinic", "Experience: 15 years", "Mobile Number: 555-5566", "Price: $130"},
            {"Doctor Name: Dr. Cox", "Hospital Address: 567 Pine St, Nephrology Center", "Experience: 8 years", "Mobile Number: 555-7788", "Price: $90"},
            {"Doctor Name: Dr. Reed", "Hospital Address: 890 Cedar St, Pulmonology Clinic", "Experience: 11 years", "Mobile Number: 555-9900", "Price: $105"}
    };
    String doctor_detail[][]={};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        TextView t=findViewById(R.id.defaulttext);
        Intent i=getIntent();
        String value=i.getStringExtra("title");
        t.setText(value);
        if(value.compareTo("DENTIST")==0)
            doctor_detail=doctor_detail1;
        else
        if(value.compareTo("SURGEON")==0)
            doctor_detail=doctor_detail2;
        else
            if(value.compareTo("DIETICIAN")==0)
        doctor_detail=doctor_detail3;
        else
            if(value.compareTo("CARDIOLOGIST")==0)
        doctor_detail=doctor_detail4;
        else
            if(value.compareTo("FAMILY PHYSICIAN")==0)
        doctor_detail=doctor_detail5;
        Button b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DoctorActivity.this,FindActivity.class);
               startActivity(i);
            }
        });
        ArrayList list = new ArrayList();
        for (int j=0;j<doctor_detail.length;j++){
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("line1",doctor_detail[j][0]);
            item.put("line2",doctor_detail[j][1]);
            item.put("line3",doctor_detail[j][2]);
            item.put("line4",doctor_detail[j][3]);
            item.put("line5","Cons Fee:"+doctor_detail[j][4]);
            list.add(item);
        }
        SimpleAdapter sa = new SimpleAdapter(
                this,
                list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst=findViewById(R.id.listv);
        lst.setAdapter(sa);
       lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
               Intent it=new Intent(DoctorActivity.this,BookApointmentActivity.class);
               it.putExtra("text1",value);
               it.putExtra("text2",doctor_detail[j][0]);
               it.putExtra("text3",doctor_detail[j][1]);
               it.putExtra("text4",doctor_detail[j][3]);
               it.putExtra("text5",doctor_detail[j][4]);
               startActivity(it);
           }
       });

    }
}