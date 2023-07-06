package Helpers;

import java.util.LinkedHashSet;

public class StringHelpers {
    public static String removeDuplicateChars(String str) {
        StringBuilder sb = new StringBuilder("");
        LinkedHashSet<Character> chars = new LinkedHashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            chars.add(str.charAt(i));
        }
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
    public static String charArrToString(char[] arr) {
        StringBuilder sb = new StringBuilder("");
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
    //Deprecated - use new String().valueOf() instead;
    public static String shiftCharCodes(String str, int shiftOffset) {
        //Declare stringbuilder to store generated encrypted string - MUCH better performance when adding strings/chars
        StringBuilder sb = new StringBuilder("");
        //Declare character variable to cache result of charAt(i) for performance reasons.
        char currentChar;
        //Iterate over each and every character in the unencrypted string
        for (int i = 0; i < str.length(); i++) {
            //Get the i'th character of the string
            currentChar = str.charAt(i);
            //Check whether character is in the alphabet (and thus applicable for modification)
            if (Character.isLetter(currentChar)) {
                //Must be either uppercase or lowercase
                if (Character.isUpperCase(currentChar)) {
                    //Currently selected character is uppercase
                    if ((int) currentChar < 65 - shiftOffset && shiftOffset < 0) {
                        //Handle cases where encryption required shifting from z to a (modulus)
                        currentChar = (char) (byte) (65 + ((26 + shiftOffset) + (int) (currentChar - 65)));
                    } else {
                        //Add the offset, apply modulus of right operand 26 and add the result to ASCII code of uppercase a - 65
                        currentChar = (char) (byte) (65 + (((int) currentChar - 65 + shiftOffset) % 26));
                    }
                    //(downcast to byte is to avoid possible lossy conversion from int to char)
                } else {
                    //Currently selected character is lowercase
                    if ((int) currentChar < 97 - shiftOffset && shiftOffset < 0) {
                        //Handle cases where encryption (positive shiftOffset) required shifting from z to a (modulus)
                        currentChar = (char) (byte) (97 + ((26 + shiftOffset) + (int) (currentChar - 97)));
                    } else {
                        //Add the offset, apply modulus of right operand 26 and add the result to ASCII code of lowercase a - 97
                        currentChar = (char) (byte) (97 + (((int) currentChar - 97 + shiftOffset) % 26));
                    }
                    //(downcast to byte is to avoid possible lossy conversion from int to char)
                }
            }
            //Add this character to the string after modification (if any)
            sb.append(currentChar);
        }
        return sb.toString();
    }
    public static String shift(String str, int shiftNum) {
        shiftNum %= str.length();
        StringBuilder sb = new StringBuilder("");
        if (shiftNum < 0) {
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt((i - shiftNum) % str.length()));
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt((i + str.length() - shiftNum) % str.length()));
            }
        }
        return sb.toString();
    }
}