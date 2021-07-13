package com.fightzhong;

import java.util.HashMap;
import java.util.Map;

public class lc_0050_Pow {
    public double myPow(double x, int n) {
        long newN = n;
        newN = Math.abs( newN );
        Map<Long, Double> cache = new HashMap<>();
        return myPow2( n >= 0 ? x : 1 / x, newN, cache );
    }

    public double myPow2(double x, long n, Map<Long, Double> cache) {
        Double cacheValue = cache.get(n);
        if ( cacheValue != null ) {
            return cacheValue;
        } else if ( n == 0 ) {
            return 1;
        } else if ( n == 1 ) {
            return x;
        }

        double result = myPow2( x, n / 2, cache ) * myPow2( x, n - n / 2, cache );
        cache.put( n, result );
        return result;
    }
}
