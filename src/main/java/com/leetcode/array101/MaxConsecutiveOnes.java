package com.leetcode.array101;

/**
 * @author u2cc
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 10^5
 *     nums[i] is either 0 or 1.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int currentMax=0;
        for(int i:nums){
            if(i==1) {
                count++;
                if(currentMax<count){
                    currentMax=count;
                }
            } else {
                count=0;
            }

        }
        return currentMax;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int[] input = {1,1,0,1,1,1}; //expected answer = 3
        int answer = maxConsecutiveOnes.findMaxConsecutiveOnes(input);

        System.out.printf("The max consecutive ones is %s.", answer);


    }
}
