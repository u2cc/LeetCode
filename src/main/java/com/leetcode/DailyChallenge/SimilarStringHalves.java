package com.leetcode.DailyChallenge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimilarStringHalves {
    Set<Character> vowels = new HashSet<>(List.of(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));
    public boolean halvesAreAlike(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int countL=0;
        for(int i=0;i<length/2;i++){
            //count of left half's vowel is increased by 1
            if(vowels.contains(chars[i])) countL+=1;
            //count of left half's vowel is offset by 1
            if(vowels.contains(chars[length-i-1])) countL-=1;
        }
        return countL==0;
    }
}
