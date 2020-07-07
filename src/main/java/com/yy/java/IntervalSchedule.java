package com.yy.java;

import java.util.*;

/**
 * Created by cc on 2020/2/12.
 */
public class IntervalSchedule {
    public static void main(String[] args) {
        int[][] intvs = new int[][]{{1,3},{2,4},{3,6}};
        System.out.println(intervalSchedule(intvs));
        int[][] intvs2 = new int[][]{{1,4},{4,5}};
        int[][] merge = merge(intvs2);
        for (int i = 0; i < merge.length; i++) {
            for(int j = 0; j < merge[0].length; j ++){
                System.out.println(merge[i][j]);
            }
        }
    }

    public static int intervalSchedule(int[][] intvs){
        if(intvs.length == 0) return 0;
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int count = 1;
        int x_end = intvs[0][1];
        for(int[] intv: intvs){
            int start = intv[0];
            if(start >= x_end){
                count++;
                x_end = intv[1];
            }
        }
        return count;
    }

    public static int[][] merge(int[][] intervals){
        if(intervals.length == 0) return new int[0][];
        LinkedList<int[]> merged = new LinkedList<>();
//      对数组按第一个元素排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        merged.add(intervals[0]);
        for(int[] inter: intervals){
            int[] merge_last = merged.getLast();
            if(merge_last[1] >= inter[0]){
//              找到最大的end值
                merged.getLast()[1] = Math.max(merge_last[1], inter[1]);
            }else{
                merged.add(inter);
            }
        }
        int[][] interval = new int[merged.size()][merged.get(0).length];
        for(int i =0; i < interval.length; i++){
            for(int j = 0; j <interval[0].length; j ++){
                interval[i][j] = merged.get(i)[j];
            }
        }
        return interval;
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B){
        if(A.length == 0 || B.length == 0){
            return new int[0][];
        }
        int i = 0, j =0;
        List<int[]> intersection = new LinkedList<>();
        while(i < A.length && j <B.length){
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];
            if(a1 <= b2 && a2 >= b1){
                int[] value = new int[2];
                value[0] = Math.max(a1, b1);
                value[1] = Math.min(a2, b2);
                intersection.add(value);
            }
            if(b2 < a2){
                j++;
            }else{
                i++;
            }
        }
        int[][] interval = new int[intersection.size()][intersection.get(0).length];
        for(int m =0; m < interval.length; m++){
            for(int n = 0; n <interval[0].length; n++){
                interval[m][n] = intersection.get(m)[n];
            }
        }
        return interval;

    }

}
