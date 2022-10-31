package com.leetcode.array101;

import java.util.Arrays;

/**
 * @author u2cc
 * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 *
 * Example 2:
 *
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 *
 * Example 3:
 *
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 104
 *     -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Can you find an O(n) solution?
 */
class ThirdMax {

    public int thirdMax(int[] nums) {

        Arrays.sort(nums);
        int nthDistinctive = 1;
        int result = nums[nums.length - 1];
        int pos = nums.length - 1;

        while (nthDistinctive != 3 && pos >= 1) {
            if (nums[pos] != nums[pos - 1]) {
                result = nums[pos - 1];
                nthDistinctive += 1;
            }
            pos -= 1;
        }
        if (nthDistinctive != 3) {
            return nums[nums.length - 1];
        }
        return result;

    }

    public static void main(String[] args) {
        ThirdMax thirdMax = new ThirdMax();
        int[] nums = {3,2,1};
        //expected answer: 1
        System.out.println(thirdMax.thirdMax(nums));
    }
}
