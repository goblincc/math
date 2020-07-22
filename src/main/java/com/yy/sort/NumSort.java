package com.yy.sort;

/**
 * Created by cc on 2020/7/22.
 */
public class NumSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 4, 2};
//        int[] ints = new NumSort().insertSort(nums);
//        int[] ints = new NumSort().selectSort(nums);
        int[] ints = new NumSort().shellSort(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j;
            for(j = i - 1; j >=0; j--){
                if(temp > nums[j]){
                    break;
                }else{
                    nums[j + 1] = nums[j];
                }
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    public int[] selectSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[k]){
                    k = j;
                }
            }
            if(i != k){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
        return nums;
    }

    public int[] shellSort(int[] nums){
        for(int step = nums.length/2; step > 0; step /= 2){
            for (int i = step; i < nums.length; i++) {
                int j = i;
                int temp = nums[j];
                while(j - step >= 0 && nums[j - step] > temp){
                    nums[j] = nums[j -step];
                    j = j - step;
                }
                nums[j] = temp;
            }
        }
        return nums;
    }
}
