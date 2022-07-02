package com.example.pt1_itpel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spin;
    List<String> data;
    String item;
    Button cancel, go;
    TextView Rate,  Months, Payment, Answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Rate = findViewById(R.id.txtRate);
        Months = findViewById(R.id.txtmonths);
        Payment = findViewById(R.id.txtpayment);
        Answer = findViewById(R.id.txtAnswer);
        spin = findViewById(R.id.spinner);
        cancel = findViewById(R.id.btn_clear);
        go = findViewById(R.id.btn_cal);

        data = new ArrayList<>();


        data.add("Loan Amount");
        data.add("Interest Rate");
        data.add("Number of months");
        data.add("Monthly Payment");

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Rate.getText().toString().isEmpty() || Months.getText().toString().isEmpty() || Payment.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Insufficient", Toast.LENGTH_SHORT).show();
                }
                else {
                    double r = Float.valueOf(Rate.getText().toString()); //rate
                    double m = Integer.parseInt(Months.getText().toString()); //months
                    double p = Float.valueOf(Payment.getText().toString()); //Payment
                    double i = (r/100)/12; //converted rate

                    double f = p/i; //first formula
                    double test = 1+i;
                    double ss =  Math.pow(test,m);
                    double s = (1/ss);
                    double e = 1-s;
                    float finalv = (float) (f*e);
                    String finish = String.valueOf(finalv);

                   Answer.setText("Answer: " + finish);

                    Toast.makeText(MainActivity.this, String.valueOf(finalv), Toast.LENGTH_LONG).show();
                }
            }
        });


        spin.setAdapter(new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,
                data));

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, spin.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    if(parent.getItemAtPosition(position).equals("Interest Rate"))
                    {
                        Intent intent = new Intent(MainActivity.this, Interest_Rate.class);
                        startActivity(intent);
                    }

            }
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
}