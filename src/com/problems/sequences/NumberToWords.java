package com.problems.sequences;

public class NumberToWords
{
    
    public static void main(String []argh){
        /*int t = scanner.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = scanner.nextInt();
        }*/
        System.out.println(getName(104382426112l));
    }
    
    private static String getName(long n) {
        long trillion = n / 1000000000000l;
        n = n %1000000000000l;
        long billion = n/1000000000l;
        n = n %1000000000l;
        long million = n/1000000;
        n = n %1000000;
        long thousand = n/1000;
        n = n %1000;
        
        String trillionName = getNameFor3Digits((int)trillion);
        if(!trillionName.isEmpty()) {
            trillionName = trillionName + " Trillion ";
        }
        
        String billionName = getNameFor3Digits((int)billion);
        if(!billionName.isEmpty()) {
            billionName = billionName + " Billion ";
        }
        
        String millionName = getNameFor3Digits((int)million);
        if(!millionName.isEmpty()) {
            millionName = millionName + " Million ";
        }
        
        String thousandName = getNameFor3Digits((int)thousand);
        if(!thousandName.isEmpty()) {
            thousandName = thousandName + " Thousand ";
        }
        String name = trillionName+billionName+millionName+thousandName+getNameFor3Digits((int)n);
        return name.isEmpty()?"Zero":name;
    }
    
    private static String getNameFor3Digits(int n) {
        
        int c= n/100;
        int u=n%100;
        
        String cName = getNameFor2Digits(c);
        
        return cName.isEmpty()?getNameFor2Digits(u):cName+" Hundred "+getNameFor2Digits(u);
        
    }
    
    private static String getNameFor2Digits(int n) {
        if(n<20) {
            switch(n)
            {
                case 0:
                    return "";
                case 1:
                    return "One";
                case 2:
                    return "Two";
                case 3 :
                    return "Three";
                case 4:
                    return "Four";
                case 5:
                    return "Five";
                case 6:
                    return "Six";
                case 7:
                    return "Seven";
                case 8:
                    return "Eigth";
                case 9:
                    return "Nine";
                case 10:
                    return "Ten";
                case 11:
                    return "Eleven";
                case 12:
                    return "Twelve";
                case 13:
                    return "Thirteen";
                case 14:
                    return "Fourteen";
                case 15:
                    return "Fifteen";
                case 16:
                    return "Sixteen";
                case 17:
                    return "Seventeen";
                case 18:
                    return "Eighteen";
                case 19:
                    return "Nineteen";
                default:
                    break;
            }
        }
        int d = n/10;
        int u = n%10;
        
        return getTenthName(d)+" "+getNameFor2Digits(u);
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
            case 6 :
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
            default:
                return "";
        }
    }
    
}
