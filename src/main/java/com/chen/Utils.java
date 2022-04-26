package com.chen;

import java.text.DecimalFormat;

public  class Utils {

    public static float s1(float a){
        DecimalFormat df = new DecimalFormat("#.00");
        String str = df.format(a);
        return Float.parseFloat(str);
    }
}
