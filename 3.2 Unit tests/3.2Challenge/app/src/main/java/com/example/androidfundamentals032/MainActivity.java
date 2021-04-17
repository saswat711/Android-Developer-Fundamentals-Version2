 package com.example.androidfundamentals032;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

 /**
 * SimpleCalc is the initial version of SimpleCalcTest.  It has
 * a number of intentional oversights for the student to debug/fix,
 * including input validation (no input, bad number format, div by zero)
 *
 * In addition there is only one (simple) unit test in this app.
 * All the input validation and the unit tests are added as part of the lessons.
 *
 */
public class MainActivity extends Activity {

    private static final String TAG = "CalculatorActivity";


     private com.example.androidfundamentals032.Calculator mCalculator;

    protected EditText mOperandOneEditText;
    protected EditText mOperandTwoEditText;

    private TextView mResultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the calculator class and all the views
        mCalculator = new com.example.androidfundamentals032.Calculator();
        mResultTextView = findViewById(R.id.operation_result_text_view);
        mOperandOneEditText = findViewById(R.id.operand_one_edit_text);
        mOperandTwoEditText = findViewById(R.id.operand_two_edit_text);

    }

    /**
     * OnClick method called when the add Button is pressed.
     */
    public void onAdd(View view) {
        compute(com.example.androidfundamentals032.Calculator.Operator.ADD);
    }

    /**
     * OnClick method called when the subtract Button is pressed.
     */

    public void onSub(View view) {
        compute(com.example.androidfundamentals032.Calculator.Operator.SUB);
    }

    /**
     * OnClick method called when the divide Button is pressed.
     */
    public void onDiv(View view) {
        try {
                compute(com.example.androidfundamentals032.Calculator.Operator.DIV);
            } catch (IllegalArgumentException iae) {
                Log.e(TAG, "IllegalArgumentException", iae);
                mResultTextView.setText(getString(R.string.computationError));
            }
    }

    /**
     * OnClick method called when the multiply Button is pressed.
     */
    public void onMul(View view) {
        compute(com.example.androidfundamentals032.Calculator.Operator.MUL);
    }



     public Double calcButton() {
      double x=-6, y=1;
         return mCalculator.add(x,y);
     }


    private void compute(com.example.androidfundamentals032.Calculator.Operator operator) {

        double operandOne;
        double operandTwo;
        try {
            operandOne = getOperand(mOperandOneEditText);
            operandTwo = getOperand(mOperandTwoEditText);
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);
            mResultTextView.setText(getString(R.string.emptystring));
            return;
        }



        String result;
        switch (operator) {
            case ADD:
                result = String.valueOf(
                        mCalculator.add(operandOne, operandTwo));
                break;
            case SUB:
                result = String.valueOf(
                        mCalculator.sub(operandOne, operandTwo));
                break;
            case DIV:
              /* A breakpoint is enabled on DIV operator so that when ever the operand 2 is given 0
                 the app stops at the breakpoint
                 as the divisor can't be zero and the text field shows the divisor(operand 2) value is given 0
                */

                if(operandTwo==0) {
                    result = "The divisor is zero";
                    //The toast message not work on avd on higher android version avd.You can see its working when installed in the phone
                    Toast.makeText(this, "change Operand 2 from zero to another number", Toast.LENGTH_SHORT).show();

                }else{
                result = String.valueOf(
                        mCalculator.div(operandOne, operandTwo));
            } break;
            case MUL:
                result = String.valueOf(
                        mCalculator.mul(operandOne, operandTwo));
                break;
            default:
                result = getString(R.string.computationError);
                break;


        }
        mResultTextView.setText(result);

    }

    /**
     * @return the operand value entered in an EditText as double.
     */
    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }

    /**
     * @return the operand text which was entered in an EditText.
     */
    private static String getOperandText(EditText operandEditText) {
        return operandEditText.getText().toString();
    }


 }