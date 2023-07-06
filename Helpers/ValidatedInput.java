package Helpers;

public class ValidatedInput {
    public static int readIntWithValidation(boolean doRange, int lowerBound, int upperBound) {
        int userInput = 0;
        boolean badInput;
        do {
            badInput = false;
            try {
                userInput = Keyboard.readInt();
                if (doRange) {
                    if (userInput < lowerBound || userInput > upperBound) {
                        badInput = true;
                        if (userInput < lowerBound && upperBound == 2147483647) {
                            System.out.println("The number must be at least '" + lowerBound + "'. Please try again.");
                        } else if (userInput > upperBound && lowerBound == -2147483647) {
                            System.out.println("The number must be at most '" + upperBound + "'. Please try again.");
                        } else {
                            System.out.println("The number you have entered, '" + userInput + "', is out of range, which is between '" + lowerBound + "' and '" + upperBound + "'. Please try again.");
                        }
                    }
                }
            } catch (NumberFormatException nfe) {
                badInput = true;
                System.out.println("Only INTEGERS within the 32-bit limit are accepted. That means NO LETTERS or decimal points. Try again!");
            }
        } while (badInput);
        return userInput;
    }
    public static double readDoubleWithValidation(boolean doRange, double lowerBound, double upperBound) {
        double userInput = 0;
        boolean badInput;
        do {
            badInput = false;
            try {
                userInput = Keyboard.readDouble();
                if (doRange) {
                    if (userInput < lowerBound || userInput > upperBound) {
                        badInput = true;
                        if (userInput < lowerBound && upperBound == Double.POSITIVE_INFINITY) {
                            System.out.println("The number must be at least '" + lowerBound + "'. Please try again.");
                        } else if (userInput > upperBound && lowerBound == Double.NEGATIVE_INFINITY) {
                            System.out.println("The number must be at most '" + upperBound + "'. Please try again.");
                        } else {
                            System.out.println("The number you have entered, '" + userInput + "', is out of range, which is between '" + lowerBound + "' and '" + upperBound + "'. Please try again.");
                        }
                    }
                }
            } catch (NumberFormatException nfe) {
                badInput = true;
                System.out.println("Only NUMBERS are accepted (decimal (non-whole) numbers are accepted). That means no LETTERS. Try again!");
            }
        } while (badInput);
        return userInput;
    }
    public static char readCharWithValidation() {
        String userInput;
        boolean badInput;
        do {
            badInput = false;
            userInput = Keyboard.readString();
            if (userInput.length() > 1) {
                badInput = true;
                System.out.println("Only single characters are allowed. Try again!");
            }
            try {
                return userInput.charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                badInput = true;
                System.out.println("No empty inputs are allowed. Try again!");
            }
        } while (badInput);
        //Effectively unreachable - make it any character - It wouldn't really matter
        return ' ';
    }
    public static String readStringWithValidation(int lengthLowerBound, int lengthUpperBound) {
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