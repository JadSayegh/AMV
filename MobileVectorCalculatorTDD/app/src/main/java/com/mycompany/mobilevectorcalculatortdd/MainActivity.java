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


    if (m1.length() == 0 || m2.length() == 0) {
        // One of the text boxes has invalid value
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

        if (m3.length() == 0 || m4.length() == 0) {
            // One of the text boxes has invalid value
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

                if (m5.length() == 0 && m6.length() == 0) {
                    vectorRes = vectorAdd(new Vector(v1x1,v1y1), new Vector(v2x2,v2y2));
                } else if (m5.length() == 0 || m6.length() == 0) {
                    // One of the text boxes has invalid value
                    return;
                } else {
                    double v3x3 = Double.valueOf(m5);
                    double v3y3 = Double.valueOf(m6);
                    vectorRes = vectorAdd(new Vector(v1x1,v1y1), new Vector(v2x2,v2y2), new Vector(v3x3,v3y3));

                }
                intent.putExtra("result", vectorRes);
                break;
            case R.id.scalar_product:
                intent.putExtra("action", "scalar_prod");
                scalarRes = scalarMult(new Vector(v1x1,v1y1), new Vector(v2x2,v2y2));
                intent.putExtra("result", scalarRes);
                break;
            case R.id.vector_product:
                intent.putExtra("action", "vector_prod");
                scalarRes = vectorMult(new Vector(v1x1,v1y1), new Vector(v2x2,v2y2));
                intent.putExtra("result", scalarRes);
                break;
            case -1:
                // Wrong ID
                break;
        }


        startActivity(intent);


    }



    public static Vector vectorAdd(Vector v1, Vector v2){
        return cartesianCoordinate.vectorAdd(v1, v2);
    }

    public static Vector vectorAdd(Vector v1, Vector v2, Vector v3){
        return cartesianCoordinate.vectorAdd(v1, v2, v3);
    }

    public static Double scalarMult(Vector v1, Vector v2){
        return cartesianCoordinate.scalarMult(v1, v2);
    }

    public static Double vectorMult(Vector v1, Vector v2){
        return cartesianCoordinate.vectorMult(v1, v2);
    }

    public static PolarVector cartToPolar(Vector v){
        return cartesianCoordinate.cartToPolar(v);

    }

    public static Vector polarToCart(PolarVector v){
        return cartesianCoordinate.polarToCart(v);
    }

}
