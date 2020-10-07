package com.problems.bignumbers;

import java.util.Scanner;

public class SumOfBigIntegers
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        String[] numbers = new String[t];
        for(int a0 = 0; a0 < t; a0++){
            numbers[a0] = scanner.next();
        }
        System.out.println(getSum(t,numbers));
    }

    private static String getSum(int n , String[] numbers){
        int[] sums = new int[10];
        for(int i = 0; i<10; i++){
            sums[i] = 0;
            for(String number : numbers){
                sums[i] = sums[i] + Integer.parseInt(number.substring(5*i,5*i+5));
            }
        }
        int r = 0;
        for(int i = 9; i>=0; i--){
            sums[i] = sums[i] +r;
            r = sums[i]/100000;
            if(i>0) {
                sums[i] = sums[i]-r*100000;
            }
        }

        String result = sums[0]+"";
        while(result.length()<5) {
            result = "0"+result;
        }
        String result2 = sums[1]+"";
        while(result2.length()<5) {
            result2 = "0"+result2;
        }
        result = result + result2;
        return result.substring(0,10);
    }
}
