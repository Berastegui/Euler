package com.problems.primes;

public class SumOfPrimes
{
    
    private static long[] primeNumbers = new long[100000];
    private static int nbp = 0;
    
    public static void main(String[] args)
    {

        
        set100000PrimeNumbers();
        System.out.println(primeNumbers[100000-1]);
    }
    
    private static boolean setPrimeNumber(long p) {
        if(p==1) {
            return false;
        }
        for(long pi : primeNumbers) {
            if(pi==0) {
                break;
            }
           if(p%pi==0) {
               return false;
           }
           if((pi*pi)>p) {
               break;
           }
        }
        primeNumbers[nbp]=p;
        nbp++;
        return true;
    }
    
    private static long set100000PrimeNumbers() {
        long p = 2;
        setPrimeNumber(p);
        int nb = 1;
        while(nb<100000) {
            p++;
            if(setPrimeNumber(p)) {
                nb++;
            }
        }
        return p;
    }

}
