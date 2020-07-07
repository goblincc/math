package com.yy.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cc on 2019/8/18.
 */
public class ThreeSum {
    public static void main(String[] args){
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new ThreeSum().threeSum(nums);
        System.out.println(lists);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> all = new ArrayList();
        if(nums != null && nums.length > 2){
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++){
                int j = i+1;
                int k = nums.length - 1;
                while(j < k){
                    if(nums[i]+nums[k]+nums[j] == 0){
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        j++;
                        k--;
                        if(!all.contains(list)){
                            all.add(list);
                        }
                    }else if(nums[i]+nums[k]+nums[j] > 0){
                        k--;
                    }else if(nums[i]+nums[k]+nums[j] < 0){
                        j++;
                    }
                }


            }
        }
        return all;
    }

}
