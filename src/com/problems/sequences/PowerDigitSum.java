package com.problems.sequences;

import java.math.BigInteger;
import java.util.Date;
import java.util.Scanner;

public class PowerDigitSum
{
    
    private static final Scanner scanner = new Scanner(System.in);
    private static int p = 30000;
    private static int pd = p/3;
    private static short[][] powers = new short[p+1][pd];
    private static int[] sums = new int[p+1];
    
    public static void main(String []argh){
        Date start =new Date();
        fillPowers();
        Date end = new Date();
        
        long time = end.getTime() - start.getTime();
        System.out.println(sums[p]);
        
        System.out.println("time in milis : "+time);
    }
    
    private static void fillPowers() {
        int sum = 0;
        powers[0][0] = 1;
        int d = 0;
        int l =0;
        for(int i =1; i<p+1;i++) {
            l = i/3+1;
            sum = 0;
            for(int j=0;j<Math.min(l, pd);j++) {
                d = d + powers[i-1][j]*2;
                powers[i][j]=(short)(d%10);
                sum = sum +(d%10);
                d=d/10;
            }
            sums[i] =sum;
        }
    }
    
    private static void fillSums() {
        int sum = 0;
        for(int i =0; i<p+1;i++) {
            sum = 0;
            for(int j=0;j<pd;j++) {
                sum = sum +powers[i][j];
            }
            sums[i] =sum;
        }
    }
    
   /* private static void fillPowers() {
        BigInteger p = BigInteger.ONE;
        for(int i =0; i<10001;i++) {
            powers[i]=sumOfDigits(p);
            p = p.multiply(BigInteger.valueOf(2));
        }
    }
    
    private static long sumOfDigits(BigInteger p) {
        BigInteger p2 = p;
        long d = 0, sum = 0;
        while(p2.compareTo(BigInteger.ZERO)>0) {
            d = p2.mod(BigInteger.TEN).longValue();
            p2 = p2.divide(BigInteger.TEN);
            sum = sum + d;
        }
        return sum;
    }*/
}
