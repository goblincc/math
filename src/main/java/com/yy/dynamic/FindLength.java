package com.yy.dynamic;

/**
 * Created by cc on 2020/7/5.
 */
public class FindLength {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2,1};
        int[] B = new int[]{3,2,1,4,7};
        int length = new FindLength().findLength(A, B);
        System.out.println(length);
    }

    public int findLength(int[] A, int[] B) {
        if(A.length == 0 || B.length == 0) return 0;
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

}
