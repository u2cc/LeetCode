package com.leetcode.array101;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author u2cc
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 *
 *
 *
 * Constraints:
 *
 *     n == nums.length
 *     1 <= n <= 105
 *     1 <= nums[i] <= n
 *
 *
 *
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums);
        int nextNumber = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nextNumber){
                for(int j=nums[i]-1;j>=nextNumber;j--){
                    result.add(j);
                }
                nextNumber=nums[i]+1;
            }else if(nums[i]==nextNumber){
                nextNumber+=1;
            }

            if(i==nums.length-1&&nums[i]<nums.length){
                for(int k=nums.length;k>nums[i];k--){
                    result.add(k);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        int[] nums = {27,40,6,21,14,36,10,19,44,10,41,26,39,20,25,19,14,7,29,27,40,38,11,44,4,6,48,39,9,13,7,45,41,23,31,8,24,1,3,5,28,11,49,29,18,4,38,32,24,15};
        List<Integer> result = findDisappearedNumbers.findDisappearedNumbers(nums);
        //expected result: [2, 12, 17, 16, 22, 30, 35, 34, 33, 37, 43, 42, 47, 46, 50]
        System.out.println(result);
    }
}
