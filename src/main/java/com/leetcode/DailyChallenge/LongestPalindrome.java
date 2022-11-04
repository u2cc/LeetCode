package com.leetcode.DailyChallenge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author u2cc
 * You are given an array of strings words. Each element of words consists of two lowercase English letters.
 *
 * Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
 *
 * Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
 *
 * A palindrome is a string that reads the same forward and backward.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["lc","cl","gg"]
 * Output: 6
 * Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
 * Note that "clgglc" is another longest palindrome that can be created.
 *
 * Example 2:
 *
 * Input: words = ["ab","ty","yt","lc","cl","ab"]
 * Output: 8
 * Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
 * Note that "lcyttycl" is another longest palindrome that can be created.
 *
 * Example 3:
 *
 * Input: words = ["cc","ll","xx"]
 * Output: 2
 * Explanation: One longest palindrome is "cc", of length 2.
 * Note that "ll" is another longest palindrome that can be created, and so is "xx".
 *
 *
 *
 * Constraints:
 *
 *     1 <= words.length <= 105
 *     words[i].length == 2
 *     words[i] consists of lowercase English letters.
 */
public class LongestPalindrome {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> unmatched = new HashMap<>();
        int count=0;
        int countRepeatingLetters=0;

        for(String word:words){
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();

            if(sb.toString().equals(word)&&(!unmatched.containsKey(sb.toString())||unmatched.get(sb.toString())==0)){
                //if the entry has repeating letters and our map has no record or record of zero occurrence
                countRepeatingLetters+=1;
                unmatched.put(sb.toString(),1);
            }else if(sb.toString().equals(word)&&unmatched.get(sb.toString())>0){
                //if the entry has repeating letters and our map has a record of occurrences greater than zero
                countRepeatingLetters-=1;
                count+=1;
                int occurrences = unmatched.get(sb.toString());
                unmatched.put(word, occurrences-1);
            }else if(unmatched.containsKey(sb.toString())&&unmatched.get(sb.toString())>0){
                //if the entry has a reversing match in our map with number of occurrences greater than zero
                int occurrences = unmatched.get(sb.toString());
                unmatched.put(sb.toString(), occurrences-1);
                count+=1;
            }else {
                //if the entry has no match and is not of single, self-repeating letters
                int occurrences = unmatched.getOrDefault(word,0);
                unmatched.put(word,occurrences+1);
            }
        }
        int lengthOfRepeatingLetters=countRepeatingLetters==0?0:2;
        if(count==0) {
            return lengthOfRepeatingLetters;
        }else{
            return count*4+lengthOfRepeatingLetters;
        }
    }

    public int longestPalindromeArrayBased(String[] words) {

        int[][] dp = new int[26][26];
        int middleLength = 0;

        for (String word : words) {
            dp[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }

        int startLength = 0;

        for (int row = 0; row < 26; row++) {
            for (int column = 0; column < 26; column++) {

                if (row == column) { //aa

                    if (dp[row][column] % 2 == 0) {
                        startLength += (dp[row][column] * 2);

                    } else {
                        middleLength = 2;
                        startLength += 2 * (dp[row][column] - 1);
                    }

                } else { //ab

                    if (dp[row][column] > 0 && dp[column][row] > 0) {
                        startLength += 4 * Math.min(dp[row][column], dp[column][row]);
                        dp[column][row] = 0;
                        dp[row][column] = 0;
                    }
                }
            }
        }

        return startLength + middleLength;
    }


    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String[] words ={"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"};
        int result1 = longestPalindrome.longestPalindromeArrayBased(words);
        int result2 = longestPalindrome.longestPalindrome(words);

        //expected answer: 14
        System.out.printf("result1: %s.\n", result1);
        System.out.printf("result2 %s.\n",result2);
    }
}
