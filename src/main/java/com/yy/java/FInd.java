package com.yy.java;

/**
 * Created by cc on 2019/7/13.
 */
public class FInd {
    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{1});
        System.out.println(medianSortedArrays);
    }
    /**
     * 使用两个排序数据组的归并过程
     * 分别定义两个数组的遍历索引，每次对比提取相应数组的元素
     * 不实际存储归并后的数据，
     * 处理前半数元素即可
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lgn1 = nums1.length;
        int lgn2 = nums2.length;
        int allLgn = lgn1 + lgn2;
        int middleIndex = allLgn/2;
        int middleLeft = 0,middleRight = 0;
        int index1 = 0;
        int index2 = 0;
        int curr = 0;
        for (int i = 0; i < middleIndex + 1; i++) {
            if(index1 < lgn1 && index2 < lgn2) {
                if (nums1[index1] > nums2[index2]) {
                    curr = nums2[index2];
                    index2++;
                } else {
                    curr = nums1[index1];
                    index1++;
                }
            }else if(index1 < lgn1){
                curr = nums1[index1];
                index1++;
            }else if(index2 < lgn2){
                curr = nums2[index2];
                index2++;
            }
            if(i == middleIndex - 1){
                middleLeft = curr;
            }
            if(i == middleIndex){
                middleRight = curr;
            }
        }
        if(allLgn%2 == 0){
            return (middleLeft + middleRight)/2.0;
        }else {
            return middleRight;
        }
    }
}
