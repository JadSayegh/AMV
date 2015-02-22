package com.mycompany.myfirstapp;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MyActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    //I'm still working on this code. I'm adding some temporary variables so that the code compiles if you test it

    double x1,x2,x3,x;
    double y1,y2,y3,y;
    
    Vector inputVector1 = new Vector(x1, y1);
    Vector inputVector2 = new Vector(x2, y2);
    Vector inputVector3 = new Vector(x3, y3);
    Vector outputVector = new Vector(x, y);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
     /*   ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        Tab tab = actionBar.newTab()
                .setText(R.string.artist)
                .setTabListener(new TabListener<ArtistFragment>(
                        this, "artist", ArtistFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText(R.string.album)
                .setTabListener(new TabListener<AlbumFragment>(
                        this, "album", AlbumFragment.class));
        actionBar.addTab(tab);
*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.v1);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }


    public Vector vectorAdd( Vector inputVector1,Vector inputVector2,Vector inputVector3){

        Intent intent = new Intent(this, DisplayMessageActivity.class);

        // find the input area and get its contents as a string
        EditText input =  (EditText) findViewById(R.id.v2);
        String inputBill = input.getText().toString();

        // if the area is empty, the display a message and return
       /* if (inputBill.matches("")) {
            Toast.makeText(this, "You did not enter a bill amount", Toast.LENGTH_SHORT).show();
            return;
        }
        */

        // the input is not empty, so we cast the string to a float
        float bill = Float.valueOf(inputBill);

        // get the radio button objects to check if they are selected
        RadioButton low = (RadioButton) findViewById(R.id.tip_radio_low);
        RadioButton mid = (RadioButton) findViewById(R.id.tip_radio_mid);

        // declare our tip variable
        float tip;

        // calculate the top according to button is selected
        if (low.isChecked()) {

            outputVector.x = (inputVector1.x+inputVector2.x+inputVector3.x);
            outputVector.y = (inputVector1.y+inputVector2.y+inputVector3.y);

            return outputVector;

        }    else if (mid.isChecked())
            tip = bill * 15 / 100;
        else
            tip = bill * 18 / 100;

        return outputVector;

        //TODO: Display our tip to the used
    }



}
