package com.problems.sequences;

public class TimeToWords
{
    
    public static void main(String []argh){
        /*int t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = scanner.nextInt();
        }*/
        System.out.println(getName(1,48));
    }
    
    private static String getName(int h, int m) {
        if(m==0) {
            return getNameFor2Digits(h)+" o' clock";
        } else if(m==15) {
            return "quarter past "+ getNameFor2Digits(h);
        } else if(m==30) {
            return "half past "+ getNameFor2Digits(h);
        } else if(m==45) {
            return "quarter to "+ getNameFor2Digits(h%12+1);
        } else if(m<30) {
            return getNameFor2Digits(m)+" minutes past "+ getNameFor2Digits(h);
        }else if(m>30) {
            return getNameFor2Digits(60-m)+" minutes to "+ getNameFor2Digits(h%12+1);
        }
        return "";
    }
    
    private static String getNameFor2Digits(int n) {
        if(n<20) {
            switch(n)
            {
                case 0:
                    return "";
                case 1:
                    return "one";
                case 2:
                    return "two";
                case 3 :
                    return "three";
                case 4:
                    return "four";
                case 5:
                    return "five";
                case 6:
                    return "six";
                case 7:
                    return "seven";
                case 8:
                    return "eight";
                case 9:
                    return "nine";
                case 10:
                    return "ten";
                case 11:
                    return "eleven";
                case 12:
                    return "twelve";
                case 13:
                    return "thirteen";
                case 14:
                    return "fourteen";
                case 15:
                    return "fifteen";
                case 16:
                    return "sixteen";
                case 17:
                    return "seventeen";
                case 18:
                    return "eighteen";
                case 19:
                    return "nineteen";
                default:
                    break;
            }
        }
        int d = n/10;
        int u = n%10;
        
        String tName = getTenthName(d);
        String uName = getNameFor2Digits(u);
        
        if(tName.isEmpty()) {
            return uName.toLowerCase();
        }
        if(uName.isEmpty()) {
            return tName.toLowerCase();
        }
        
        return tName.toLowerCase()+" "+uName.toLowerCase();
    }
    
    private static String getTenthName(int n) {
        switch(n)
        {
            case 0:
                return "";
            case 1:
                return "Ten";
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            default:
                return "";
        }
    }
    
}
