package com.problems.strings;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NamesScores
{
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> names = new ArrayList<String>();

    public static void main(String[] args)
    {
        int t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String name = scanner.next();
            names.add(name);
        }
        sortNames();
        t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String name = scanner.next();
            System.out.println((names.indexOf(name)+1)*getWorth(name));
        }
    }
    
    private static int getWorth(String name) {
        char[] letters = name.toLowerCase().toCharArray();
        int sum =0;
        for(char l: letters) {
            sum = sum +l-96;
        }
        return sum;
    }
    
    private static void sortNames()
    {
        names = new ArrayList<String>(names.stream().sorted().collect(Collectors.toList()));
    }
}

/**
 * 
5
ALEX
LUIS
JAMES
BRIAN
PAMELA
1
LUIS
*/