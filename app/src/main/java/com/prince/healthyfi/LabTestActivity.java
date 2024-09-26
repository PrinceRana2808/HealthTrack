package com.prince.healthyfi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    private String[][] packages={
        {"Package 1:Full Body Checkup","","","","968"},
        {"Package 2:Blood Glucose Fasting","","","","969"},
        {"Package 3:Covid-19","","","","868"},
        {"Package 4:Thyroid Check","","","","998"},
        {"Package 5:Imunity Checkup","","","","999"}
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btngtcart,btnback;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        btngtcart=findViewById(R.id.btngotocart);
        btnback=findViewById(R.id.btnback);
        listView=findViewById(R.id.listViewLT);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LabTestActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
            item=new HashMap<>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);

        }
        SimpleAdapter sa = new SimpleAdapter(
                this,
                list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        listView.setAdapter(sa);
    }
}