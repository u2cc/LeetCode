package com.leetcode.DailyChallenge;

/*
Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */
public class AddBinary {
    public String addBinary(String a, String b) {

        int lastPosOfA=a.length()-1,lastPosOfB=b.length()-1,sum,carry=0;
        StringBuilder sb = new StringBuilder();

        //as long as there is a String not yet fully processed
        while(lastPosOfA>=0||lastPosOfB>=0){
            //get the carry from the operation lower/earlier position
            sum=carry;
            if(lastPosOfA>=0){
                //collect the digit at the current position for a
                sum+=a.charAt(lastPosOfA)-'0';
                //move the positional cursor to the next position
                lastPosOfA--;
            }
            if(lastPosOfB>=0){
                sum+=b.charAt(lastPosOfB)-'0';
                lastPosOfB--;
            }
            //the remainder againt 2 is the digit to be left at the current pos
            sb.append(sum%2);
            //we check the carry by comparing the sum against our binary ceiling of 2
            carry=sum/2;
        }

        //we check one last time the carry after all the existing positions had been checked
        if(carry==1){
            sb.append(carry);
        }
        //reverse and return
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String a = "111";
        String b = "111";
        //expected 1110
        System.out.println(addBinary.addBinary(a,b));
    }
}
