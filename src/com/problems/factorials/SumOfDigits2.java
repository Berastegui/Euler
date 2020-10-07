package com.problems.factorials;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SumOfDigits2
{

    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        long  g = 0;
        long sum = 0;
        for(int i =0;i<45;i++) {
            g = g2(i);
            sum = sum+ findSumOfDigits(g);
            System.out.println(i+" "+findSumOfDigits(g)+" "+sum);
        }
    }
    
    private static long g2(long n) {
        long p = 0, s =0;
        int nbd = 1,nb=9,k=0, d =0;
        long result =0;
        while(s!=n) {
            for(int i =0;i<nb;i++) {
                p = 0;
                result = 0;
                k=i;
                for(int j=0;j<nbd;j++) {
                    d = k%9+1;
                    p = p +fact(d);
                    result = result*10 +(d);
                    k = k/9;
                }
                s = findSumOfDigits(p);
                if(s==n) {
                    return result;
                }
            }
            nbd ++;
            nb = nb * 9;
        }
        return -1;
    }
    
    private static long factorial(long n ) {
        long f = 1;
        for(long i = 2; i<=n;i++) {
            f = f * i;
        }
        return f;
    }
    
    private static long fact(int n) {
        switch(n)
        {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 6;
            case 4:
                return 24;
            case 5:
                return 120;
            case 6:
                return 720;
            case 7:
                return 5040;
            case 8:
                return 40320;
            case 9:
                return 362880;

            default:
                return factorial(n);
        }
    }
    
    private static long findSumOfDigits(long n) {
        long d = n;
        
        long result = 0;
        
        while(d>0) {
            result = result +d%10;
            d = d/10;
        }
        return result;
    }
    

    
    private static long g(long n) {
        long i = 0;
        long sf = sf(i);
        while(sf!=n) {
            i++;
            sf = sf(i);
        }
        return i;
    }
    
    private static long sf(long n) {
        long f = f(n);
        int i = (int) f%10;
        long sum = i;
        f = f/10;
        while(f>0) {
            i =(int) f%10;
            sum = sum + i;
            f = f/10;
        }
        return sum;
    }
    
    private static long f(long n) {
        if(n==0) {
            return 0;
        }
        int i = (int)n%10;
        long sum = factorial(i);
        n = n/10;
        while(n>0) {
            i = (int)n%10;
            sum = sum + factorial(i);
            n = n/10;
        }
        return sum;
    }
}
