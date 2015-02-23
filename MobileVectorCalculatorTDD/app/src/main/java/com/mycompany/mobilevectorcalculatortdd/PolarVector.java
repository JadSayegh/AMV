package com.mycompany.mobilevectorcalculatortdd;

import java.io.Serializable;

    /**
     * Created by Manna on 2015-02-22.
     */
    public class PolarVector implements Serializable {


        double rval, theta;

        public PolarVector (double rval, double theta){

            this.rval = rval;
            this.theta = theta;


        }

    }
