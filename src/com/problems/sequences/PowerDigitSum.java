package com.problems.sequences;

import java.math.BigInteger;
import java.util.Scanner;

public class PowerDigitSum
{
    private static final Scanner scanner = new Scanner(System.in);
    private static int[][] powers = new int[10001][5000];
    private static int[] sums = new int[10001];
    
    public static void main(String []argh){
        /*int t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = scanner.nextInt();
        }*/
        fillPowers();
        fillSums();
        
        for(int i=0;i<100;i++) {
           /* for(int j=0;j<100;j++) {
                System.out.print(powers[i][j]);
            }*/
            System.out.println(sums[i]);
        }
    }
    
    private static void fillPowers() {
        for(int i =0; i<10001;i++) {
            for(int j=0;j<5000;j++) {
                powers[i][j] = 0;
            }
        }
        powers[0][0] = 1;
        int d = 0;
        for(int i =1; i<10001;i++) {
            for(int j=0;j<5000;j++) {
                d = d + powers[i-1][j]*2;
                powers[i][j]=d%10;
                d=d/10;
            }
        }
    }
    
    private static void fillSums() {
        int sum = 0;
        for(int i =0; i<10001;i++) {
            sum = 0;
            for(int j=0;j<5000;j++) {
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
