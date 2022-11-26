package com.leetcode.DailyChallenge;

import com.sun.security.jgss.GSSUtil;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 *
 * On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
 *
 * A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
 *
 * Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Explanation: One way to remove 5 stones is as follows:
 * 1. Remove stone [2,2] because it shares the same row as [2,1].
 * 2. Remove stone [2,1] because it shares the same column as [0,1].
 * 3. Remove stone [1,2] because it shares the same row as [1,0].
 * 4. Remove stone [1,0] because it shares the same column as [0,0].
 * 5. Remove stone [0,1] because it shares the same row as [0,0].
 * Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
 * Example 2:
 *
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * Explanation: One way to make 3 moves is as follows:
 * 1. Remove stone [2,2] because it shares the same row as [2,0].
 * 2. Remove stone [2,0] because it shares the same column as [0,0].
 * 3. Remove stone [0,2] because it shares the same row as [0,0].
 * Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
 * Example 3:
 *
 * Input: stones = [[0,0]]
 * Output: 0
 * Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
 */
public class StoneRemover {


    public int removeStones(int[][] stones) {
        int countOfNotYetRemovedStones=0;
        boolean[] visited = new boolean[stones.length];
        List<Integer>[] graph = new List[stones.length];

        for(int i=0;i<stones.length;i++){
            int[] currentStone = stones[i];
            for(int j=0;j< stones.length;j++){
                if(i==j) {
                    if(graph[j]==null) {graph[j]=new ArrayList<>();}
                    continue;
                }
                int[] otherStone = stones[j];
                if(currentStone[0]==otherStone[0]||currentStone[1]==otherStone[1]){
                    if(graph[j]==null) {graph[j]=new ArrayList<>();}
                    graph[i].add(j);
                }
            }
        }

        for(int i=0; i<graph.length;i++ ){
            if(visited[i]){
                continue;
            }
            dfs(graph, visited,i);
            //we count once for the current node and implicitly we also removed all the connected ones if there are
            countOfNotYetRemovedStones++;
        }

        return stones.length-countOfNotYetRemovedStones;
    }

    public void dfs(List<Integer>[] graph, boolean[] visited, int start){
        visited[start] = true;
        List<Integer> neighbors = graph[start];
        for(int n:neighbors){
            if(visited[n]){
                continue;
            }
            dfs(graph, visited,n);

        }
    }

    public int removeStonesUnion(int[][] stones) {
        if (stones == null || stones.length <= 1) {
            return 0;
        }

        int n = stones.length;

        UnionFind uf = new UnionFind();
        for (int[] edge : stones) {
            uf.union(edge[0] + 10001, edge[1]);
        }

        return n - uf.getCount();
    }

    class UnionFind {
        Map<Integer, Integer> parents;
        int count;

        public UnionFind() {
            parents = new HashMap<>();
            count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parents.containsKey(x)) {
                parents.put(x, x);
                count++;
            }

            if (x != parents.get(x)) {
                parents.put(x, find(parents.get(x)));
            }

            return parents.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parents.put(rootX, rootY);
            count--;
        }
    }

    public static void main(String[] args) {
        StoneRemover stoneRemover = new StoneRemover();
        //int[][] stones = {{0,0},{0,1},{1,0},{1,1},{2,1},{2,2},{3,2},{3,3},{3,4},{4,3},{4,4}};
        int[][] stones ={{0,0},{1,0},{0,1}};
        stoneRemover.removeStones(stones);
        stoneRemover.removeStonesUnion(stones);
    }


}




