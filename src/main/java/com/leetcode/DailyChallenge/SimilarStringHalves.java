package com.leetcode.DailyChallenge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
 *
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 *
 * Return true if a and b are alike. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "book"
 * Output: true
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
 * Example 2:
 *
 * Input: s = "textbook"
 * Output: false
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
 * Notice that the vowel o is counted twice.
 */
public class SimilarStringHalves {
    Set<Character> vowels = new HashSet<>(List.of(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));
    public boolean halvesAreAlike(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int countL=0;
        for(int i=0;i<length/2;i++){
            //count of left half's vowel is increased by 1
            if(vowels.contains(chars[i])) countL+=1;
            //count of left half's vowel is offset by 1
            if(vowels.contains(chars[length-i-1])) countL-=1;
        }
        return countL==0;
    }
}
