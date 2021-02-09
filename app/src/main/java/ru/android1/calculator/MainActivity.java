package ru.android1.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ButtonsProcessing calculator;
    private TextView resultField;
    private EditText workField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numbersID = new int[]{R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.buttonPoint};

        int[] operationsID = new int[]{R.id.buttonAddition, R.id.buttonSubtraction, R.id.buttonMultiply, R.id.buttonDivide};

        calculator = new ButtonsProcessing();
        resultField = findViewById(R.id.view_result);


        View.OnClickListener onNumberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onNumberClick(v.getId());
                workField.setText(calculator.getText());
            }
        };

        View.OnClickListener onActionClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onActionClick(v.getId());
                workField.setText(calculator.getText());
            }
        };

        for (int i : numbersID) {
            findViewById(i).setOnClickListener(onNumberClickListener);
        }

        for (int i : operationsID) {
            findViewById(i).setOnClickListener(onActionClickListener);

        }

    }
}
