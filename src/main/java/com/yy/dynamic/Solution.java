package com.yy.dynamic;

import breeze.linalg.Options;

/**
 * Created by cc on 2019/9/4.
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println(result);
        System.out.println(uniquePaths(7, 3));
        uniquePaths2(3,3);
    }

    public static int maxSubArray(int[] nums) {
        int local = nums[0];
        int global = nums[0];
        for(int i = 1; i < nums.length; i++){
            local = Math.max(nums[i], local+nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }
    public static int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j =0 ; j < n; j++) {
                if(i == 0 ){
                    dp[j] += 1;
                }
                if(i != 0 && j != 0){
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[dp.length-1];

    }

    public static int uniquePaths(int m, int n) {
        int[][] sum = new int[100][100];
        for(int i = 0; i <= m-1; i++){
            for(int j = 0; j <= n-1; j++){
                if(i == 0 || j == 0){
                    sum[i][j] = 1;
                }else{
                    sum[i][j] = sum[i-1][j] + sum[i][j-1];
                }
            }
        }
        return sum[m-1][n-1];
    }
}
