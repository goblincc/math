package com.yy.math2;

/**
 * Created by cc on 2020/6/12.
 */
public class around {
    public static void main(String[] args) {

    }

    public void solve(char[][] board){
        if(board.length == 0) return;
        //找边界的O
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isedge = i==0 ||j == 0 ||i == m - 1 || j == n - 1;
                if(isedge && board[i][j] == 'O'){
                    dfs(board, i , j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }


    }

    public void dfs(char[][] board, int i , int j){
        if(i < 0 || j < 0 || i >= board.length || j >=board[0].length || board[i][j] == 'X' || board[i][j] == '#'){
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
