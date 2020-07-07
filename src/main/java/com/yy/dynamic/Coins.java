package com.yy.dynamic;

/**
 * Created by cc on 2020/7/4.
 */
public class Coins {
    public static void main(String[] args) {
        int n = 5;
        int i = new Coins().waysToChange(n);
        System.out.println(i);
    }
    public int waysToChange(int n) {
        int[] coins = new int[]{5, 1, 10, 25};
        int len = coins.length;
        int[][] dp = new int[len + 1][n + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= n; j++) {
                if(j - coins[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j]+ dp[i][j - coins[i-1]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][n];
    }
}
