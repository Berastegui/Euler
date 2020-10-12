package com.problems.fibonacci;

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciNbDigits
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final int nbf = 23923;
    private static final int nbd = 5000;
    private static short[][] fib = new short[nbf][nbd + 1];
    private static int[] sums = new int[nbf];

    public static void main(String[] args)
    {
        fillFib();
        fillSum();
        /*
        int t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = scanner.nextInt();
            System.out.println(sums[n]);
        }
        */
        System.out.println(sums[5000]);
    }
    
    private static void fillSum() {
        sums[0]=0;
        int s = 1;
        int l =0;
        for(int i =1; i<nbf;i++) {
            l = Math.min(i/4+1, nbd);
            for(int j=l;j>=0;j--) {
                if(fib[i][j]>0 && (j+1)>=s) {
                    sums[s]=i;
                    s++;
                }
            }
        }
    }
    
    private static void fillFib() {
        fib[1][0] = 1;
        int d = 0;
        int l =0;
        for(int i =2; i<nbf;i++) {
            l = i/4+1;
            for(int j=0;j<Math.min(l, nbd+1);j++) {
                d = d + fib[i-1][j]+ fib[i-2][j];
                fib[i][j]=(short)(d%10);
                d=d/10;
            }
        }
    }

}
