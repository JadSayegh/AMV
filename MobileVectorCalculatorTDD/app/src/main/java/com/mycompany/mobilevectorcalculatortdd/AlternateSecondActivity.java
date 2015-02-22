package com.mycompany.mobilevectorcalculatortdd;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class AlternateSecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate_second);
        Intent intent = getIntent();

        // get the text view we are going to need to submit the vectorAdd answer
        TextView vectorAddAnswer = (TextView) findViewById(R.id.polarCoordinate_vectorRes);

        // set it to empty (in case this is the second time someone is calculating a new vector value
        // we want to make sure it is empty)
        vectorAddAnswer.setText(String.format(""));

        String action = intent.getStringExtra("action");
        if (action.equals("vector_add")) {
            PolarVector vectorSum = (PolarVector) intent.getSerializableExtra("result");
            // fill it with the vectorAdd value we calculated
            vectorAddAnswer.setText(String.format("The sum of the 3 vectors: Magnitude (%.2f), Angle (%.2f degrees)",
                    vectorSum.rval, vectorSum.theta));
        } else if (action.equals("vector_prod")) {
            Double vectorProd = intent.getExtras().getDouble("result");

            // fill it with the vectorAdd value we calculated
            vectorAddAnswer.setText(String.format("The vector product of the 2 vectors: %.2f",
                    vectorProd));

        } else if (action.equals("scalar_prod")) {
            Double scalarProd = intent.getExtras().getDouble("result");
            // fill it with the vectorAdd value we calculated
            vectorAddAnswer.setText(String.format("The scalar product of the 2 vectors: %.2f",
                    scalarProd));

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alternate_second, menu);
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


}
