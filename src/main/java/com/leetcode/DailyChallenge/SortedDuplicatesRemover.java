package com.leetcode.DailyChallenge;

import com.leetcode.models.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class SortedDuplicatesRemover {
    public ListNode deleteDuplicates(ListNode head) {
        if(null==head||head.next==null) {return head;}
        ListNode current = head;
        while(current.next!=null){
            if(current.val==current.next.val){
                ListNode skipped = current.next;
                current.next = skipped.next;
            }else{
                current=current.next;
            }
        }
        return head;
    }
}
