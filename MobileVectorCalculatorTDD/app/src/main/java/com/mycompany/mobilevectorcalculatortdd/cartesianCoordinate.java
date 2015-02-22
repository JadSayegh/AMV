package com.mycompany.mobilevectorcalculatortdd;


/**
 * Created by Manna on 2015-02-21.
 */
public class cartesianCoordinate {

    static double x,y;

    static Vector outputVector = new Vector(x,y);

    public static Vector vectorAdd(Vector inputVector1,Vector inputVector2,Vector inputVector3){

        outputVector.x = (inputVector1.x+inputVector2.x+inputVector3.x);
        outputVector.y = (inputVector1.y+inputVector2.y+inputVector3.y);

        return outputVector;

    }

    public static Vector vectorAdd(Vector inputVector1,Vector inputVector2){

        outputVector.x = (inputVector1.x+inputVector2.x);
        outputVector.y = (inputVector1.y+inputVector2.y);

        return outputVector;

    }

    public static double scalarMult (Vector inputVector1,Vector inputVector2){

        x = (inputVector1.x*inputVector2.x);
        y = (inputVector1.y*inputVector2.y);

        return (x+y);

    }

    public double vectorMult (Vector inputVector1,Vector inputVector2){

        x = ((inputVector1.x*inputVector2.y)-(inputVector1.y*inputVector2.x));

        return x;

    }




}
