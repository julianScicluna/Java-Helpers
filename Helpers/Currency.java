package Helpers;

import java.math.BigDecimal;

public class Currency {
    public static String formatCurrency(double value) {
        return formatNumber(value, 2);
    }
    public static String formatCurrency(double value, char currencyChar) {
        return currencyChar + formatNumber(value, 2);
    }
    public static String formatNumber(double value, int decimalPoints) {
        String[] splitValue = new String[2];
        String[] noSNSplit = new BigDecimal(value).toPlainString().split("\\.");        
        splitValue[0] = noSNSplit[0];
        if (noSNSplit.length == 2) {
            splitValue[1] = noSNSplit[1];
        } else {
            splitValue[1] = "00";
        }
        if (splitValue[1].length() < decimalPoints) {
            splitValue[1] += new String(new char[decimalPoints - splitValue[1].length()]).replaceAll("\0", "0");
        } else if (splitValue[1].length() > 2) {
            splitValue[1] = Integer.toString((int) Math.round(Double.parseDouble(splitValue[1])/Math.pow(10, splitValue[1].length() - decimalPoints)));
        }
        return splitValue[0] + "." + splitValue[1];
    }
}