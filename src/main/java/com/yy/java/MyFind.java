package com.yy.java;

/**
 * Created by cc on 2019/7/13.
 */
public class MyFind {
    public static void main(String[] args) {
        System.out.println(findMiddle(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    public static double findMiddle(int[] num1, int[] num2){
        int num1_len = num1.length;
        int num2_len = num2.length;
        int middle = (num1_len+num2_len)/2;
        int curr = 0;
        int mid_left = 0;
        int mid_right = 0;
        double mid;
        int index1 = 0;
        int index2 = 0;
        if(num1.length == 0){
            int mid_temp = num2_len/2;
            if(num2_len % 2 == 0){
                return (num2[mid_temp-1] + num2[mid_temp])/2.0;
            }else{
                return num2[mid_temp];
            }
        }else if(num2.length == 0){
            int mid_temp = num1_len/2;
            if(num1_len % 2 == 0){
                return (num1[mid_temp-1] + num1[mid_temp])/2.0;
            }else{
                return num1[mid_temp];
            }
        }
        for(int i = 0; i < middle + 1; i++){
            if(index1 < num1_len && index2 < num2_len){
                if(num1[index1] > num2[index2]){
                    curr = num2[index2];
                    index2++;
                }else{
                    curr = num1[index1];
                    index1++;
                }
            }else if(index1 < num1_len){
                curr = num1[index1];
                index1++;
            }else if(index2 < num2_len){
                curr = num2[index2];
                index2++;
            }
            if(i == middle-1){
                mid_left = curr;
            }
            if(i == middle){
                mid_right = curr;
            }
        }

        if((num1_len+num2_len) % 2 == 0){
            mid = (mid_left + mid_right)/2.0;
        }else{
            mid = mid_right;
        }
        return mid;
    }
}
