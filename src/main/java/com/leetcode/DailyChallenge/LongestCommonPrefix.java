package com.leetcode.DailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){return strs[0];}
        if(strs.length==0){return "";}

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        int iteration = first.length();
        StringBuilder sb = new StringBuilder();
        char[] firstChars = first.toCharArray();
        char[] lastChars = last.toCharArray();

        for(int i=0;i<iteration;i++){
            if(firstChars[i]==lastChars[i]){
                sb.append(firstChars[i]);
            }else{
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        LongestCommonPrefix lCP = new LongestCommonPrefix();
        String ans = lCP.longestCommonPrefix(strs);
        //expected answer: "a"
        System.out.println(ans);
    }
}
