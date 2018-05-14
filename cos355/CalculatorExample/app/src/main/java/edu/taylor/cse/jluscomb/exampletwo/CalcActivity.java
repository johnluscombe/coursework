package edu.taylor.cse.jluscomb.exampletwo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalcActivity extends Activity {
    EditText op1, op2;
    Spinner operator;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        op1 = (EditText)findViewById(R.id.op1);
        op2 = (EditText)findViewById(R.id.op2);
        operator = (Spinner)findViewById(R.id.operator);
        result = (TextView)findViewById(R.id.result);
    }

    public void calc(View v) {
        Integer calculatedResult = 0;
        int op1Value = Integer.parseInt(op1.getText().toString());
        int op2Value = Integer.parseInt(op2.getText().toString());
        char operatorValue = operator.getSelectedItem().toString().charAt(0);

        switch(operatorValue) {
            case '+':
                calculatedResult = op1Value + op2Value;
                break;
            case '-':
                calculatedResult = op1Value - op2Value;
                break;
            case '*':
                calculatedResult = op1Value * op2Value;
                break;
            case '/':
                calculatedResult = op1Value / op2Value;
                break;
        }

        result.setText(calculatedResult.toString());
    }
}
