package com.leetcode.DailyChallenge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/ugly-number/
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return true if n is an ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 *
 * Input: n = 1
 * Output: true
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * Example 3:
 *
 * Input: n = 14
 * Output: false
 * Explanation: 14 is not ugly since it includes the prime factor 7.
 *
 *
 * Constraints:
 *
 * -231 <= n <= 231 - 1
 */
public class UglyNumber {
    int[] uglyFactors = new int[] {2,3,5};
    public boolean isUgly(int n) {
        if(n==1) return true;
        if(n==0) return false;
        boolean isUgly = false;
        Set<Integer> uglyFactors = new HashSet<>();

        uglyFactors.add(2);
        uglyFactors.add(3);
        uglyFactors.add(5);
        for(Integer e:uglyFactors){
            if(n%e==0){
                int quotient = n/e;
                return isUgly(quotient);
            }
        }
        return isUgly;
    }
}
