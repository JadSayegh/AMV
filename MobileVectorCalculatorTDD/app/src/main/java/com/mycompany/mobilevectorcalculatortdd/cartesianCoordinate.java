package com.ecse428.jad.vector;


/**
 * Created by Manna on 2015-02-21.
 */
public class cartesianCoordinate {

    static double x,y;

    static Vector outputVector = new Vector(x,y);

    public static Vector vectorAdd(Vector inputVector1,Vector inputVector2,Vector inputVector3){
        if(inputVector1 == null || inputVector2 == null || inputVector3 == null) return null;
        outputVector.x = (inputVector1.x+inputVector2.x+inputVector3.x);
        outputVector.y = (inputVector1.y+inputVector2.y+inputVector3.y);

        return outputVector;

    }

    public static Vector vectorAdd(Vector inputVector1,Vector inputVector2){
        if(inputVector1 == null || inputVector2 == null) return null;
        outputVector.x = (inputVector1.x+inputVector2.x);
        outputVector.y = (inputVector1.y+inputVector2.y);

        return outputVector;

    }

    public static Double scalarMult (Vector inputVector1,Vector inputVector2){
        if(inputVector1 == null || inputVector2 == null) return null;
        x = (inputVector1.x*inputVector2.x);
        y = (inputVector1.y*inputVector2.y);

        return (x+y);

    }

    public static Double vectorMult (Vector inputVector1,Vector inputVector2){
        if(inputVector1 == null || inputVector2 == null) return null;
        x = ((inputVector1.x*inputVector2.y)-(inputVector1.y*inputVector2.x));

        return x;

    }


    public static PolarVector cartToPolar(Vector v){
        if( v== null) return null;

        double r = Math.sqrt(v.x*v.x + v.y*v.y);
        double theta = Math.atan2(v.y, v.x);

        return new PolarVector(r, theta);


    }

    public static Vector polarToCart(PolarVector v){
        if( v== null) return null;

        double x = v.r*Math.cos(v.theta);
        double y = v.r*Math.sin(v.theta);

        return new Vector(x, y);
    }




}
