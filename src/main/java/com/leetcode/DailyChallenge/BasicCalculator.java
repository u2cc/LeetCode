package com.leetcode.DailyChallenge;

import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * https://leetcode.com/problems/basic-calculator/description/
 *
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 */
public class BasicCalculator {
    public int calculate(String s) {
        s=s.replaceAll("\\s+","");
        int result=0;
        int idx = 0;
        while((idx=s.indexOf(")"))!=-1){
            int rightBrace = s.indexOf(")");
            String subString = s.substring(0,rightBrace);
            int leftBrace = subString.lastIndexOf("(");
            int res = calculateResult(s.substring(leftBrace+1,rightBrace));
            StringBuilder sb = new StringBuilder(s);
            sb.replace(leftBrace, rightBrace+1,String.valueOf(res));
            s = sb.toString();
        }
        result = calculateResult(s);

        return result;
    }

    public int calculateResult(String s){
        boolean add=true;
        int res = 0;

        StringTokenizer stringTokenizer = new StringTokenizer(s,"+-",true);

        while(stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();
            if(!token.equals("+")&&!token.equals("-")){
                if(add) {
                    res += Integer.valueOf(token);
                    add=true;
                }else{
                    res -=Integer.valueOf(token);
                    add=true;
                }
            }else if(token.equals("+")){
                add = true;
            }else if(token.equals("-")){
                add=!add;
            }
        }
        return res;
    }

    public int calculateWithStack(String s){
        s=s.replaceAll("\\s+","");
        int result=0;
        int operand = 0;
        int sign = 1;
        Deque<Integer> stack = new LinkedList<>();
        char[] chars = s.toCharArray();

        /*
            The mathematical expression essentially carries multiple stages of logics at different depths.
            Each deeper stage starts with a left bracket and stages will unwind itself with its corresponding right bracket
            in the reverse order of their left brackets - based on such LIFO nature, we can use a stack to store the temporary
            result and the signage of the left brackt into a stack and use the stacked result and signage at the occureance of the
            right bracket. For example, 3+(9-3) will have "3" and "1"(representing +) stored in the stack at "(", 9-3=6 will be calculated at ")"
            and thereafter "+" will be popped from stack as the signage for "6" and finally "9" will be popped out for the calculation with 6.

         */

        for(char c:chars){
            if(Character.isDigit(c)){
                //keep building the operand
                operand=operand*10+sign*(c-'0');
            }else if(c=='+'){
                //calculate the result up to now
                result=result+operand;
                //remember the current signage
                sign=1;
                //reset operand
                operand=0;
            }else if(c=='-'){
                //calculate the result up to now
                result=result+operand;
                //remember the current signage
                sign=-1;
                //reset operand
                operand=0;
            }else if(c=='('){
                //save the calculation from current tage
                stack.push(result);
                //also save the signage for the next stage
                stack.push(sign);
                //result result
                result=0;
                //reset operand
                operand=0;
                //result signage
                sign=1;
            }else if(c==')'){
                //calculate result for current stage
                result=result+operand;
                //apply sinage to the current stage
                result*=stack.pop();
                //add the saved result to the current stage
                result+=stack.pop();
                operand=0;
            }
        }

        //add the final operand to the previous result
        return result=result+operand;

    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        String s = "1+1";
        System.out.println(basicCalculator.calculate(s));
        System.out.println(basicCalculator.calculateWithStack(s));

    }
}
