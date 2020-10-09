package com.problems.primes;

import java.util.Scanner;

public class AmicablesNumbers
{
    private static final Scanner scanner = new Scanner(System.in);
    private static int[] primeNumbers = new int[10000];
    private static int nbp = 0;
    private static int[] sumsOfFactors = new int[100001];
    private static int[] amicables = new int[26];
    private static int[] sumsOfAmicables = new int[100001];

    public static void main(String[] args)
    {
        set10000PrimeNumbers();
        setSumsOfFactors();
        fillAmicables();
        fillSumsOfAmicables();
        int t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = scanner.nextInt();
            System.out.println(sumsOfAmicables[n]);
        }
    }
    
    private static void fillSumsOfAmicables() {
        int sum = 0;
        int b=0;
        for(int i=0; i<100001;i++) {
            sum = 0;
            for(int a : amicables) {
                if(a>i) {
                    break;
                }
                b=sumsOfFactors[a];
                if(b<=i) {
                    sum = sum + a;
                }
            }
            sumsOfAmicables[i]=sum;
        }
    }
    
    private static void fillAmicables() {
        int nb = 0;
        for(int i=1;i<100001;i++) {
            if (isAmicable(i)) {
                amicables[nb]=i;
                nb++;
            }
        }
    }
    
    private static boolean isAmicable(int n) {
        if(n<2) {
            return false;
        }
        if(n>100000) {
            return false;
        }
        int m = sumsOfFactors[n];
        if(m>100000) {
            return false;
        }
        return n==sumsOfFactors[m]&&n!=m;
    }

    private static void setSumsOfFactors() {
        for(int i = 0; i<100001;i++) {
            sumsOfFactors[i]=getSumFactors(i);
        }
    }

    private static int getSumFactors(int n) {
        int nb = 1;
        int max= n;
        int power = 1, sum=1;
        for(int i : primeNumbers){
            if(i>n) {
                break;
            }
            power = 1;
            sum=1;
            while(n%i==0){
                power = power*i;
                sum = sum+power;
                n = n/i;
            }
            nb = nb * sum;
        }
        return nb-max;
    }
    
    private static int set10000PrimeNumbers() {
        int p = 2;
        setPrimeNumber(p);
        int nb = 1;
        while(nb<10000) {
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
