package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    Button btPlus, btMinus, btMul, btDev, btEqual, btClear;
    TextView textView;
    int num1, num2, operat;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        btPlus = findViewById(R.id.btPlus);
        btMinus = findViewById(R.id.btMinus);
        btMul = findViewById(R.id.btMul);
        btDev = findViewById(R.id.btDev);
        btEqual = findViewById(R.id.btEqual);
        btClear = findViewById(R.id.btClear);
        textView = findViewById(R.id.textView);

        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        btPlus.setOnClickListener(this);
        btMinus.setOnClickListener(this);
        btMul.setOnClickListener(this);
        btDev.setOnClickListener(this);
        btEqual.setOnClickListener(this);
        btClear.setOnClickListener(this);

        num1 = 0;
        num2 = 0;
        operat = 0;
        result = 0;

        textView.setText(Integer.toString(num1));
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt0:
                ClickNumber(0);
                break;
            case R.id.bt1:
                ClickNumber(1);
                break;
            case R.id.bt2:
                ClickNumber(2);
                break;
            case R.id.bt3:
                ClickNumber(3);
                break;
            case R.id.bt4:
                ClickNumber(4);
                break;
            case R.id.bt5:
                ClickNumber(5);
                break;
            case R.id.bt6:
                ClickNumber(6);
                break;
            case R.id.bt7:
                ClickNumber(7);
                break;
            case R.id.bt8:
                ClickNumber(8);
                break;
            case R.id.bt9:
                ClickNumber(9);
                break;
            case R.id.btClear:
                num1 = 0;
                num2 = 0;
                operat = 0;
                result = 0;
                textView.setText(Integer.toString(num1));
                break;
            case R.id.btPlus:
                operat = 1;
                break;
            case R.id.btMinus:
                operat = 2;
                break;
            case R.id.btMul:
                operat = 3;
                break;
            case R.id.btDev:
                operat = 4;
                break;
            case R.id.btEqual:
                switch (operat){
                    case 1:
                        result = num1 + num2;
                        textView.setText(Double.toString(result));
                        break;
                    case 2:
                        result = num1 - num2;
                        textView.setText(Double.toString(result));
                        break;
                    case 3:
                        result = num1 * num2;
                        textView.setText(Double.toString(result));
                        break;
                    case 4:
                        if(num2 == 0){
                            textView.setText("На 0 делить нельзя");
                            break;
                        }
                        else {
                            result = num1 / num2;
                            textView.setText(Double.toString(result));
                            break;
                        }
                }
                num1 = 0;
                num2 = 0;
                operat = 0;
                result = 0;
                break;
        }
    }

    public void ClickNumber(int num){
        if(operat==0){
            num1 = num1*10 + num;
            textView.setText(Integer.toString(num1));
        }
        else {
            num2 = num2*10 + num;
            textView.setText(Integer.toString(num2));
        }
    }
}
