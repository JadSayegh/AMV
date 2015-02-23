package com.ecse428.jad.vector;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends ActionBarActivity {


    boolean active = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void sendMessage1(View view) {

        Vector vectorRes;

        double v1x1;
        double v1y1;
        double v2x2;
        double v2y2;



        Intent intent = new Intent(this, SecondActivity.class);

        //Take the user input values for Vector 1
        EditText editText1 = (EditText) findViewById(R.id.x1);
        String m1 = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.y1);
        String m2 = editText2.getText().toString();


    if (m1.isEmpty() || m2.isEmpty()) {
        // One of the text boxes has invalid value
        if(m1.isEmpty()){
            editText1.setError("Invalid input");
        }
        if(m2.isEmpty()){
            editText2.setError("Invalid input");
        }
        return;
    } else {
        v1x1 = Double.valueOf(m1);
        v1y1 = Double.valueOf(m2);
    }
        //Take the user input values for Vector 2
        EditText editText3 = (EditText) findViewById(R.id.x2);
        String m3 = editText3.getText().toString();
        EditText editText4 = (EditText) findViewById(R.id.y2);
        String m4 = editText4.getText().toString();

        if (m3.isEmpty() || m4.isEmpty()) {
            // One of the text boxes has invalid value
            if(m3.isEmpty()){
                editText3.setError("Invalid input");
            }
            if(m4.isEmpty()){
                editText4.setError("Invalid input");
            }
            active = true;
            return;
        } else {
            v2x2 = Double.valueOf(m3);
            v2y2 = Double.valueOf(m4);
        }

        RadioGroup rg = (RadioGroup)  findViewById(R.id.cartesian_radio);
        int selID = rg.getCheckedRadioButtonId();

        double scalarRes;
        switch (selID) {
            case R.id.vector_addition:
                intent.putExtra("action", "vector_add");
     //           intent.putDouble
                //Take the user input values for Vector 3
                EditText editText5 = (EditText) findViewById(R.id.x3);
                String m5 = editText5.getText().toString();

                EditText editText6 = (EditText) findViewById(R.id.y3);
                String m6 = editText6.getText().toString();

                if (m5.isEmpty() && m6.isEmpty()) {
                    vectorRes = cartesianCoordinate.vectorAdd(new Vector(v1x1,v1y1), new Vector(v2x2,v2y2));
                } else if (m5.isEmpty() || m6.isEmpty()) {
                    // One of the text boxes has invalid value
                    return;
                } else {
                    double v3x3 = Double.valueOf(m5);
                    double v3y3 = Double.valueOf(m6);
                    vectorRes = cartesianCoordinate.vectorAdd(new Vector(v1x1,v1y1), new Vector(v2x2,v2y2), new Vector(v3x3,v3y3));

                }
                intent.putExtra("result", vectorRes);
                break;
            case R.id.scalar_product:
                intent.putExtra("action", "scalar_prod");
                scalarRes = cartesianCoordinate.scalarMult(new Vector(v1x1,v1y1), new Vector(v2x2,v2y2));
                intent.putExtra("result", scalarRes);
                break;
            case R.id.vector_product:
                intent.putExtra("action", "vector_prod");
                scalarRes = cartesianCoordinate.vectorMult(new Vector(v1x1,v1y1), new Vector(v2x2,v2y2));
                intent.putExtra("result", scalarRes);
                break;
            case -1:
                // Wrong ID
                break;
        }


        startActivity(intent);


    }


    public void sendMessage2(View view) {

        Vector vectorRes;

        double v1r1;
        double v1a1;
        double v2r2;
        double v2a2;



        Intent intent = new Intent(this, AlternateSecondActivity.class);

        //Take the user input values for Vector 1
        EditText editText1 = (EditText) findViewById(R.id.px1);
        String m1 = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.py1);
        String m2 = editText2.getText().toString();


        if (m1.isEmpty() || m2.isEmpty()) {
            // One of the text boxes has invalid value
            if (m1.isEmpty()) {
                editText1.setError("Invalid input");
            }
            if (m2.isEmpty()) {
                editText2.setError("Invalid input");
            }

            return;
        } else {
            v1r1 = Double.valueOf(m1);
            v1a1 = Double.valueOf(m2);
        }
        //Take the user input values for Vector 2
        EditText editText3 = (EditText) findViewById(R.id.px2);
        String m3 = editText3.getText().toString();
        EditText editText4 = (EditText) findViewById(R.id.py2);
        String m4 = editText4.getText().toString();

        if (m3.isEmpty() || m4.isEmpty()) {
            // One of the text boxes has invalid value
            if (m3.isEmpty()) {
                editText3.setError("Invalid input");
            }
            if (m4.isEmpty()) {
                editText4.setError("Invalid input");
            }
            return;
        } else {
            v2r2 = Double.valueOf(m3);
            v2a2 = Double.valueOf(m4);
        }

        RadioGroup rg = (RadioGroup)  findViewById(R.id.cartesian_radio);
        int selID = rg.getCheckedRadioButtonId();

        double scalarRes;
        switch (selID) {
            case R.id.vector_addition:
                intent.putExtra("action", "vector_add");
                //           intent.putDouble
                //Take the user input values for Vector 3
                EditText editText5 = (EditText) findViewById(R.id.px3);
                String m5 = editText5.getText().toString();

                EditText editText6 = (EditText) findViewById(R.id.py3);
                String m6 = editText6.getText().toString();

                if (m5.isEmpty() && m6.isEmpty()) {
                    vectorRes = cartesianCoordinate.vectorAdd(PolarCoordinate.polarToCartesian(new PolarVector(v1r1, v1a1)),
                            PolarCoordinate.polarToCartesian(new PolarVector(v2r2, v2a2)));
                } else if (m5.isEmpty() || m6.isEmpty()) {
                    // One of the text boxes has invalid value
                    if (m5.isEmpty()) {
                        editText5.setError("Invalid input");
                    }
                    if (m6.isEmpty()) {
                        editText6.setError("Invalid input");
                    }
                    return;
                } else {
                    double v3r3 = Double.valueOf(m5);
                    double v3a3 = Double.valueOf(m6);
                    vectorRes = cartesianCoordinate.vectorAdd(PolarCoordinate.polarToCartesian(new PolarVector(v1r1, v1a1)),
                            PolarCoordinate.polarToCartesian(new PolarVector(v2r2, v2a2)),
                            PolarCoordinate.polarToCartesian(new PolarVector(v3r3, v3a3)));

                }

                intent.putExtra("result", PolarCoordinate.cartesianToPolar(vectorRes));
                break;
            case R.id.scalar_product:
                intent.putExtra("action", "scalar_prod");
                scalarRes = cartesianCoordinate.scalarMult(PolarCoordinate.polarToCartesian(new PolarVector(v1r1, v1a1)),
                        PolarCoordinate.polarToCartesian(new PolarVector(v2r2, v2a2)));
                intent.putExtra("result", scalarRes);
                break;
            case R.id.vector_product:
                intent.putExtra("action", "vector_prod");
                scalarRes = cartesianCoordinate.vectorMult(PolarCoordinate.polarToCartesian(new PolarVector(v1r1, v1a1)),
                        PolarCoordinate.polarToCartesian(new PolarVector(v2r2, v2a2)));
                intent.putExtra("result", scalarRes);
                break;
            case -1:
                // Wrong ID
                break;
        }


        startActivity(intent);


    }


}
