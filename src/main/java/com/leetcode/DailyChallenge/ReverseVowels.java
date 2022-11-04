package com.leetcode.DailyChallenge;

import java.util.*;

/**
 * @author u2cc
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "hello"
 * Output: "holle"
 *
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: "leotcede"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 3 * 105
 *     s consist of printable ASCII characters.
 */
public class ReverseVowels{
        public String reverseVowels(String s) {
            HashSet<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            vowels.add('A');
            vowels.add('E');
            vowels.add('I');
            vowels.add('O');
            vowels.add('U');

            Deque<Character> vowelsequence = new LinkedList<>();
            char[] chars = s.toCharArray();
            for(char c:s.toCharArray()){
                if(vowels.contains(c)){
                    vowelsequence.push(c);
                }
            }

            for(int i=0;i<chars.length;i++){
                if(vowels.contains(chars[i])){
                    chars[i]=vowelsequence.pop();
                }
            }

            return new String(chars);
        }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        String s = "leetCoDE";
        //expected answer lEotCeDe

        System.out.println(reverseVowels.reverseVowels(s));
    }
}
