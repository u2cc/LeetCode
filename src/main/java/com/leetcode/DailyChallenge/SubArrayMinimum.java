package com.leetcode.DailyChallenge;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubArrayMinimum {
    public int sumSubarrayMins(int[] arr) {
        int res = 0;
        int length = arr.length;
        int span=1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
        //ArrayList<Integer> arrayList = new ArrayList<>(list);
        List<Integer> minimums = new ArrayList<>();


        for(int j=span;j<=length;j++){
            addMinimums(0,j,length,list,pq,minimums);
            pq.clear();
        }


        Integer dividend = Integer.valueOf(minimums.stream().mapToInt(Integer::intValue).sum());
        Integer quotient = Integer.valueOf("1000000009")+9;

         res = dividend%quotient;



        return res;
    }

    public void addMinimums(int beg, int span, int length, List<Integer> list, PriorityQueue<Integer> pq, List<Integer> minimums){
        pq.clear();
        for(int i=beg;i<length;i++){
            if(i+span<=length) {
                pq.addAll(list.subList(i, i + span));
                minimums.add(pq.peek());
            }
            pq.clear();
        }
    }


    public int sumSubarrayMinsMonotonic(int[] arr) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        long mod = (long)1000000007;
        st.push(-1);
        for (int i= 0; i < arr.length+1; i++){
            //we get current value at the ith position from array, if we are over the last element, we give 0
            int currVal = (i<=arr.length-1)? arr[i] : 0;

            //while our next element in the stack is not -1 and our current value is less than the value at the position
            //indicated by the top element in the stack, that means a new min has emerged thus we need to
            //calculate the number of occurrences of the previous min value in all the possible sub-arrays
            while(st.peek() !=-1 && currVal<arr[st.peek()]){

                int index = st.pop(); //we will pop out the last min-value position - T-1
                int j = st.peek(); //peek the value of the second-to-last min-value position - T-2
                int left = index - j; //calculating number of elements of the LHS i.e. from T-2 to T-1 position
                int right = i - index;//calculating number of elements of the RHS i.e. from T-1 to current position
                long add = (left * right * (long)arr[index]) % mod; //calculating the mod for the sum of all the occurrences of the
                //last min value
                ans += add ;
                ans %= mod;
            }
            //for the first time in the loop, we push our i into the stack
            st.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        SubArrayMinimum subArrayMinimum = new SubArrayMinimum();
        subArrayMinimum.sumSubarrayMins(new int[]{3,1,2,4});
        subArrayMinimum.sumSubarrayMinsMonotonic(new int[]{3,4,5,2,7,1});
    }
}
