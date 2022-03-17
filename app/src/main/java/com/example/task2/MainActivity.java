package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText GetValue1;
    private RadioGroup RadioGroup1;
    private RadioButton D2T,T2D;
    private TextView Display,Text,HeadLine;
    private Button ConvertBt;
    private float Sum;
    private Switch MainSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
        RadioGroupCheck();

        if (MainSwitch.isChecked()){
            MainSwitch.setText("Disable Temp Converter");
            HeadLine.setText("Temperature Converter");
            D2T.setText("°C To °F");
            T2D.setText("°F To °C");
            Display.setText("");
            GetValue1.setText("");
            OnClickTemp();
        }else{
            MainSwitch.setText("Enable Temp Converter");
            HeadLine.setText("Currency Converter");
            D2T.setText("$ To ৳");
            T2D.setText("৳ To $");
            Display.setText("");
            GetValue1.setText("");
            OnClickCurrency();
        }

        MainSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    MainSwitch.setText("Disable Temp Converter");
                    HeadLine.setText("Temperature Converter");
                    D2T.setText("°C To °F");
                    T2D.setText("°F To °C");
                    Display.setText("");
                    GetValue1.setText("");
                    OnClickTemp();

                }else{
                    MainSwitch.setText("Enable Temp Converter");
                    HeadLine.setText("Currency Converter");
                    D2T.setText("$ To ৳");
                    T2D.setText("৳ To $");
                    Display.setText("");
                    GetValue1.setText("");
                    OnClickCurrency();
                }
            }
        });


    }

    private void RadioGroupCheck() {
        RadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int switchChecked) {
                switch (switchChecked){
                    case R.id.Taka2Doller:
                        Display.setText("");
                        break;
                    case R.id.Doller2Taka:
                        Display.setText("");
                        break;
                }
            }
        });
    }

    private void OnClickTemp() {
        ConvertBt.setOnClickListener(view -> {
            String ValueSt= GetValue1.getText().toString();
            if(D2T.isChecked()){
                Display.setText("");
                if (ValueSt.equals("")){
                    Toast.makeText(MainActivity.this, "Invaild Value", Toast.LENGTH_LONG).show();
                }else{
                    Float ValueF=Float.parseFloat(ValueSt);
                    float Sum=(ValueF*9/5)+32;
                    String SumSt= String.format("%.2f", Sum);
                    Display.setText(SumSt+" °F");
                }
            }else if(T2D.isChecked()){
                Display.setText("");
                if (ValueSt.equals("")){
                    Toast.makeText(MainActivity.this, "Invaild Value", Toast.LENGTH_LONG).show();
                }else {
                    Float ValueF=Float.parseFloat(ValueSt);
                    float Sum=(ValueF-32)*5/9;
                    String SumSt= String.format("%.2f", Sum);
                    Display.setText(SumSt+" °C");
                }
            }else{
                Toast.makeText(MainActivity.this, "Select A Option", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void OnClickCurrency() {
        ConvertBt.setOnClickListener(view -> {
            String ValueSt= GetValue1.getText().toString();
            if(D2T.isChecked()){
                Display.setText("");
                if (ValueSt.equals("")){
                    Toast.makeText(MainActivity.this, "Invaild Value", Toast.LENGTH_LONG).show();
                }else{
                    Float ValueF=Float.parseFloat(ValueSt);
                    float Sum=ValueF*80;
                    String SumSt= String.format("%.2f", Sum);
                    Display.setText(SumSt+" ৳");
                }
            }else if(T2D.isChecked()){
                Display.setText("");
                if (ValueSt.equals("")){
                    Toast.makeText(MainActivity.this, "Invaild Value", Toast.LENGTH_LONG).show();
                }else {
                    Float ValueF=Float.parseFloat(ValueSt);
                    float Sum=ValueF/80;
                    String SumSt= String.format("%.2f", Sum);
                    Display.setText(SumSt+" $");
                }
            }else{
                Toast.makeText(MainActivity.this, "Select A Option", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initial() {
        GetValue1=findViewById(R.id.EditText1);
        RadioGroup1=findViewById(R.id.RadioGroup1);
        Display=findViewById(R.id.Display);
        ConvertBt=findViewById(R.id.ConvertBt);
        D2T=findViewById(R.id.Doller2Taka);
        T2D=findViewById(R.id.Taka2Doller);
        MainSwitch=findViewById(R.id.MainSwitch);
        HeadLine=findViewById(R.id.HeadLine);
    }
}