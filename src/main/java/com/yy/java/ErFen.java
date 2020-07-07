package com.yy.java;

/**
 * Created by cc on 2019/8/12.
 */
public class ErFen {
    public static void main(String[] args) {
        int[] s = new int[]{1,2,3,4,5,6,7,8};
        int obj = 10;
        int i = find(obj, s);
        System.out.println(i);
    }

    public static int find(int obj, int[] s){
        int left = 0;
        int right = s.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(obj < s[mid]){
                right = mid-1;
            }
            if(obj > s[mid]){
                left = mid+1;
            }
            if(obj == s[mid]){
                return mid;
            }
        }
        return -1;
    }
}
