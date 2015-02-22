package com.ecse428.jad.vector;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Jad on 2015-02-21.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;
    final double eps = 0.001; //maximum tolerable error in a double to allow for potential rounding difference

    public static void main(String[] args){
        MainActivityTest testcase = new MainActivityTest();

    }



    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();

        //TODO: initialise this activity
        //TODO: get UI element references
    }


    public void testPreconditions() {
        assertNotNull("activity is null", activity);

    }


    //==================== VALID INPUT TESTS ===========================

    public void testVectorAddCart() {
        Vector expected = new Vector(5, 8);
        Vector actual = activity.vectorAdd(new Vector(3, 13), new Vector(2, -5));
        assertEquals(actual.x, expected.x);
        assertEquals(actual.y, expected.y);

        expected = new Vector(7, 6);
        actual = activity.vectorAdd(new Vector(3, 13), new Vector(2, -5), new Vector(2, -2));
        assertEquals(actual.x, expected.x);
        assertEquals(actual.y, expected.y);



    }
    public void testVectorAddOrder() {
        Vector expected = new Vector(5, 8);
        Vector actual = activity.vectorAdd(new Vector(2, -5), new Vector(3, 13));
        assertEquals(actual.x, expected.x);
        assertEquals(actual.y, expected.y);
    }


    public void testVectorMult() {
        double expected = 8;
        double actual = activity.vectorMult(new Vector(2, 3), new Vector(-2, 1));
        assertEquals(actual, expected);
    }

    public void testVectorMultOrder() {
        double expected = - 8;
        double actual = activity.vectorMult(new Vector(-2, 1), new Vector(2, 3));
        assertEquals(actual, expected);

    }

    public void testScalarMult() {
        double expected = -1;
        double actual = activity.scalarMult(new Vector(-2, 1), new Vector(2, 3));
        assertEquals(actual, expected);

    }

    public void testScalarMultOrder() {
        double expected = -1;
        double actual = activity.scalarMult(new Vector(2, 3), new Vector(-2, 1));
        assertEquals(actual, expected);
    }


    public void testCartToPolar(){
        PolarVector expected = new PolarVector(5, Math.atan2(4, 3));
        PolarVector actual = activity.cartToPolar(new Vector(3,4));
        assertTrue(Math.abs(actual.theta - expected.theta) < eps);
        assertTrue(Math.abs(actual.r - expected.r) < eps);
    }

    public void testPolarToCart(){
        Vector expected = new Vector(3,4);
        Vector actual = activity.polarToCart(new PolarVector(5, Math.atan2(4, 3)));
        assertTrue(Math.abs(actual.x - expected.x) < eps);
        assertTrue(Math.abs(actual.y - expected.y) < eps);
    }

    //==================== INVALID INPUT TESTS ===========================

    public void testVectorMult_NullInput(){
        Double expected = null;
        Double actual = activity.vectorMult(new Vector(2, 3), null);
        assertEquals(actual, expected);
    }

    public void testScalarMult_NullInput(){
        Double expected = null;
        Double actual = activity.scalarMult(new Vector(2, 3), null);
        assertEquals(actual, expected);
    }

    public void testVectorAdd_NullInput(){
        Vector expected = null;
        Vector actual = activity.vectorAdd(null, new Vector(2, 3));
        assertEquals(actual, expected);
    }


    public void testCartToPolar_NullInput(){
        PolarVector expected = null;
        PolarVector actual = activity.cartToPolar(null);
        assertEquals(actual, expected);
    }

    public void testPolarToCart_NullInput(){
        Vector expected = null;
        Vector actual = activity.polarToCart(null);
        assertEquals(actual, expected);
    }


    //======================= UI Tests ==================
    @UiThreadTest
    public void testIncompleteInput(){
        Button calculate = (Button) activity.findViewById(R.id.button1);
        EditText editTextx1 = (EditText) activity.findViewById(R.id.x1);
        EditText editTextx2 = (EditText) activity.findViewById(R.id.x2);
        EditText editTextx3 = (EditText) activity.findViewById(R.id.x3);

        EditText editTexty1 = (EditText) activity.findViewById(R.id.y1);
        EditText editTexty2 = (EditText) activity.findViewById(R.id.y2);
        EditText editTexty3 = (EditText) activity.findViewById(R.id.y3);

        editTextx1.setText("1");
        editTextx2.setText("2");
        editTexty1.setText("3");
        editTexty2.setText("");

        RadioGroup radgroup = (RadioGroup)  activity.findViewById(R.id.cartesian_radio);
        
    }


    @UiThreadTest
    public void testVectorAddOutputDisplay(){
        EditText editTextx1 = (EditText) activity.findViewById(R.id.x1);
        EditText editTextx2 = (EditText) activity.findViewById(R.id.x2);
        EditText editTextx3 = (EditText) activity.findViewById(R.id.x3);

        EditText editTexty1 = (EditText) activity.findViewById(R.id.y1);
        EditText editTexty2 = (EditText) activity.findViewById(R.id.y2);
        EditText editTexty3 = (EditText) activity.findViewById(R.id.y3);





    }

    public void testVectorMultOutputDisplay(){
        EditText editTextx1 = (EditText) activity.findViewById(R.id.x1);
        EditText editTextx2 = (EditText) activity.findViewById(R.id.x2);
        EditText editTextx3 = (EditText) activity.findViewById(R.id.x3);

        EditText editTexty1 = (EditText) activity.findViewById(R.id.y1);
        EditText editTexty2 = (EditText) activity.findViewById(R.id.y2);
        EditText editTexty3 = (EditText) activity.findViewById(R.id.y3);


    }

    public void testScalarMultOutputDisplay(){
        EditText editTextx1 = (EditText) activity.findViewById(R.id.x1);
        EditText editTextx2 = (EditText) activity.findViewById(R.id.x2);
        EditText editTextx3 = (EditText) activity.findViewById(R.id.x3);

        EditText editTexty1 = (EditText) activity.findViewById(R.id.y1);
        EditText editTexty2 = (EditText) activity.findViewById(R.id.y2);
        EditText editTexty3 = (EditText) activity.findViewById(R.id.y3);


    }

}

