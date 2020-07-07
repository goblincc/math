package com.yy.dynamic;

import java.util.HashMap;

/**
 * 连续的子数组和
 * 前缀和技巧
 * 这个前缀和数组 preSum 的含义也很好理解，preSum[i] 就是 nums[0..i-1] 的和。那么如果我们想求 nums[i..j] 的和，
 * 只需要一步操作 preSum[j+1]-preSum[i] 即可，而不需要重新去遍历数组了
 * Created by cc on 2020/7/4.
 */
public class CheckSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{23,2,4,6,7};
        int k = 6;
        boolean b = new CheckSubarraySum().checkSubarraySum(nums, k);
        System.out.println(b);
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if(k != 0){
                sum = sum % k;
            }
            if(!preSum.containsKey(sum)){
                preSum.put(sum, i);
            }else{
                int j = preSum.get(sum);
                if(i - j > 1){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        int n = nums.length;
        // 构造前缀和
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        // 穷举所有子数组
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i - 1; j++) {
                int temp = presum[i] - presum[j];
                if((k != 0 && temp % k == 0) || (k == 0 && temp == 0)){
                    return true;
                }
            }
        }
        return false;
    }
}
