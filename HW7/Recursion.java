/**
 * A class containing Recursive methods.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class Recursion {
    /**
     * A recursive method that executes merge sorting utilizing methods within
     * the provided RecursionUtils class.
     * @param input Array of String to be sorted.
     * @return the sorted Array of String.
     */
    public static String[] mergeSort(String[] input) {
        if (input.length == 1) {
            return input;
        } else {
            String[] arr1 = RecursionUtils.copyOfRange(input, 0, (input.length / 2));
            String[] arr1s = mergeSort(arr1);
            String[] arr2 = RecursionUtils.copyOfRange(input, (input.length / 2), input.length);
            String[] arr2s = mergeSort(arr2);
            return RecursionUtils.merge(arr1s, arr2s);
        }
    }

    /**
     * Recursive method that takes in an Array of Arrays of String to merge and sort all String to 1 Array.
     * @param input Array of Arrays of String to be merge sorted.
     * @return Array of String merge sorted.
     */
    public static String[] mergeAll(String[][] input) {
        if (input.length == 1) {
            return input[0];
        } else {
            String[] merged = RecursionUtils.merge(input[0], input[1]);
            String[][] toBe = new String[input.length - 1][];
            toBe[0] = merged;
            for (int i = 1; i < toBe.length; i++) {
                toBe[i] = input[i + 1];
            }
            return mergeAll(toBe);
        }
    }

    /**
     * A recursive method that counts duplicate String in an Array of String.
     * @param list Array of String to be evaluated.
     * @return int representing amount of duplicates.
     */
    public static int countDuplicates(String[] list) {
        if (list.length == 1) {
            return 0;
        } else {
            if (list[0].compareTo(list[1]) == 0) {
                return 1 + countDuplicates(RecursionUtils.copyOfRange(list, 1, list.length));
            }
            return countDuplicates(RecursionUtils.copyOfRange(list, 1, list.length));
        }
    }

    /**
     * A recursive method testing if a word is a palindrome.
     * @param word String to be tested.
     * @return boolean indicating if the word is a palindrome.
     */
    public static boolean verifyPalindrome(String word) {
        if (word == null) {
            return false;
        } else if (word.length() == 1 || word.length() == 0) {
            return true;
        } else {
            if (Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(word.charAt(word.length() - 1))) {
                return verifyPalindrome(word.substring(1, word.length() - 1));
            }
            return false;
        }
    }

    /**
     * A recursive method to determine how many coordinates are within a circle.
     * @param coordinates Array of Point where each entry is a coordinate on a graph.
     * @param radius int indicative of the radius of a circle.
     * @return int representing the number of coordinates within the circle.
     */
    public static int numInteriorPoints(Point[] coordinates, int radius) {
        if (coordinates.length == 0) {
            return 0;
        } else {
            int c = 1;
            Point[] slice = new Point[coordinates.length - 1];
            for (int i = 0; i < coordinates.length - 1; i++) {
                slice[i] = coordinates[c];
                c++;
            }
            if ((coordinates[0].getX() * coordinates[0].getX()
                + coordinates[0].getY() * coordinates[0].getY()) < radius * radius) {
                return 1 + numInteriorPoints(slice, radius);
            }
            return numInteriorPoints(slice, radius);
        }
    }

    /**
     * main method to test code.
     * @param args standard parameters.
     */
    public static void main(String[] args) {
        String[] arr = new String[]{"Brian", "Alex", "David", "Charlie", "Aaron"};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(mergeSort(arr)[i] + " ");
        }
        String[][] r2 = new String[][]{{"Alex", "Brian"}, {"Aaron", "David"}, {"Charlie"}};
        for (int i = 0; i < mergeAll(r2).length; i++) {
            System.out.println(mergeAll(r2)[i]);
        }
        System.out.println(countDuplicates(new String[]{"A", "A", "B", "C", "C", "C", "D"}));
        System.out.println(verifyPalindrome("raceCar"));
        System.out.println(verifyPalindrome("javvaj"));
        System.out.println(verifyPalindrome(null));
        System.out.println(verifyPalindrome("Matthew"));
        System.out.println(numInteriorPoints(new Point[]{new Point(1, 1), new Point(0, 0),
            new Point(3, 4), new Point(5, 5)}, 5));
    }
}