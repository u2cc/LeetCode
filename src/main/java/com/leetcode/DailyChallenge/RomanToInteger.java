package com.leetcode.DailyChallenge;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int result = 0;
        int i = 0;
        char[] chars = s.toCharArray();
        while (i < chars.length - 1) {

            if (chars[i] == 'I' && chars[i + 1] == 'V') {
                result += 4;
                i = i + 2;
            } else if (chars[i] == 'I' && chars[i + 1] == 'X') {
                result += 9;
                i = i + 2;
            } else if (chars[i] == 'X' && chars[i + 1] == 'L') {
                result += 40;
                i = i + 2;
            } else if (chars[i] == 'X' && chars[i + 1] == 'C') {
                result += 90;
                i = i + 2;
            } else if (chars[i] == 'C' && chars[i + 1] == 'D') {
                result += 400;
                i = i + 2;
            } else if (chars[i] == 'C' && chars[i + 1] == 'M') {
                result += 900;
                i = i + 2;
            } else  {
                result += getIntValue(chars[i]);
                i = i + 1;
            }
        }
        if(i==chars.length-1){
            result+=getIntValue(chars[i]);
        }
        return result;
    }

    public static int getIntValue(Character c){
        int num=0;
        switch(c){
            case 'I': num=1;break;
            case 'V': num=5;break;
            case 'X': num=10;break;
            case 'L': num=50;break;
            case 'C': num=100;break;
            case 'D': num=500;break;
            case 'M': num=1000;break;
        }
        return num;
    }
    public static void main(String[] args) {
        romanToInt("abcdefg");
    }
}
