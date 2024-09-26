package com.prince.healthyfi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username,email,password,confirm;
    Button register;
    TextView rtv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.edittextfullname);
        email = findViewById(R.id.edittextappaddress);
        password = findViewById(R.id.edittextcontactnumber);
        confirm = findViewById(R.id.edittextconsultantfee);
        register = findViewById(R.id.buttonbookapointment);
        rtv = findViewById(R.id.regregister);

        rtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);

                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String emailp=email.getText().toString();
                String pass=password.getText().toString();
                String conpass=confirm.getText().toString();
                Database db=new Database(getApplicationContext(),"Healthify",null,1);
                if(user.length()==0||emailp.length()==0||pass.length()==0||conpass.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Enter your detail first",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pass.compareTo(conpass)==0)
                    {
                        if(isPasswordValid(pass))
                        {
                            db.register(user,emailp,pass);
                            Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(in);

                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Password must have at least 1 digit and 1 uppercase letter",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password and confirm passwod does not match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isPasswordValid(String password) {
        // Check for length greater than 8
        if (password.length() < 8) {
            return false;
        }

        // Check for at least one digit, one uppercase letter, and one special character
        return password.matches(".*\\d.*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}