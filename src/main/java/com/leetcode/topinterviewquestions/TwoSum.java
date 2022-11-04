package com.leetcode.topinterviewquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author u2cc
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 *
 * Constraints:
 *
 *     2 <= nums.length <= 104
 *     -109 <= nums[i] <= 109
 *     -109 <= target <= 109
 *     Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> difference = new HashMap<>();

        int[] result = new int[2];

        for(int i=0;i<nums.length;i++){
            if(difference.containsKey(target-nums[i])){
                result[0] = i;
                result[1] = difference.get(target-nums[i]);
                return result;
            }
            difference.put(nums[i],i);
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        //int target = 9;
        int target = -8;
        //int[] nums = {2,7,11,15};
        int[] nums = {-1,-2,-3,-4,-5};

        //expected output: [4,2]
        int[] result = twoSum.twoSum(nums,target);

        System.out.println(Arrays.toString(result));

    }
}
