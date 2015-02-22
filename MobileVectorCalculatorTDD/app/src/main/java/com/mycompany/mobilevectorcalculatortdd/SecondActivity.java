package com.mycompany.mobilevectorcalculatortdd;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        // get the text view we are going to need to submit the vectorAdd answer
        TextView vectorAddAnswer = (TextView) findViewById(R.id.cartesianCoordinate_vectorAdd);

        // set it to empty (in case this is the second time someone is calculating a new vector value
        // we want to make sure it is empty)
        vectorAddAnswer.setText(String.format("hello"));

        Vector vectorSum = (Vector) intent.getSerializableExtra("vector_sum");
        // fill it with the vectorAdd value we calculated
        vectorAddAnswer.setText(String.format("The sum of the 3 vectors: (%.2f, %.2f)",
                vectorSum.x, vectorSum.y));
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
}
