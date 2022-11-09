package com.leetcode.DailyChallenge;

/**
 * @author u2cc
 */
public class AddTwoNumbers {
/*
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean increaseDecimal=false;
        ListNode result = new ListNode();
        ListNode current = result;

        while(l1!=null||l2!=null||increaseDecimal){
            int l1int = 0;
            int l2int = 0;
            if(l1!=null) {
                l1int = l1.val;
                l1 = l1.next;
            }

            if(l2!=null) {
                l2int = l2.val;
                l2 = l2.next;
            }

            int resultVal = l1int+l2int+(increaseDecimal?1:0);
           if(resultVal>=10){
                increaseDecimal=true;
           }else{
               increaseDecimal=false;
            }

            current.val=resultVal%10;

            if((l1!=null||l2!=null)||increaseDecimal){
                current.next= new ListNode();;
                current = current.next;
            }

        }
        return result;
    }
}
 */
}
