package com.yy.java;

/**
 * Created by cc on 2019/8/12.
 */
public class KuaiPai {
    public static void main(String[] args) {
        int[] s = new int[]{2,6,5,9,3,1};
        quickSort(s,0, s.length-1 );
        for(int t:s){
            System.out.println(t);
        }
    }

    public static void quickSort(int[] s, int low, int high){

        if(low > high){
            return;
        }
        int i = low;
        int j = high;
        int temp = s[low];

        while(i < j){
            while(temp <= s[j] && i < j){
                j--;
            }
            while(temp >= s[i] && i < j){
                i++;
            }
            if(i<j){
                int t = s[j];
                s[j] = s[i];
                s[i] = t;
            }

        }
        s[low] = s[i];
        s[i] = temp;
        quickSort(s, low, j-1);
        quickSort(s, j+1, high);
    }
}
