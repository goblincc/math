package com.yy.sort;

/**
 * Created by cc on 2020/7/25.
 */
public class KuaiPai {
    public static void main(String[] args){
//        int[] nums = new int[]{3, 2, 4, 1, 0};
        int[] nums = new int[]{1, 2, 3, 4, 5};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

    public static  void sort(int[] nums){
        sort(nums, 0, nums.length - 1);
    }


    public static void sort(int[] nums, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    public static int partition(int[] nums, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        int v = nums[lo];
        while(true){
            while(nums[++i] < v) if(i == hi) break;
            while(nums[--j] > v) if(j == lo) break;
            if(i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int temp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = temp;
        return j;
    }
}
