package com.leetcode.DailyChallenge;

import java.util.*;

public class ReverseWords {
    public String reverseWords(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c!=' '){
                sb.append(c);
            }else if(c==' '&&sb.length()!=0){
                stack.push(sb.toString());
                sb.setLength(0);
            }
            if(i==s.length()-1&&sb.length()!=0){
                stack.push(sb.toString());
                sb.setLength(0);
            }
        }

        //StringBuilder ans = new StringBuilder();
        while(stack.peekFirst()!=null){
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(s));
    }
}
