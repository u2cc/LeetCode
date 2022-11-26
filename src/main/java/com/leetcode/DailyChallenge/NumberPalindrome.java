package com.leetcode.DailyChallenge;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class NumberPalindrome {
    public boolean isPalindrome(int x) {
        boolean isPalindrome = true;
        Deque<Character> deque = new LinkedList<>();
        String number = String.valueOf(x);
        for(char c:number.toCharArray()){
            deque.push(c);
        }
        while(deque.size()>=1){
            if(deque.removeFirst()!=deque.removeLast()){
                isPalindrome=false;
            }
        }
        return isPalindrome;
    }

    public boolean isPalindromeEfficient(int x) {
        boolean isPalindrome = true;
        char[] chars = String.valueOf(x).toCharArray();
        for(int i=0,j=chars.length;i<chars.length/2;i++,j--){
            if(chars[i]!=chars[j]){
                isPalindrome = false;
            }
        }

        return  isPalindrome;
    }

    public boolean isPalindromeIntBased(int x) {
        if(x<0||(x%10==0&&x!=0)) return false;
        int reversed = 0;
        while(x>reversed){
            reversed = reversed*10+x%10;
            x/=10;
        }
        return reversed==x||reversed/10==x;
    }

    public static void main(String[] args) {
        NumberPalindrome numberPalindrome = new NumberPalindrome();
        numberPalindrome.isPalindromeIntBased(121);
    }
}
