package com.leetcode.DailyChallenge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author u2cc
 *
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 *
 * Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined as one single character changed in the gene string.
 *
 *     For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 *
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 *
 * Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1.
 *
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 *
 *
 *
 * Example 1:
 *
 * Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * Output: 1
 *
 * Example 2:
 *
 * Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * Output: 2
 *
 * Example 3:
 *
 * Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 *     start.length == 8
 *     end.length == 8
 *     0 <= bank.length <= 10
 *     bank[i].length == 8
 *     start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
 */
class MinimumMutations {
    public int minMutation(String start, String end, String[] bank) {
        int hasInterimMutation=0;

        Set<String> geneSet = Arrays.stream(bank).collect(Collectors.toSet());
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        seen.add(start);
        int step = 0;
        //a BFS, as long as there is still an element in the candidate queue
        while(!queue.isEmpty()){
            int size = queue.size();
            //the queue size will always be number of nodes at the same depth
            for(int j=0;j<size;j++){
                //for each popped out node we append its neighbors to the end of the queue, our loop will
                //only pop out nodes at the same depth
                String node = queue.remove();
                if(node.equals(end)) {return step;}

                //we add all the neighbor nodes into the queue for the current node
                for(char c: new char[] {'A', 'C', 'G', 'T'} ){
                    for(int i=0;i<8;i++){
                        String neighbor = node.substring(0,i)+c+node.substring(i+1);
                        if(!seen.contains(neighbor)&&geneSet.contains(neighbor)){
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
                }
            }
            step++; //we add step count everytime when a depth is cleared
        }


        return -1;
    }

    public static void main(String[] args) {
        MinimumMutations minimumMutations = new MinimumMutations();
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        String start = "AACCGGTT";
        String end = "AAACGGTA";

        //expected value:2
        System.out.println(minimumMutations.minMutation(start,end,bank));

    }
}
