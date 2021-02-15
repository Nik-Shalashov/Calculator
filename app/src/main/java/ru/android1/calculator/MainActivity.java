package ru.android1.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ButtonsProcessing calculator;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numbersID = new int[] {
                R.id.button1,
                R.id.button2,
                R.id.button3,
                R.id.button4,
                R.id.button5,
                R.id.button6,
                R.id.button7,
                R.id.button8,
                R.id.button9,
                R.id.button0,
                R.id.buttonPoint
        };

        int[] actionsID = new int[] {
                R.id.buttonAddition,
                R.id.buttonSubtraction,
                R.id.buttonMultiply,
                R.id.buttonDivide,
                R.id.buttonResult,
        };

        textView = findViewById(R.id.view_result);
        calculator = new ButtonsProcessing();

        View.OnClickListener onNumberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onNumberClick(v.getId());
                textView.setText(calculator.getText());
            }
        };

        View.OnClickListener onActionClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onActionClick(v.getId());
                textView.setText(calculator.getText());
            }
        };

        for (int i : numbersID) {
            findViewById(i).setOnClickListener(onNumberClickListener);
        }

        for (int i : actionsID) {
            findViewById(i).setOnClickListener(onActionClickListener);
        }

        findViewById(R.id.buttonFullClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.reset();
                textView.setText(calculator.getText());
            }
        });
    }
}