package com.leetcode.DailyChallenge;


/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 *
 *
 * Constraints:
 *
 * 0 <= x <= 231 - 1
 */
public class SquareRoot {

    public int mySqrt(int x) {
        for(long i=1;i<=x;i++){
            if(i*i==x){
                return (int)i;
            }else if(i*i>x){
                return (int)i-1;
            }
        }
        return 0;
    }

    public int mySqrtEfficient(int x) {
        int start = 1;
        int end = x;
        if(x==0){return 0;}
        if(x==1){return 1;}

        while(start<end){
            int mid = start+(end-start)/2;
            if(mid<=x/mid&&(mid+1)>x/(mid+1)){
                return mid;
            }else if(mid>x/mid){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.mySqrtEfficient(2147395600));
        System.out.println(squareRoot.mySqrt(2147395600));
    }
}
