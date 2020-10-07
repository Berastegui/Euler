package com.problems.sequences;

import java.util.Scanner;

public class Collatz
{

    private static final Scanner scanner = new Scanner(System.in);
    
    private static long[] ranks = new long[5000000];
    private static int[] lengths = new int[5000000];
    
    public static void main(String []argh){
        fillRanks();
        fillLengths();
       /* int t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = scanner.nextInt();
            System.out.println(getBiggestSequence(n));
        }*/
        long nb = 0;
        long nbmax= 0;
        int imax = 0;
        for(int i = 0; i<15;i++) {
            nb = ranks[i];
            if(nb>=nbmax) {
                nbmax=nb;
                imax = i;
            }
            System.out.print(imax+1+" ");
        }
        System.out.println();
        for(int i = 0; i<15;i++) {
            System.out.print(lengths[i]+" ");
        }
    }
    
    private static long getBiggestSequence(int n){
        /*long rank = 0, rankMax = 0;
        long imax = 0;
        for(long i=0; i<n; i++) {
            rank = ranks[(int)i];
            if(rank>= rankMax) {
                rankMax = rank;
                imax= i;
            }
        } */
        return lengths[n-1];
    }
    
    private static void fillLengths() {
        long nb = 0;
        long nbmax= 0;
        int imax = 0;
        for(int i = 0; i<15;i++) {
            nb = ranks[i];
            if(nb>=nbmax) {
                nbmax=nb;
                imax = i;
            }
            lengths[i]=imax +1;
        }
    }
    
    private static void fillRanks() {
        long nb = 0;
        long c = 0;
        ranks[0] = 1;
        for(long i=2; i<=5000000; i++) {
            nb = 0;
            c = i;
            while(c>5000000 || ranks[(int)(c-1)]==0){
                if(c%2==0){
                    c = c / 2;
                } else {
                    c = 3*c+1;
                }
                nb++;
            }
            ranks[(int)(i-1)]=ranks[(int)(c-1)]+nb;
            
        }
    }
}
