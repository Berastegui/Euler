package com.problems.factorials;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

public class SumOfDigits
{

    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int l = Integer.parseInt(bufferedReader.readLine().trim());

        //String s = bufferedReader.readLine();
        //bufferedReader.close();
        
       /* int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");*/
      /*  int[] sum = new int[t];
        int[] modulo = new int[t];
        
        for(int i=0;i<t;i++) {
            sum[i]=scanner.nextInt();
            modulo[i]=scanner.nextInt();
        }*/
        Date start = new Date();
        
        //System.out.println(s2);

        /*int[] result = getSums(sum,modulo);
        
        for(int r : result) {
            System.out.println(r);
        }*/
        
        //long r = sumOfSgs(40, 100000000);
        for(int i =0;i<50;i++) {
            System.out.println(g(i));
        }
        
        
        Date end = new Date();
        
        long timeInMilis = end.getTime()-start.getTime();
        System.out.println("time in miliseconds : "+timeInMilis);

        
        //System.out.println(sumOfSgs(3, 10000));
        
        //System.out.println(sumOfSgs(20, 100000));
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

    }

    private static int[] getSums(int[] sum, int[] modulo)
    {
        int n = sum.length;
        
        int[] result = new int[n];
        
        for(int i=0; i<n;i++) {
            result[i]=(int)sumOfSgs(sum[i], modulo[i]);
        }
        return result;
    }
    
    private static long sumOfSgs(int n, int modulo) {
        long sgn = 0;
        for(long i =1; i<=n;i++) {
            sgn = sgn+sg(i)%modulo;
        }
        return sgn;
    }
    
    private static long sg(long n) {
        long f = g(n);
        int i = (int) f%10;
        long sum = i;
        f = f/10;
        while(f>0) {
            i =(int) f%10;
            sum = sum + i;
            f = f/10;
        }
        return sum;
    }
    
    private static long g(long n) {
        Date start = new Date();
        long i = 0;
        long sf = sf(i);
        while(sf!=n) {
            i++;
            sf = sf(i);
        }
        Date end = new Date();
        
        long timeInMilis = end.getTime()-start.getTime();
        //System.out.println("time in miliseconds : "+timeInMilis);
        return i;
    }
    
    private static long sf(long n) {
        long f = f(n);
        int i = (int) f%10;
        long sum = i;
        f = f/10;
        while(f>0) {
            i =(int) f%10;
            sum = sum + i;
            f = f/10;
        }
        return sum;
    }
    
    private static long f(long n) {
        if(n==0) {
            return 0;
        }
        int i = (int)n%10;
        long sum = factorial(i);
        n = n/10;
        while(n>0) {
            i = (int)n%10;
            sum = sum + factorial(i);
            n = n/10;
        }
        return sum;
    }
    
    private static long factorial(int n ) {
        long f = 1;
        for(int i = 2; i<=n;i++) {
            f = f * i;
        }
        return f;
    }

}
