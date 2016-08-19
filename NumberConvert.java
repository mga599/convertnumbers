import java.util.HashMap;

/**
 * Created by Mahmoud Gamal on 7/26/2016.
 * updated 8/19/2016
 * Convert numbers to word
 * Version 0.1
 * license GPL2
 * http://www.mahmoudgamal.com
 * http://www.github.com/mga599
 * http://www.github.com/mga599/convertnumbers
 * mga599@gmail.com
 * Coded with love in Egypt
 */

public final class NumberConvert {

        private static String number, returnedNumber;
        private static int length;

    private static String numberMap(int number) {

        HashMap numberMap = new HashMap(20);

        numberMap.put(0, "Zero");
        numberMap.put(1, "One");
        numberMap.put(2, "Two");
        numberMap.put(3, "Three");
        numberMap.put(4, "Four");
        numberMap.put(5, "Five");
        numberMap.put(6, "Six");
        numberMap.put(7, "Seven");
        numberMap.put(8, "Eight");
        numberMap.put(9, "Nine");
        numberMap.put(10, "Ten");
        numberMap.put(11, "Eleven");
        numberMap.put(12, "Twelve");
        numberMap.put(13, "Thirteen");
        numberMap.put(14, "Fourteen");
        numberMap.put(15, "Fifteen");
        numberMap.put(16, "Sixteen");
        numberMap.put(17, "Seventeen");
        numberMap.put(18, "Eighteen");
        numberMap.put(19, "Nineteen");
        numberMap.put(20, "Twenty");
        numberMap.put(30, "Thirty");
        numberMap.put(40, "Forty");
        numberMap.put(50, "Fifty");
        numberMap.put(60, "Sixty");
        numberMap.put(70, "Seventy");
        numberMap.put(80, "Eighty");
        numberMap.put(90, "Ninety");
        numberMap.put(100, "Hundred");
        numberMap.put(1000, "Thousand");
        numberMap.put(1000000, "Million");
        numberMap.put(1000000000, "Billion");


        return (String) numberMap.get(number);
    }


    public static String getNumberInString(int number) {

        NumberConvert.number = "" + number;
        NumberConvert.length = NumberConvert.number.length();

       if (number < 100)
           returnedNumber = tens(number);
       else if (number < 1000)
           returnedNumber = hundreds(number);
       else if (number < 1000000)
           returnedNumber = thousands(number);
       else if (number < 1000000000)
           returnedNumber = millions(number);
        return returnedNumber;
    }


    private static String tens(int number) {
        String numberLength = "" + number;
        String finalNumber = null;
        int second = 0;

        int firsty = Integer.parseInt("" + numberLength.charAt(0) + "0");
        int first = Integer.parseInt("" + numberLength.charAt(0));
        if (number >= 20){
            second = Integer.parseInt("" + numberLength.charAt(1));
        }

        if (number < 20)
            finalNumber = numberMap(number);
        else if (first == 0 && second != 0)
            finalNumber = numberMap(second);
        else if (second == 0 && first != 0)
            finalNumber = numberMap(number);
        else
            finalNumber = numberMap(firsty) + "-" + numberMap(second);
        return finalNumber;
    }

   private static String hundreds(int number) {
        String numberLength = "" + number;
        String finalNumber = null;
        int first = Integer.parseInt("" + numberLength.charAt(0));
        int second = Integer.parseInt("" + numberLength.charAt(1) + numberLength.charAt(2));


        if (first == 0)
            finalNumber = tens(second);
        else if (second == 00)
            finalNumber = numberMap(first) + " " + numberMap(100);
        else
            finalNumber = numberMap(first) + " " + numberMap(100) + " and " + tens(second);

        return finalNumber;
    }

