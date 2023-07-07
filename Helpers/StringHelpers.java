package Helpers;

import java.util.LinkedHashSet;

public class StringHelpers {
    public static String removeDuplicateChars(String str) {
        //StringBuilder for dynamic and efficient adding of chars/strings to a string
        StringBuilder sb = new StringBuilder("");
        //Linked hash set to create an ordered set of the characters in a string, with any duplicates (values with equal hashes) overriding the last identical entry
        LinkedHashSet<Character> chars = new LinkedHashSet<Character>();
        //Iterate through the string and add all of its chars to the linked hash set
        for (int i = 0; i < str.length(); i++) {
            chars.add(str.charAt(i));
        }
        //chars can NEVER have ANY exact duplicate characters, EVER. Add the list's contents to the StringBuilder
        for (char c : chars) {
            sb.append(c);
        }
        //Return the contents of the StringBuilder
        return sb.toString();
    }
    //Deprecated - use new String().valueOf() instead
    public static String charArrToString(char[] arr) {
        //StringBuilder for dynamic and efficient adding of chars/strings to a string
        StringBuilder sb = new StringBuilder("");
        //Shorthand syntax to iterate through a char array and get each entry
        for (char c : arr) {
            //Add each and every character to the char array
            sb.append(c);
        }
        //Return the contents of the StringBuilder
        return sb.toString();
    }
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
        //Inform the user to avoid possible confusion
        if (shiftNum > str.length()) {
            System.out.println("WARNING (from StringHelpers.shift(String, int)): The shifting offset exceeds the string's length. Its modulus will be used instead.");
        }
        //Shift num should never exceed the string's length - avoiding any errors
        shiftNum %= str.length();
        
        //StringBuilder for dynamic and efficient adding of chars/strings to a string
        StringBuilder sb = new StringBuilder("");
        if (shiftNum < 0) {
            //Handling backward shifts
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt((i - shiftNum) % str.length()));
            }
        } else {
            //Handling forward shifts
            for (int i = 0; i < str.length(); i++) {
                //Forward shift n places gives the same result as backward shift (strlength - n) places
                sb.append(str.charAt((i + str.length() - shiftNum) % str.length()));
            }
        }
        return sb.toString();
    }
}