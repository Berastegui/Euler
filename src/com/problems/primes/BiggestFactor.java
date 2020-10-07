package com.problems.primes;

import java.util.ArrayList;

public class BiggestFactor
{
    private static ArrayList<Long> primes = new ArrayList<Long>();

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println(setSmallerPrimeNumbers(5000));

    }
    
    private static long getBiggestPrimeNumber(long p) {
        if(primes.contains(p)){
            return p;
        }
        for(long pi : primes){
            while(p%pi==0){
                p=p/pi;
                if(primes.contains(p)){
                    return p;
                }
            }
        }
        return 0;
    }
    
    private static boolean setPrime(long p) {
        if(p==1) {
            return false;
        }
        if(primes.contains(p)) {
            return true;
        }
        for(long pi : primes) {
           if(p%pi==0) {
               return false;
           }
           if((pi*pi)>p) {
               break;
           }
        }
        primes.add(p);
        return true;
    }


    private static long setSmallerPrimeNumbers(long p) {
        long n = (long)Math.sqrt(p)+1;
        long p2 = 2;
        for(long i = 2; i<n; i++) {
            if(setPrime(i) && p%i==0) {
                p2 = i;
                while(p%i==0)
                    p=p/i;
                    n = (long)Math.sqrt(p)+1;
            }
        }
        if(setPrime(p)) {
            p2 = p;
        } 
        return p2;
    }
    
    private static long getNthPrimeNumber(int n) {
        long p = 2;
        setPrime(p);
        int nb = 1;
        while(nb<n) {
            p++;
            if(setPrime(p)) {
                nb++;
            }
        }
        return p;
    }

}
