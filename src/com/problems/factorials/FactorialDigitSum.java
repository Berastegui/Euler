package com.problems.factorials;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialDigitSum
{
    private static final Scanner scanner = new Scanner(System.in);
    private static int[][] factorials = new int[1001][3000];
    private static int[] sums = new int[1001];
    
    public static void main(String []argh){
        /*int t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = scanner.nextInt();
        }*/
        fillFactorials();
        fillSums();
        
        for(int i=0;i<100;i++) {
           /* for(int j=0;j<100;j++) {
                System.out.print(powers[i][j]);
            }*/
            System.out.println(sums[i]);
        }
    }
    
    private static void fillFactorials() {
        for(int i =0; i<1001;i++) {
            for(int j=0;j<3000;j++) {
                factorials[i][j] = 0;
            }
        }
        factorials[0][0] = 1;
        int d = 0;
        for(int i =1; i<1001;i++) {
            for(int j=0;j<3000;j++) {
                d = d + factorials[i-1][j]*i;
                factorials[i][j]=d%10;
                d=d/10;
            }
        }
    }
    
    private static void fillSums() {
        int sum = 0;
        for(int i =0; i<1001;i++) {
            sum = 0;
            for(int j=0;j<3000;j++) {
                sum = sum +factorials[i][j];
            }
            sums[i] =sum;
        }
    }
}
