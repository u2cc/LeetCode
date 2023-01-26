package com.leetcode.DailyChallenge;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.<br>
 * A word is a maximal
 * substring
 *  consisting of non-space characters only.
<br>
 *
 * Example 1:<br>
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * <br>
 * Example 2:
<br>
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * <br>
 * Example 3:
<br>
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 */

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int counter = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                counter++;
            }else{
                break;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        String s ="   fly me   to   the moon  ";
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        int length = lengthOfLastWord.lengthOfLastWord(s);
        System.out.println(length);
    }
}
