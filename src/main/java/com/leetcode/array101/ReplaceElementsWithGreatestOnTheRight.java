package com.leetcode.array101;

import java.util.Arrays;

/**
 * @author u2cc
 *
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 *
 * Example 2:
 *
 * Input: arr = [400]
 * Output: [-1]
 * Explanation: There are no elements to the right of index 0.
 */
public class ReplaceElementsWithGreatestOnTheRight {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i is " + i);

            if (i == arr.length - 1) {
                arr[i] = -1;
                return arr;
            }

            int currentValue = arr[i];
            System.out.println("Current Value is " + currentValue);

            int replacementValue = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > replacementValue) {
                    replacementValue = arr[j];
                }
            }
            System.out.println("Replacement Value is " + replacementValue);
            arr[i] = replacementValue;

        }
        return arr;
    }

    public static void main(String[] args) {
        ReplaceElementsWithGreatestOnTheRight replaceElementsWithGreatestOnTheRight = new ReplaceElementsWithGreatestOnTheRight();
        int[] arr = {17,18,5,4,6,1};
        //expected answer: [18,6,6,6,1,-1]
        int[] result = replaceElementsWithGreatestOnTheRight.replaceElements(arr);
        System.out.println(Arrays.toString(result));
    }

}
