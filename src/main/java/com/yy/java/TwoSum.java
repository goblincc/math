package com.yy.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2019/7/13.
 */
public class TwoSum {
    public int[] twoSum(int nums[], int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i< nums.length; i++){
            int complement = target - nums[i];
            if(map.containsValue(complement)){
                return new int[]{complement, nums[i]};
            }else{
                map.put(i, nums[i]);
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int nums[], int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i< nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args){
        TwoSum ts = new TwoSum();
        int[] s = ts.twoSum2(new int[]{2,3,3,1,5,9}, 6);
        for(int i = 0; i < s.length; i++){
            System.out.println(s[i]);
        }
    }
}
