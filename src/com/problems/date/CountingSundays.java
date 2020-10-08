package com.problems.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CountingSundays
{


    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String []argh){
        int t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long y1 = scanner.nextLong();
            y1 = (y1-1900)%2800+1900;
            int m1 = scanner.nextInt();
            int d1 = scanner.nextInt();
            long y2 = scanner.nextLong();
            y2 = (y2-y1)%2800+y1;
            int m2 = scanner.nextInt();
            int d2 = scanner.nextInt();
            System.out.println(findNbSundays((int)y1, m1, d1, (int)y2, m2, d2));
        }
    }
    
    private static int findNbSundays(int y1,int m1,int d1,int y2,int m2,int d2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        int day1 = y1*10000+m1*100+d1;
        int day2 = y2*10000+m2*100+d2;
        try
        {
            Date date1 = sdf.parse((day1)+"");
            Date date2 = sdf.parse((day2)+"");
            
            Date date = date1;
            
            int nbd = 0;
            
            if(date.getDate()!=1) {
                if(date.getMonth()!=12) {
                    date.setMonth(date.getMonth()+1);
                } else {
                    date.setYear(date.getYear()+1);
                    date.setMonth(1);
                }
                date.setDate(1);
            }
            
            while(!date.after(date2)) {
                if(date.getDay()==0) {
                    nbd++;
                }
                if(date.getMonth()!=12) {
                    date.setMonth(date.getMonth()+1);
                } else {
                    date.setYear(date.getYear()+1);
                    date.setMonth(1);
                }
            }
            
            return nbd;
            
        }
        catch(ParseException e)
        {e.printStackTrace();}
        return 0;
    }
    /*
     * 1
4699 12 12
4710 1 1
     */
}
