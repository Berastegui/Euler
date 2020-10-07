package com.problems.sequences;

import java.util.Scanner;

public class MaximumPathSum
{


    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String []argh){
        int n = scanner.nextInt();
        for(int k = 0;k<n; k++) {
            int t = scanner.nextInt();
            int[][] paths = new int[t][t];
            for(int i = 0; i < t; i++){
                for(int j = 0; j <=i; j++){
                    int m = scanner.nextInt();
                    paths[i][j] = m;
                }
            }
            
            System.out.println(getMaxPath(paths, t));
        }
        
    }
    
    private static int getMaxPath(int[][] paths, int t) {
        if(t==0) {
            return 0;
        }
        if(t==1) {
            return paths[0][0];
        }
        if(t==2) {
            return paths[0][0] + Math.max(paths[1][0], paths[1][1]);
        }
        
        int[][] paths1 = new int[t-1][t-1];
        int[][] paths2 = new int[t-1][t-1];
        
        for(int i = 0; i < t-1; i++){
            for(int j = 0; j <=i; j++){
                paths1[i][j] = paths[i+1][j];
                paths2[i][j] = paths[i+1][j+1];
            }
        }
        
        return paths[0][0] + Math.max(getMaxPath(paths1, t-1), getMaxPath(paths2, t-1));
        
    }
}
