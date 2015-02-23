package com.ecse428.jad.vector;


import java.lang.Math;

/**
 * Created by Manna on 2015-02-22.
 */
public class PolarCoordinate {


    public static Vector polarToCartesian(PolarVector pv){
        if(pv==null) return null;
        Vector v = new Vector(0,0);
        v.x = pv.rval*Math.cos(Math.toRadians(pv.theta));
        v.y = pv.rval*Math.sin(Math.toRadians(pv.theta));
        return v;
    }


    public static PolarVector cartesianToPolar(Vector v){
        if(v==null) return null;
        PolarVector pv = new PolarVector(0,0);
        pv.rval = Math.sqrt(Math.pow(v.x,2) + Math.pow(v.y, 2));
        pv.theta = Math.toDegrees(Math.atan2(v.y, v.x));
        return pv;
    }
}
