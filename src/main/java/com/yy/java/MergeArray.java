package com.yy.java;

/**
 * Created by cc on 2019/12/19.
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 5, 6, 0, 0, };
        int[] nums2 = new int[]{3, 6};
        merge(nums1,3,nums2,2);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n ){
//把num1中的值复制出来写到临时数组中
        int[] num1_copy = new int[m];
        System.arraycopy(nums1, 0, num1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
//依次比较两个数组中元素的大小，直到其中一个数组循环完毕
        while (p1 < m && p2 < n){
            nums1[p++] = (num1_copy[p1] > nums2[p2]) ? nums2[p2++] : num1_copy[p1++];
        }
//如果数组1还有剩余元素，说明剩下的元素都大于前面的值，直接复制到后面
// 将nums1_copy中从第p1个位置开始复制到nums1中，nums1的起始位置是p1+p2, 复制的长度为m+n-p1-p2
        if(p1 < m){
            System.arraycopy(num1_copy, p1, nums1, p1+p2, m+n-p1-p2);
        }

        if(p2 < n){
            System.arraycopy(nums2, p2, nums1, p1+p2, m+n-p1-p2);
        }

        for (int temp:nums1) {
            System.out.println(temp);
        }
    }
}
