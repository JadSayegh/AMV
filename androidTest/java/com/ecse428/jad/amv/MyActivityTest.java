package com.ecse428.jad.amv;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Jad on 2015-02-21.
 */
public class MyActivityTest extends ActivityInstrumentationTestCase2<MyActivity> {


    MyActivity activity;

    public MyActivityTest() {
        super(MyActivity.class);
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
        double actual = activity.vectorMult(new Vector(-2, 1), new Vector(2, 3));
        assertEquals(actual, expected);

    }

    public void testScalarMultOrder() {
        double expected = -1;
        double actual = activity.vectorMult(new Vector(2, 3), new Vector(-2, 1));
        assertEquals(actual, expected);
    }

    //==================== INVALID INPUT TESTS ===========================

    public void testVectorMultNullInput(){
        Double expected = null;
        Double actual = activity.vectorMult(new Vector(2, 3), null);
        assertEquals(actual, expected);
    }

    public void testScalarMultNullInput(){
        Double expected = null;
        Double actual = activity.scalarMult(new Vector(2, 3), null);
        assertEquals(actual, expected);
    }

    public void testVectorAddNullInput(){
        Vector expected = null;
        Vector actual = activity.vectorAdd(null, new Vector(2, 3));
        assertEquals(actual, expected);
    }




}