    private static String thousands(int number) {
        String numberLength = "" + number;
        String finalNumber = null;
        int first = 0, second = 0, third = 0, fourth = 0;

        switch (numberLength.length()) {
            case 4:
                first = Integer.parseInt("" + numberLength.charAt(0));
                second = Integer.parseInt("" + numberLength.charAt(1));
                third = Integer.parseInt("" + numberLength.charAt(2));
                fourth = Integer.parseInt("" + numberLength.charAt(3));

                if (second == 0 && third == 0 && fourth == 0)
                    finalNumber = numberMap(first) + " " + numberMap(1000);
                else if (second == 0)
                    finalNumber = numberMap(first) + " " + numberMap(1000) + " and " + tens(Integer.parseInt(""+third +fourth));
                else if (second != 0)
                    finalNumber = numberMap(first) + " " + numberMap(1000) + " & " + hundreds(Integer.parseInt(""+second +third +fourth));

                break;

            case 5:
                first = Integer.parseInt("" + numberLength.charAt(0) + numberLength.charAt(1));
                second = Integer.parseInt("" + numberLength.charAt(2));
                third = Integer.parseInt("" + numberLength.charAt(3));
                fourth = Integer.parseInt("" + numberLength.charAt(4));

                if (second == 0 && third == 0 && fourth == 0)
                    finalNumber = tens(first) + " " + numberMap(1000);
                else if (second == 0)
                    finalNumber = tens(first) + " " + numberMap(1000) + " and " + tens(Integer.parseInt(""+third +fourth));
                else if (second != 0)
                    finalNumber = tens(first) + " " + numberMap(1000) + " & " + hundreds(Integer.parseInt(""+second +third +fourth));

                break;

            case 6:
                first = Integer.parseInt("" + numberLength.charAt(0) + numberLength.charAt(1) + numberLength.charAt(2));
                second = Integer.parseInt("" + numberLength.charAt(3));
                third = Integer.parseInt("" + numberLength.charAt(4));
                fourth = Integer.parseInt("" + numberLength.charAt(5));

                if (second == 0 && third == 0 && fourth == 0)
                    finalNumber = hundreds(first) + " " + numberMap(1000);
                else if (second == 0)
                    finalNumber = hundreds(first) + " " + numberMap(1000) + " and " + tens(Integer.parseInt(""+third +fourth));
                else if (second != 0)
                    finalNumber = hundreds(first) + " " + numberMap(1000) + " & " + hundreds(Integer.parseInt(""+second +third +fourth));
                break;
        }
        return finalNumber;
    }

