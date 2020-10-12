package com.problems.strings;

import java.util.Scanner;

public class LexicographicPermutations
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final String  alpha = "abcdefghijklm";

    public static void main(String[] args)
    {
        int t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = scanner.nextLong();
            String toPermute = alpha;
            System.out.println(getPerm(n, 12, toPermute));
        }

    }
    
    private static String getPerm(long n, int nbChar, String toPermute) {
        if(nbChar==0) {
            return toPermute;
        }
        if(factorial(nbChar)>n) {
            return toPermute.charAt(0)+getPerm(n, nbChar-1, toPermute.substring(1));
        }
        long n0 = factorial(nbChar);
        long rank = (n-1)/n0;
        char a = toPermute.charAt((int)rank);
        toPermute = toPermute.replace(a+"", "");
        return a+getPerm(n-rank*n0, nbChar-1, toPermute);
    }
    
    private static long factorial(int n) {
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
            case 10:
                return 3628800;
            default:
                return factorial(n-1)*(long)n;
        }
    }
    

}
