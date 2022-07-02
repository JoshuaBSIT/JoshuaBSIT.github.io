package com.itpel4lab.io_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    String f_name, l_name, g_gender, a_age, a_address;
    FloatingActionButton btn_register, btn_cancel;
    EditText firstname, lastname, gender, age, address;
    TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.txtFirstname);
        lastname = findViewById(R.id.txtLastname);
        gender = findViewById(R.id.txtGender);
        age = findViewById(R.id.txtAge);
        address = findViewById(R.id.txtAddress);
        btn_register = findViewById(R.id.btnRegister);
        btn_cancel = findViewById(R.id.btnCancel);
        txtOutput = findViewById(R.id.txtDisplay);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                f_name = firstname.getText().toString();
                l_name = lastname.getText().toString();
                g_gender = gender.getText().toString();
                a_age = age.getText().toString();
                a_address = address.getText().toString();

                if(firstname.getText().toString().isEmpty() || lastname.getText().toString().isEmpty() || gender.getText().toString().isEmpty() || age.getText().toString().isEmpty() || address.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Input required data...", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "First name: " + f_name + "\n" + "last name:" + l_name + "\n" + "gender: " + g_gender + "\n" + "age: " + a_age + "\n" + "address: " + a_address, Toast.LENGTH_SHORT).show();
                    txtOutput.setText("First Name: " + f_name + "\n" + "Last Name: " + l_name + "\n" + "Gender: " + g_gender + "\n" + "Age: " + a_age + "\n" + "Address: " + a_address);
                }

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                firstname.setFocusable(View.FOCUSABLE);
                firstname.setText("");
                lastname.setText("");
                gender.setText("");
                age.setText("");
                address.setText("");

                txtOutput.setText("Registration Details");
            }
        });
    }
}