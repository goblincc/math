package com.yy.java;

/**
 * Created by cc on 2019/12/30.
 */
public class SignleNum {
    public static void main(String[] args){
        int[] nums = new int[]{1, 1, 2, 3, 2};
        System.out.println(signle(nums));
    }

    public static int signle(int[] nums){
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = nums[i] ^ res;
        }
        return res;
    }
}
