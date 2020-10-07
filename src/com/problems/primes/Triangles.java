package com.problems.primes;

public class Triangles
{
    private static int[] primeNumbers = new int[100000];
    private static int nbp = 0;

    public static void main(String[] args)
    {
        set100000PrimeNumbers();
        System.out.println(findTriangle(10));

    }

    private static int findTriangle(int n){
        int nb = 0, nb2 = 0;
        int t = 0;
        int i = 0;
        while(nb<n){
            t = t+i;
            System.out.println(i+" : "+t);
            nb = getNbFactors(t);
            nb2 = getNbFactors2(t);
            System.out.println(nb==nb2);
            if(nb>=n){
                return t;
            }
            i++;
        }
        return 0;
    }

    private static int getNbFactors(int n) {
        int nb = 0;
        int l = n/2;
        boolean reduce = true;
        for(int i = 1; i<=l; i++){
            if(n%i==0){
                nb++;
                reduce = false;
            } else if(reduce){
                l = n /(i+1);
            }
        }
        return nb;
    }

    private static int getNbFactors2(int n) {
        int nb = 1;
        int d = 1;
        for(int i : primeNumbers){
            if(i>n) {
                break;
            }
            d=1;
            while(n%i==0){
                d++;
                n = n/i;
            }
            nb = nb * d;
        }
        return nb-1;
    }
    
    private static int set100000PrimeNumbers() {
        int p = 2;
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
    
    private static boolean setPrimeNumber(int p) {
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

}
