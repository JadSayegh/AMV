package com.mycompany.mobilevectorcalculatortdd;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    public Vector vectorAdd;
    public static double trial=5;

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
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editText1 = (EditText) findViewById(R.id.x1);
        String m1 = editText1.getText().toString();
        double v1x1 = Double.valueOf(m1);

        EditText editText2 = (EditText) findViewById(R.id.y1);
        String m2 = editText2.getText().toString();
        double v1y1 = Double.valueOf(m2);

        vectorAdd = cartesianCoordinate.vectorAdd(new Vector(v1x1,v1y1), new Vector(1,2), new Vector(4,5));

        intent.putExtra("vector_sum", vectorAdd);

        startActivity(intent);


    }

}
