package com.leetcode.DailyChallenge;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 * You must write an algorithm with O(log n) runtime complexity.

 * Example 1:

 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:

 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:

 * Input: nums = [1,3,5,6], target = 7
 * Output: 4


 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
public class SearchInsertPosition {
        public int searchInsert(int[] nums, int target) {
            if(nums[0]>target) {return 0;}
            if(nums[nums.length-1]==target){return nums.length-1;}
            if(nums[nums.length-1]<target){return nums.length;}
            return recursiveSearch(nums,target, 0, nums.length);
        }
        private int recursiveSearch(int[] nums, int target, int lpos, int rpos){
            if(nums[rpos-1]<target) {return rpos;}
            if(nums[lpos]==target) {return lpos;}
            if(nums[rpos-1]==target) {return rpos-1;}
            if(nums[lpos]<target&&nums[rpos-1]>target&&rpos-lpos==1){
                return lpos+1;
            }
            int midPos = (lpos+(rpos-lpos)/2);
            if(nums[midPos]<=target){
                return recursiveSearch(nums,target, midPos, rpos);
            }else{
                return recursiveSearch(nums,target, lpos, midPos);
            }
        }


    public static void main(String[] args) {
        int[] nums ={1,3};
        int target = 3;
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        //expected ans is 1
        int ans = searchInsertPosition.searchInsert(nums,target);
        System.out.printf("The answer is %s.\n", ans);
    }
}

