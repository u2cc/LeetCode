package com.leetcode.DailyChallenge;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Example 1:

 * Input: s = "()"
 * Output: true
 * Example 2:

 * Input: s = "()[]{}"
 * Output: true
 * Example 3:

 * Input: s = "(]"
 * Output: false

 * Constraints:

 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ParenthesesValidator {
    public boolean isValid(String s){
        boolean isValid = true;
        Deque<Character> stack = new LinkedList<>();
        for(char c:s.toCharArray()){
            if(c=='{'||c=='('||c=='['){
                stack.push(c);
            }else{
                Character top = stack.pollFirst();
                if(top==null) {return false;}
                if(c=='}'&&top!='{'){
                    isValid=false;
                }else if(c==')'&&top!='('){
                    isValid=false;
                }else if(c==']'&&top!='['){
                    isValid=false;
                }
            }
        }
        return isValid&&stack.isEmpty();
    }

    public static void main(String[] args) {
        ParenthesesValidator parenthesesValidator = new ParenthesesValidator();
        String input = "([)]";
        boolean isValid = parenthesesValidator.isValid(input);
        System.out.println(isValid);
    }
}
