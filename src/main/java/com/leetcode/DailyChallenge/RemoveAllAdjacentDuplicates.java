package com.leetcode.DailyChallenge;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Example 2:
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 */
public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String s) {
        if(s.length()==0||s.length()==1) {return s;}

        StringBuilder sb = new StringBuilder(s);
        boolean repeat = true;
        while(repeat){
            int length = sb.length();
            for(int i=0; i<length-1;i++){
                if(sb.charAt(i)==sb.charAt(i+1)){
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    repeat = true;
                    break;
                }
                repeat = false;
            }
            if(sb.length()==1||sb.length()==0){
                break;
            }
        }
        return sb.toString();
    }

    public String removeDuplicatesDeque(String s){
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for(char c:charArray){
            if(deque.isEmpty()) {
                deque.push(c);
            }else if(c!=deque.peek()){
                deque.push(c);
                deque.removeFirst();
            }else if(c==deque.peek()){
                deque.pop();
            }
        }
        while(!deque.isEmpty()){
            sb.append(deque.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(new RemoveAllAdjacentDuplicates().removeDuplicates(s));
    }
}
