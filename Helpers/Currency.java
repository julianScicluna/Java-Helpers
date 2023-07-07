package Helpers;

import java.math.BigDecimal;

public class Currency {
    public static String formatCurrency(double value) {
        return formatNumber(value, 2);
    }
    public static String formatCurrency(double value, char currencyChar) {
        return currencyChar + formatNumber(value, 2);
    }
    //Format any number to one with any number of decimal places
    public static String formatNumber(double value, int decimalPoints) {
        //Create string array to store separated number (before and after decimal point)
        String[] splitValue = new String[2];
        //Split the double (WITH NO SCIENTIFIC NOTATION) to a string array
        String[] noSNSplit = new BigDecimal(value).toPlainString().split("\\.");        
        //Define integer part of number - no formatting needed here
        splitValue[0] = noSNSplit[0];
        if (noSNSplit[1].length() < decimalPoints) {
            //noSNSplit's decimal component's size is less than that desired - format string accordingly
            splitValue[1] += new String(new char[decimalPoints - noSNSplit[1].length()]).replaceAll("\0", "0");
        } else if (noSNSplit[1].length() > decimalPoints) {
            //noSNSplit's decimal component's size is more than that desired - format string accordingly (with rounding)
            splitValue[1] = Integer.toString((int) Math.round(Double.parseDouble(noSNSplit[1])/Math.pow(10, noSNSplit[1].length() - decimalPoints)));
        }
        //Join the two array indices together with a decimal point
        return splitValue[0] + "." + splitValue[1];
    }
}