package com.leetcode.DailyChallenge;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
class MedianFinder {

    // apparoch we cna use  a list and do insertion sort
    // perf improvement : we can use max heap and min heap and compute median.
    // b.se in sorted items median left side is max and right side is min heap

    PriorityQueue<Integer> leftHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> rightHeap = new PriorityQueue<Integer>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        //we make sure left heap has the median num if the total number of nums is odd
        //effectively, we will maximally have one size diff between leftheap and rightheap
        if (leftHeap.size() <= rightHeap.size()) {
            leftHeap.add(num);
        } else {
            rightHeap.add(num);
        }

        //since the very beginning, we allocate num to the right heap so that the left heap has lower range than the right heap
        //at each time we add one num and that particular num might either "push" another number or itself to the head to be compared with
        //the other range and possibly cause a swap - such single element swap is enough because we are adding one element at a time to
        //one of the two queues anyway
        if (!leftHeap.isEmpty() && !rightHeap.isEmpty() && leftHeap.peek() >  rightHeap.peek()) {
            int mxhp = leftHeap.poll();
            int mnhp = rightHeap.poll();

            leftHeap.add(mnhp);
            rightHeap.add(mxhp);
        }
    }

    public double findMedian() {
        if (leftHeap.size() > rightHeap.size()) return leftHeap.peek()*1.0;

        return (leftHeap.peek()+ rightHeap.peek())/2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(6);
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        medianFinder.addNum(6);
        medianFinder.addNum(3);
        medianFinder.findMedian();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */