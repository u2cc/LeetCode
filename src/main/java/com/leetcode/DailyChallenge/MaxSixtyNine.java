package com.leetcode.DailyChallenge;

/**
 * @author u2cc
 * You are given a positive integer num consisting only of digits 6 and 9.
 *
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
 *
 *
 * Example 1:
 *
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 *
 * Example 2:
 *
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 *
 * Example 3:
 *
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 */
class MaxSixtyNine {
    public int maximum69Number (int num) {
        String temp = Integer.toString(num);

        int[] digits = new int[temp.length()];

        for (int i = 0; i < temp.length(); i++){
            digits[i] = temp.charAt(i) - '0';
        }

        for(int j=0;j<digits.length;j++) {
            if(digits[j]==6){
                digits[j] = 9;
                break;
            }
        }

        int result = 0;

        int length = digits.length;
        for(int k=1;k<=digits.length;k++){
            result = (int)Math.pow(10,length-k)*digits[k-1]+result;
        }

        return result;
    }
}
