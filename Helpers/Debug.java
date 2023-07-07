package Helpers;

import java.util.Collection;

public class Debug {
    //Generic method to print an array of any non-primitive type (referred to as T)
    public static <T> void printCollection(T[] arr, boolean newLinePerElement, boolean printHashCodes) {
        int i = 0;
        for (T elem : arr) {
            if (newLinePerElement) {
                if (printHashCodes) {
                    System.out.println(elem.hashCode());
                } else {
                    System.out.println(elem);
                }
            } else {
                if (i == arr.length - 1) {
                    if (printHashCodes) {
                        System.out.print(elem.hashCode() + "\n");
                    } else {
                        System.out.print(elem + "\n");
                    }
                } else {
                    if (printHashCodes) {
                        System.out.print(elem.hashCode() + ", ");
                    } else {
                        System.out.print(elem + ", ");
                    }
                }
            }
            i++;
        }
    }
    //Print array of primitive ints
    public static void printCollection(int[] arr, boolean newLinePerElement) {
        int i = 0;
        for (int elem : arr) {
            if (newLinePerElement) {
                System.out.println(elem);
            } else {
                if (i == arr.length - 1) {
                    System.out.print(elem + "\n");
                } else {
                    System.out.print(elem + ", ");
                }
            }
            i++;
        }
    }
    //Print array of primitive doubles
    public static void printCollection(double[] arr, boolean newLinePerElement) {
        int i = 0;
        for (double elem : arr) {
            if (newLinePerElement) {
                System.out.println(elem);
            } else {
                if (i == arr.length - 1) {
                    System.out.print(elem + "\n");
                } else {
                    System.out.print(elem + ", ");
                }
            }
            i++;
        }
    }
    //Generic method to print an abstract Collection of any non-primitive type (referred to as T)
    public static <T> void printCollection(Collection<T> list, boolean newLinePerElement, boolean printHashCodes) {
        int i = 0;
        for (T elem : list) {
            if (newLinePerElement) {
                if (printHashCodes) {
                    System.out.println(elem.hashCode());
                } else {
                    System.out.println(elem);
                }
            } else {
                if (i == list.size() - 1) {
                    if (printHashCodes) {
                        System.out.print(elem.hashCode() + "\n");
                    } else {
                        System.out.print(elem + "\n");
                    }
                } else {
                    if (printHashCodes) {
                        System.out.print(elem.hashCode() + ", ");
                    } else {
                        System.out.print(elem + ", ");
                    }
                }
            }
            i++;
        }
    }
}