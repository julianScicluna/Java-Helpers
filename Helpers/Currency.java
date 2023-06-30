package Helpers;

class Currency {
    public static String formatCurrency(double value) {
        return formatNumber(value, 2);
    }
    public static String formatCurrency(double value, char currencyChar) {
        return currencyChar + formatNumber(value, 2);
    }
    public static String formatNumber(double value, int decimalPoints) {
        String[] splitValue = Double.toString(value).split("\\.");
        if (splitValue[1].length() < decimalPoints) {
            splitValue[1] += new String(new char[decimalPoints - splitValue[1].length()]).replaceAll("\0", "0");
        } else if (splitValue[1].length() > 2) {
            splitValue[1] = Double.toString(Math.round(Double.parseDouble(splitValue[1])/Math.pow(10, splitValue[1].length() - decimalPoints)));
        }
        return splitValue[0] + "." + splitValue[1];
    }
}