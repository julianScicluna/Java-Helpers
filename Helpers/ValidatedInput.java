package Helpers;

public class ValidatedInput {
    public int readIntWithValidation(boolean doRange, int lowerBound, int upperBound) {
        int userInput = 0;
        boolean badInput;
        do {
            badInput = false;
            try {
                userInput = Keyboard.readInt();
                if (doRange) {
                    if (userInput < lowerBound || userInput > upperBound) {
                        badInput = true;
                        System.out.println("The number you have entered, '" + userInput + "', is out of range, which is between '" + lowerBound + "' and '" + upperBound + "'. Please try again.");
                    }
                }
            } catch (NumberFormatException nfe) {
                badInput = true;
                System.out.println("Only INTEGERS within the 32-bit limit are accepted. That means NO LETTERS or decimal points. Try again!");
            }
        } while (badInput);
        return userInput;
    }
    public double readDoubleWithValidation(boolean doRange, double lowerBound, double upperBound) {
        double userInput = 0;
        boolean badInput;
        do {
            badInput = false;
            try {
                userInput = Keyboard.readInt();
                if (doRange) {
                    if (userInput < lowerBound || userInput > upperBound) {
                        badInput = true;
                        System.out.println("The number you have entered, '" + userInput + "', is out of range, which is between '" + lowerBound + "' and '" + upperBound + "'. Please try again.");
                    }
                }
            } catch (NumberFormatException nfe) {
                badInput = true;
                System.out.println("Only INTEGERS within the 32-bit limit are accepted. That means NO LETTERS or decimal points. Try again!");
            }
        } while (badInput);
        return userInput;
    }
    public char readCharWithValidation() {
        String userInput;
        boolean badInput;
        do {
            badInput = false;
            userInput = Keyboard.readString();
            if (userInput.length() > 1) {
                badInput = true;
                System.out.println("Only single characters are allowed. Try again!");
            }
        } while (badInput);
        return userInput.charAt(0);
    }
    public String readStringWithValidation(int lengthLowerBound, int lengthUpperBound) {
        boolean badInput;
        String userInput;
        if (lengthLowerBound < 0) {
            throw new IllegalArgumentException("The string cannot be allowed to have a zero or negative length (String length lower bound is lower than zero)");
        }
        do {
            badInput = false;
            userInput = Keyboard.readString();
            if (userInput.length() < lengthLowerBound) {
                badInput = true;
                if (lengthUpperBound == 2147483647) {
                    System.out.println("The string must be at least " + lengthLowerBound + " characters long. Try again!");
                } else if (lengthUpperBound == lengthLowerBound) {
                    System.out.println("The string must be exactly " + lengthLowerBound + " characters long. Try again!");
                } else {
                    System.out.println("The string must be between " + lengthLowerBound + " and " + lengthUpperBound + " characters long. Try again!");
                }
            } else if (userInput.length() > lengthUpperBound) {
                badInput = true;
                if (lengthLowerBound == 0) {
                    System.out.println("The string must be at most " + lengthLowerBound + " characters long. Try again!");
                } else if (lengthUpperBound == lengthLowerBound) {
                    System.out.println("The string must be exactly " + lengthLowerBound + " characters long. Try again!");
                } else {
                    System.out.println("The string must be between " + lengthLowerBound + " and " + lengthUpperBound + " characters long. Try again!");
                }
            }
        } while (badInput);
        return userInput;
    }
}