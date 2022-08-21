package com.leetcode.array101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author u2cc
 *
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 *
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr.length <= 104
 *     0 <= arr[i] <= 9
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        List<Integer> output = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int originalLength = arr.length;
        int i = 0;
        while(i<originalLength){
            Integer currentNumber = output.get(i);
            if(currentNumber==0){
                output.add(i+1,currentNumber);
                i=i+2; //move cursor to the element immediately after the newly added duplicate
            } else {
                i++;
            }

        }
        for(int j=0;j<originalLength;j++){
            arr[j]= output.get(j);
        }
    }

    public static void main(String[] args) {
        int[] input = {1,0,2,3,0,4,5,0}; //expected answer = [1,0,0,2,3,0,0,4]
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        duplicateZeros.duplicateZeros(input);
        System.out.println(Arrays.toString(input));

    }
}
