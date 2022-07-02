package com.example.pt1_itpel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Interest_Rate extends AppCompatActivity {
    Spinner spin;
    List<String> data;
    String item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest__rate);

        spin = findViewById(R.id.spinner);

        data = new ArrayList<>();


        data.add("Loan Amount");
        data.add(0, "Interest Rate");
        data.add("Number of months");
        data.add("Monthly Payment");


        spin.setAdapter(new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,
                data));

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Interest_Rate.this, spin.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                if(parent.getItemAtPosition(position).equals("Loan Amount"))
                {
                    Intent intent = new Intent(Interest_Rate.this, MainActivity.class);
                    startActivity(intent);
                }

            }
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
}