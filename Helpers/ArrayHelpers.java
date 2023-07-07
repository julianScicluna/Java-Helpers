package Helpers;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.reflect.Array;

public class ArrayHelpers {
    public static double[] mergeSort(double[] arr, boolean ascending) {
        double temp;
        double[][] halves;
        int[] indicesReached = new int[] {0, 0};
        if (arr.length > 1) {
            halves = new double[][] {mergeSort(trim(arr, 0, arr.length/2), ascending), mergeSort(trim(arr, arr.length/2, arr.length), ascending)};
            for (int i = 0; i < arr.length; i++) {
                if (indicesReached[0] >= halves[0].length && !(indicesReached[1] >= halves[1].length)) {
                    arr[i] = halves[1][indicesReached[1]];
                    indicesReached[1]++;
                } else if (indicesReached[1] >= halves[1].length && !(indicesReached[0] >= halves[0].length)) {
                    arr[i] = halves[0][indicesReached[0]];
                    indicesReached[0]++;
                } else if (indicesReached[0] < halves[0].length && indicesReached[1] < halves[1].length) {
                    if (ascending) {
                        if (halves[0][indicesReached[0]] <= halves[1][indicesReached[1]]) {
                            arr[i] = halves[0][indicesReached[0]];
                            indicesReached[0]++;
                        } else if (halves[0][indicesReached[0]] >= halves[1][indicesReached[1]]) {
                            arr[i] = halves[1][indicesReached[1]];
                            indicesReached[1]++;
                        }
                    } else {
                        if (halves[0][indicesReached[0]] >= halves[1][indicesReached[1]]) {
                            arr[i] = halves[0][indicesReached[0]];
                            indicesReached[0]++;
                        } else if (halves[0][indicesReached[0]] <= halves[1][indicesReached[1]]) {
                            arr[i] = halves[1][indicesReached[1]];
                            indicesReached[1]++;
                        }
                    }
                }
            }
        }
        return arr;
    }
    public static int[] mergeSort(int[] arr, boolean ascending) {
        int temp;
        int[][] halves;
        int[] indicesReached = new int[] {0, 0};
        if (arr.length > 1) {
            halves = new int[][] {mergeSort(trim(arr, 0, arr.length/2), ascending), mergeSort(trim(arr, arr.length/2, arr.length), ascending)};
            for (int i = 0; i < arr.length; i++) {
                if (indicesReached[0] >= halves[0].length && !(indicesReached[1] >= halves[1].length)) {
                    arr[i] = halves[1][indicesReached[1]];
                    indicesReached[1]++;
                } else if (indicesReached[1] >= halves[1].length && !(indicesReached[0] >= halves[0].length)) {
                    arr[i] = halves[0][indicesReached[0]];
                    indicesReached[0]++;
                } else if (indicesReached[0] < halves[0].length && indicesReached[1] < halves[1].length) {
                    if (ascending) {
                        if (halves[0][indicesReached[0]] <= halves[1][indicesReached[1]]) {
                            arr[i] = halves[0][indicesReached[0]];
                            indicesReached[0]++;
                        } else if (halves[0][indicesReached[0]] >= halves[1][indicesReached[1]]) {
                            arr[i] = halves[1][indicesReached[1]];
                            indicesReached[1]++;
                        }
                    } else {
                        if (halves[0][indicesReached[0]] >= halves[1][indicesReached[1]]) {
                            arr[i] = halves[0][indicesReached[0]];
                            indicesReached[0]++;
                        } else if (halves[0][indicesReached[0]] <= halves[1][indicesReached[1]]) {
                            arr[i] = halves[1][indicesReached[1]];
                            indicesReached[1]++;
                        }
                    }
                }
            }
        }
        return arr;
    }
    public static int[] bubbleSort(int[] arr, boolean ascending) {
        boolean noShiftsInPass;
        int temp;
        do {
            noShiftsInPass = true;
            for (int i = 0; i < arr.length; i++) {
                if (ascending) {
                    if (arr[i] > arr[i + 1]) {
                        temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        noShiftsInPass = false;
                    }
                } else {
                    if (arr[i] < arr[i + 1]) {
                        temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        noShiftsInPass = false;
                    }
                }
            }
        } while (!noShiftsInPass);
        return arr;
    }
    public static double[] bubbleSort(double[] arr, boolean ascending) {
        boolean noShiftsInPass;
        double temp;
        do {
            noShiftsInPass = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (ascending) {
                    if (arr[i] > arr[i + 1]) {
                        temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        noShiftsInPass = false;
                    }
                } else {
                    if (arr[i] < arr[i + 1]) {
                        temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        noShiftsInPass = false;
                    }
                }
            }
        } while (!noShiftsInPass);
        return arr;
    }
    public static <T> int findIndex(T[] arr, T elem) {
        if (elem == null) {
            throw new NullPointerException("Element to look up cannot be null");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                throw new NullPointerException("Element in array cannot be null");
            }
            if (arr[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }
    public static <T> int findIndex(T[] arr, T elem, int from, int to) {
        if (elem == null) {
            throw new NullPointerException("Element to look up cannot be null");
        } else if (to < from) {
            throw new IllegalArgumentException("The end cannot be before the start");
        }
        for (int i = from; i < to; i++) {
            if (arr[i] == null) {
                throw new NullPointerException("Element in array cannot be null");
            }
            if (arr[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }
    public static int findIndex(char[] arr, char elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }
    public static int findIndex(char[] arr, char elem, int from, int to) {
        for (int i = from; i < to; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }
    public static int findIndex(double[] arr, double elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }
    public static int findIndex(double[] arr, double elem, int from, int to) {
        if (to < from) {
            throw new IllegalArgumentException("The end cannot be before the start");
        }
        for (int i = from; i < to; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }
    public static int findIndex(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }
    public static int findIndex(int[] arr, int elem, int from, int to) {
        if (to < from) {
            throw new IllegalArgumentException("The end cannot be before the start");
        }
        for (int i = from; i < to; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }
    public static int findIndexString(String[] arr, String elem, boolean caseSensitive) {
        if (elem == null) {
            throw new NullPointerException("Element to look up cannot be null");
        }
        if (!caseSensitive) {
            elem = elem.toLowerCase();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            if (caseSensitive) {
                if (arr[i].equals(elem)) {
                    return i;
                }
            } else {
                if (arr[i].toLowerCase().equals(elem)) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static int findIndexString(String[] arr, String elem, boolean caseSensitive, int from, int to) {
        if (elem == null) {
            throw new NullPointerException("Element to look up cannot be null");
        } else if (to < from) {
            throw new IllegalArgumentException("The end cannot be before the start");
        }
        if (!caseSensitive) {
            elem = elem.toLowerCase();
        }
        for (int i = from; i < to; i++) {
            if (arr[i] == null) {
                continue;
            }
            if (caseSensitive) {
                if (arr[i].equals(elem)) {
                    return i;
                }
            } else {
                if (arr[i].toLowerCase().equals(elem)) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static int highestNumIndex(double[] arr) {
        int highestNumIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[highestNumIndex] <= arr[i]) {
                highestNumIndex = i;
            }
        }
        return highestNumIndex;
    }
    public static int lowestNumIndex(double[] arr) {
        int lowestNumIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[lowestNumIndex] >= arr[i]) {
                lowestNumIndex = i;
            }
        }
        return lowestNumIndex;
    }
    public static int highestNumIndex(int[] arr) {
        int highestNumIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[highestNumIndex] <= arr[i]) {
                highestNumIndex = i;
            }
        }
        return highestNumIndex;
    }
    public static int lowestNumIndex(int[] arr) {
        int lowestNumIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[lowestNumIndex] >= arr[i]) {
                lowestNumIndex = i;
            }
        }
        return lowestNumIndex;
    }
    public static double average(double[] set) {
        double total = 0;
        for (int i = 0; i < set.length; i++) {
            total += set[i];
        }
        return total/set.length;
    }
    public static double mode(double[] set) {
        double[] numArr = new double[set.length];
        int[] freqArr = new int[set.length];
        int index;
        for (int i = 0; i < freqArr.length; i++) {
            freqArr[i] = 0;
        }
        for (int i = 0; i < numArr.length; i++) {
            index = findIndex(numArr, set[i]);
            if (index == -1) {
                numArr[i] = set[i];
                freqArr[i]++;
            } else {
                freqArr[index]++;
            }
        }
        return numArr[highestNumIndex(freqArr)];
    }
    public static int mode(int[] set) {
        int[] numArr = new int[set.length];
        int[] freqArr = new int[set.length];
        int index;
        for (int i = 0; i < freqArr.length; i++) {
            freqArr[i] = 0;
        }
        for (int i = 0; i < numArr.length; i++) {
            index = findIndex(numArr, set[i]);
            if (index == -1) {
                numArr[i] = set[i];
                freqArr[i]++;
            } else {
                freqArr[index]++;
            }
        }
        return numArr[highestNumIndex(freqArr)];
    }
    public static <T> T[] shuffle(T[] arr) {
        T temp;
        int randomIndex;
        for (int i = arr.length - 1; i > 0; i--) {
            do {
                randomIndex = (int) (Math.random() * arr.length);
            } while (randomIndex == i);
            temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        return arr;
    }
    public static double[] shuffle(double[] arr) {
        double temp;
        int randomIndex;
        for (int i = arr.length - 1; i > 0; i--) {
            do {
                randomIndex = (int) (Math.random() * arr.length);
            } while (randomIndex == i);
            temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        return arr;
    }
    public static int[] shuffle(int[] arr) {
        int temp;
        int randomIndex;
        for (int i = arr.length - 1; i > 0; i--) {
            do {
                randomIndex = (int) (Math.random() * arr.length);
            } while (randomIndex == i);
            temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        return arr;
    }
    public static <T> T[] trim(T[] arr, int start, int end) {
        if (end <= start) {
            throw new IllegalArgumentException("End position at or before starting position");
        }
        T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), end - start);
        for (int i = 0; i < end - start; i++) {
            newArr[i] = arr[i + start];
        }
        return (T[]) newArr;
    }
    public static int[] trim(int[] arr, int start, int end) {
        if (end <= start) {
            throw new IllegalArgumentException("End position at or before starting position");
        }
        int[] newArr = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            newArr[i] = arr[i + start];
        }
        return newArr;
    }
    public static double[] trim(double[] arr, int start, int end) {
        if (end <= start) {
            throw new IllegalArgumentException("End position at or before starting position");
        }
        double[] newArr = new double[end - start];
        for (int i = 0; i < end - start; i++) {
            newArr[i] = arr[i + start];
        }
        return newArr;
    }
    public static double[] join(double[] arr1, double[] arr2) {
        double[] joinedArr = new double[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            joinedArr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            joinedArr[arr1.length + i] = arr2[i];
        }
        return joinedArr;
    }
    public static int[] join(int[] arr1, int[] arr2) {
        int[] joinedArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            joinedArr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            joinedArr[arr1.length + i] = arr2[i];
        }
        return joinedArr;
    }
    public static <T> T[] join(T[] arr1, T[] arr2) {
        T[] joinedArr = (T[]) Array.newInstance(arr1.getClass().getComponentType(), arr1.length + arr2.length);
        for (int i = 0; i < arr1.length; i++) {
            joinedArr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            joinedArr[arr1.length + i] = arr2[i];
        }
        return joinedArr;
    }
}