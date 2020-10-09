package com.problems.primes;

import java.util.HashSet;
import java.util.Scanner;

public class AbundantNumbers
{
    private static final Scanner scanner = new Scanner(System.in);
    private static int[] primeNumbers = new int[10000];
    private static int nbp = 0;
    private static int[] sumsOfFactors = new int[28124];
    private static int[] abundants = new int[6965];
    private static HashSet<Integer> sumsOfAmbundants = new HashSet<Integer>();

    public static void main(String[] args)
    {
        set10000PrimeNumbers();
        setSumsOfFactors();
        fillAbundants();
        fillSumsOfAbundants();
        int t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = scanner.nextInt();
            System.out.println(sumsOfAmbundants.contains(n)?"YES":"NO");
        }
        for(int i : sumsOfAmbundants) {
            if(i%2==1)System.out.println(i);
        }
        
    }
    
    private static void fillSumsOfAbundants() {
        int sum = 0;
        for(int i:abundants) {
            for(int j:abundants) {
                sum = i +j;
                if(sum<=28124)
                sumsOfAmbundants.add(sum);
            }
        }
    }
    
    private static void fillAbundants() {
        int nb = 0;
        for(int i=1;i<28124;i++) {
            if (isAbundant(i)) {
                abundants[nb]=i;
                nb++;
            }
        }
    }
    
    private static boolean isAbundant(int n) {
        if(n<2) {
            return false;
        }
        int m = sumsOfFactors[n];
        return m>n;
    }

    private static void setSumsOfFactors() {
        for(int i = 0; i<28124;i++) {
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
