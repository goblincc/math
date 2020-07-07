package com.yy.java;

/**
 * Created by cc on 2019/12/16.
 */
public class removeDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3, 4};
//        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates2(nums));
    }
    public static int removeDuplicates(int nums[]){
        if(nums.length == 0){ return 0;}
        int i = 0;
        for(int j = 0; j< nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static int removeDuplicates2(int[] nums){
        int slow = 0;
        int fast = 1;
        while(fast <= nums.length - 1){
            if(nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;

    }
}


