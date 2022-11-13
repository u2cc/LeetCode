package com.leetcode.DailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author u2cc
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearch {
    public List<String> findWords(char[][] board, String[] words) {

       List<String> res = new ArrayList<>();
       TrieNode p = buildTrie(words);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board, i, j, p, res);
            }
        }

        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res){
        char c = board[i][j];
        if(c=='#'||p.next[c-'a']==null) {return;}

        p=p.next[c-'a'];

        if(p.word!=null) {
            res.add(p.word);
            p.word=null;
        }

        board[i][j] = '#';
        if(i>0){
            dfs(board, i-1, j, p, res);
        }

        if(i<board.length-1){
            dfs(board, i+1, j, p, res);
        }

        if(j>0){
            dfs(board, i, j-1, p, res);
        }

        if(j<board[0].length-1){
            dfs(board, i, j+1, p, res);
        }

        board[i][j] = c;

    }


    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String s:words){
            TrieNode p = root;
            for(char c:s.toCharArray()){
                int index = c - 'a';
                if(p.next[index] == null) p.next[index] = new TrieNode();
                p = p.next[index];
            }
            p.word = s;
        }
        return root;
    }

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word = null;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        //expected: ["oath","eat"]
        System.out.println(wordSearch.findWords(board,words));
    }
}
