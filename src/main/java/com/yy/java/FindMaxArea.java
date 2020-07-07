package com.yy.java;

/**
 * Created by cc on 2019/7/16.
 */
public class FindMaxArea {
    public static void main(String[] args) {

    }

    public static int find(int[] height){
        int l = 0;
        int r = height.length-1;
        int res = 0;
        while(l < r){
            int temp = (r-l) * Math.min(height[l], height[r]);
            res = Math.max(temp, res);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
