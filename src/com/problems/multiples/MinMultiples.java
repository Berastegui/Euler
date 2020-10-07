package com.problems.multiples;

public class MinMultiples
{

    public static void main(String[] args)
    {
        System.out.println(getMinMultiple(100));

    }
    
    private static long getPGCD(long a, long b){
        long p = Math.min(a,b);
        long g = Math.max(a,b);
        long r = g%p;
        while(r!=0){
            g = p;
            p = r;
            r = g%p;
        }
        return p;
    }

    private static long getPPMC(long a , long b) {
        return a * b / getPGCD(a,b);
    }

    private static long getMinMultiple(int n) {
        long p = 1;
        for(int i = 1; i<=n;i++) {
            p = getPPMC(p,i);
        }
        return p;
    }

}
