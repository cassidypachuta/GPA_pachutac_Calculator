package com.example.gpa_pachutac_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button mButton;
    EditText ed1, ed2, ed3, ed4, ed5;
    TextView gpa;
    View main;
    int count = 0;
    double avg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button)findViewById(R.id.button2);
        ed1=(EditText)findViewById(R.id.editTextgrade1);
        ed2=(EditText)findViewById(R.id.editTextgrade2);
        ed3=(EditText)findViewById(R.id.editTextgrade3);
        ed4=(EditText)findViewById(R.id.editTextgrade4);
        ed5=(EditText)findViewById(R.id.editTextgrade5);
        gpa=(TextView)findViewById(R.id.gpa);
        main = (View)findViewById(R.id.main);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double grade = 0;
                if (count%2==0) {
                    if (ed1.getText().toString().equals("") || (ed2.getText().toString().equals("")
                            ||(ed3.getText().toString().equals("") || (ed4.getText().toString().equals("")
                            || (ed5.getText().toString().equals("")))))) {
                              gpa.setText(R.string.empty);
                    }
                    else {
                        grade += Integer.parseInt(ed1.getText().toString());
                        grade += Integer.parseInt(ed2.getText().toString());
                        grade += Integer.parseInt(ed3.getText().toString());
                        grade += Integer.parseInt(ed4.getText().toString());
                        grade += Integer.parseInt(ed5.getText().toString());
                        avg = grade/5;
                        String total = String.format("%.1f",avg);
                        gpa.setText(total);
                        setBackGroundColor(avg);
                        count ++;
                        mButton.setText(R.string.btnclear);
        }}
                else {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    ed5.setText("");
                    gpa.setText("");
                    main.setBackgroundColor(Color.WHITE);
                    mButton.setText(R.string.btn);
                    count ++;
                }
        }
    });
}
    private void setBackGroundColor(double avg) {
        if (avg < 60) {
            main.setBackgroundColor(Color.RED);
        }
        else if (avg >60 && avg <80) {
            main.setBackgroundColor(Color.YELLOW);
        }
        else if (avg >=80 && avg <=100) {
            main.setBackgroundColor(Color.GREEN);
        }
    }
}