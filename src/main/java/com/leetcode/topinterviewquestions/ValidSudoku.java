package com.leetcode.topinterviewquestions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author u2cc
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 *     Each row must contain the digits 1-9 without repetition.
 *     Each column must contain the digits 1-9 without repetition.
 *     Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 *
 *     A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *     Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 *
 * Example 1:
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since ther
 */
class ValidSudoku {

        public boolean isValidSudoku(char[][] board) {
            for(int i=0;i<9;i++){
                Set<Character> row = new HashSet<>();
                Set<Character> col = new HashSet<>();
                Set<Character> cube = new HashSet<>();
                for(int j=0;j<9;j++){

                    char currentH = board[i][j];
                    //check horizontally
                    if(currentH != '.' && !row.add(currentH)){
                        return false;
                    }


                    //check vertically
                    char currentV = board[j][i];
                    if(currentV != '.' && !col.add(currentV)){
                        return false;
                    }

                    // Check cube
                    int rowIndex = 3 * (i / 3);     // row index of current cube
                    int colIndex = 3 * (i % 3);     // col index of current cube
                    if(board[rowIndex + j / 3][colIndex + j % 3] != '.' &&
                            !cube.add(board[rowIndex + j / 3][colIndex + j % 3])){
                        return false;
                    }

                }


            }
            return true;
        }



    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        boolean result =validSudoku.isValidSudoku(board);
        System.out.println(result);
        //expected false
    }
}