    private static String millions(int number) {
        String numberLength = "" + number;
        String finalNumber = null;
        int first = 0, second = 0, third = 0, fourth = 0, fifth = 0, sixth = 0, seventh = 0;

        switch (numberLength.length()) {
            case 7:
                first = Integer.parseInt("" + numberLength.charAt(0));
                second = Integer.parseInt("" + numberLength.charAt(1));
                third = Integer.parseInt("" + numberLength.charAt(2));
                fourth = Integer.parseInt("" + numberLength.charAt(3));
                fifth = Integer.parseInt("" + numberLength.charAt(4));
                sixth = Integer.parseInt("" + numberLength.charAt(5));
                seventh = Integer.parseInt("" + numberLength.charAt(6));

                if (second == 0 && third == 0 && fourth == 0 && fifth == 0 && sixth == 0 && seventh == 0)
                    finalNumber = numberMap(first) + " " + numberMap(1000000);
                else if (second != 0)
                    finalNumber = numberMap(first) + " " + numberMap(1000000) + " & " + thousands(Integer.parseInt(""+second +third +fourth +fifth +sixth +seventh));
                else if (third != 0)
                    finalNumber = numberMap(first) + " " + numberMap(1000000) + " & " + thousands(Integer.parseInt(""+third +fourth +fifth +sixth +seventh));
                else if (fourth != 0)
                    finalNumber = numberMap(first) + " " + numberMap(1000000) + " & " + thousands(Integer.parseInt(""+fourth +fifth +sixth +seventh));
                else if (fifth != 0)
                    finalNumber = numberMap(first) + " " + numberMap(1000000) + " & " + hundreds(Integer.parseInt(""+fifth +sixth +seventh));
                else if (sixth != 0)
                    finalNumber = numberMap(first) + " " + numberMap(1000000) + " & " + hundreds(Integer.parseInt(""+sixth +seventh));
                else if (seventh != 0)
                    finalNumber = numberMap(first) + " " + numberMap(1000000) + " and " + tens(Integer.parseInt(""+seventh));

                break;

            case 8:
                first = Integer.parseInt("" + numberLength.charAt(0) + numberLength.charAt(1));
                second = Integer.parseInt("" + numberLength.charAt(2));
                third = Integer.parseInt("" + numberLength.charAt(3));
                fourth = Integer.parseInt("" + numberLength.charAt(4));
                fifth = Integer.parseInt("" + numberLength.charAt(5));
                sixth = Integer.parseInt("" + numberLength.charAt(6));
                seventh = Integer.parseInt("" + numberLength.charAt(7));

                if (second == 0 && third == 0 && fourth == 0 && fifth == 0 && sixth == 0 && seventh == 0)
                    finalNumber = tens(first) + " " + numberMap(1000000);
                else if (second != 0)
                    finalNumber = tens(first) + " " + numberMap(1000000) + " & " + thousands(Integer.parseInt(""+second +third +fourth +fifth +sixth +seventh));
                else if (third != 0)
                    finalNumber = tens(first) + " " + numberMap(1000000) + " & " + thousands(Integer.parseInt(""+third +fourth +fifth +sixth +seventh));
                else if (fourth != 0)
                    finalNumber = tens(first) + " " + numberMap(1000000) + " & " + thousands(Integer.parseInt(""+fourth +fifth +sixth +seventh));
                else if (fifth != 0)
                    finalNumber = tens(first) + " " + numberMap(1000000) + " & " + hundreds(Integer.parseInt(""+fifth +sixth +seventh));
                else if (sixth != 0)
                    finalNumber = tens(first) + " " + numberMap(1000000) + " & " + hundreds(Integer.parseInt(""+sixth +seventh));
                else if (seventh != 0)
                    finalNumber = tens(first) + " " + numberMap(1000000) + " and " + tens(Integer.parseInt(""+seventh));

                break;

            case 9:
                first = Integer.parseInt("" + numberLength.charAt(0) + numberLength.charAt(1)+ numberLength.charAt(2));
                second = Integer.parseInt("" + numberLength.charAt(3));
                third = Integer.parseInt("" + numberLength.charAt(4));
                fourth = Integer.parseInt("" + numberLength.charAt(5));
                fifth = Integer.parseInt("" + numberLength.charAt(6));
                sixth = Integer.parseInt("" + numberLength.charAt(7));
                seventh = Integer.parseInt("" + numberLength.charAt(8));

                if (second == 0 && third == 0 && fourth == 0 && fifth == 0 && sixth == 0 && seventh == 0)
                    finalNumber = hundreds(first) + " " + numberMap(1000000);
                else if (second != 0)
                    finalNumber = hundreds(first) + " " + numberMap(1000000) + " & " + thousands(Integer.parseInt(""+second +third +fourth +fifth +sixth +seventh));
                else if (third != 0)
                    finalNumber = hundreds(first) + " " + numberMap(1000000) + " & " + thousands(Integer.parseInt(""+third +fourth +fifth +sixth +seventh));
                else if (fourth != 0)
                    finalNumber = hundreds(first) + " " + numberMap(1000000) + " & " + thousands(Integer.parseInt(""+fourth +fifth +sixth +seventh));
                else if (fifth != 0)
                    finalNumber = hundreds(first) + " " + numberMap(1000000) + " & " + hundreds(Integer.parseInt(""+fifth +sixth +seventh));
                else if (sixth != 0)
                    finalNumber = hundreds(first) + " " + numberMap(1000000) + " & " + hundreds(Integer.parseInt(""+sixth +seventh));
                else if (seventh != 0)
                    finalNumber = hundreds(first) + " " + numberMap(1000000) + " and " + tens(Integer.parseInt(""+seventh));

                break;
        }
        return finalNumber;
    }
}