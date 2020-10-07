package com.problems.fibonacci;

import java.util.ArrayList;

public class FibonacciPair
{
    private static ArrayList<Long> fib = new ArrayList<Long>();

    public static void main(String[] args)
    {
        System.out.println(sumPairFibonacci(100));

    }
    
    private static long sumPairFibonacci(long f0) {
        long f = 1;
        int i = 2;
        long sum = 0;
        while(f<f0) {
            if(f%2==0) {
                sum = sum +f;
            }
            f = fibonacci(i);
            i++;
        }
        return sum;
    }
    
    private static long fibonacci(int n) {
        
        if(fib.size()>n) {
            return fib.get(n);
        }
        
        if(n==0) {
            fib.add(0l);
            return 0;
        }
        if(n==1) {
            fib.add(1l);
            return 1;
        }
        
        long f = fibonacci(n-2)+fibonacci(n-1);
        
        fib.add(f);
        
        return f;
    }

}
