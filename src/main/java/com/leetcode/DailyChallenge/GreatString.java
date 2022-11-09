package com.leetcode.DailyChallenge;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;

/**
 * @author u2cc
 */
public class GreatString {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean repeat = true;


        while(repeat){
            if(sb.length()<=1) {
                return sb.toString();
            }
            for(int i=0;i<sb.length()-1;i++){
                if(Math.abs(sb.charAt(i)-sb.charAt(i+1))==32){
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    repeat=true;
                    break;
                }else{
                    repeat=false;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        GreatString greatString = new GreatString();

        //expected: Leetcode
        System.out.println(greatString.makeGood("leEeetcode"));
        System.out.println('A'-'a');
    }
}
