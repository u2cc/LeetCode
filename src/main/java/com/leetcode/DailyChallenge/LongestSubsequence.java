package com.leetcode.DailyChallenge;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * You are given an integer array nums of length n, and an integer array queries of length m.
 *
 * Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,2,1], queries = [3,10,21]
 * Output: [2,3,4]
 * Explanation: We answer the queries as follows:
 * - The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
 * - The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
 * - The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
 * Example 2:
 *
 * Input: nums = [2,3,4,5], queries = [1]
 * Output: [0]
 * Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so answer[0] = 0.
 */
public class LongestSubsequence {
    public int[] answerQueries(int[] nums, int @NotNull [] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        int numberOfSubsequence = 0;
        int sum=0;
        for(int i=0;i<queries.length;i++){
            int query = queries[i];
            while(sum<query&&numberOfSubsequence<nums.length){
                sum+=nums[numberOfSubsequence];
                if(sum<=query) {
                    numberOfSubsequence++;
                }
            }
            ans[i] = numberOfSubsequence;
            sum=0;
            numberOfSubsequence=0;
        }
        return ans;
    }

    public int[] answerQueriesV2(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int n = nums.length;
        int [] ans = new int [queries.length];

        for(int i=1; i<n; i++){
            nums[i] += nums[i-1];
        }

        for(int i=0; i<queries.length; i++){

            if(nums[n-1] <= queries[i]){
                ans[i] = n;
                continue;
            }

            // for(int j=0; j<n; j++){
            //     if(nums[j] > queries[i]){
            //         ans[i] = j;
            //         break;
            //     }
            // }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        int[] nums = {4,5,2,1};
        int[] queries = {3,10,21};
        //expected [2,3,4]
        System.out.println(Arrays.toString(longestSubsequence.answerQueries(nums,queries)));

        longestSubsequence.answerQueriesV2(nums, queries);
    }
}
