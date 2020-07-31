package com.yy.sort;

/**
 * Created by cc on 2020/7/25.
 */
public class GuiBing {
    public static int[] aux;
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4, 1, 0};
        sort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    public static void sort(int[] nums){
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int lo, int hi){
        if(lo >= hi) return;
        int mid = lo + (hi - lo)/2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        if(nums[mid +1] < nums[mid]){
            merge(nums, lo, mid, hi);
        }
    }

    public static void merge(int[] nums, int lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        for(int k = lo; k <= hi; k++) {
            if(i > mid){
                nums[k] = aux[j++];
            }else if(j > hi){
                nums[k] = aux[i++];
            }else if(aux[i] < aux[j]){
                nums[k] = aux[i++];
            }else{
                nums[k] = aux[j++];
            }
        }
    }
}
