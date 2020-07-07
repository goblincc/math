package com.yy.java;

import java.util.Scanner;

/**
 * Created by cc on 2019/7/14.
 */
public class Ddp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
//        创建三角形
        for(int i = 0; i < n; i++ ){
            for(int j = 0; j <= i; j++){
                a[i][j] = i+j+1;
            }
        }

        b[0][0] = a[0][0];

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++ ){
//               左侧直接相加
                if(j == 0){
                    b[i][j] = a[i-1][j] + a[i][j];
//               右侧直接相加
                }else if(j == i){
                    b[i][j] = a[i-1][j-1] + a[i][j];
//                    中间有两个来源，判断大小
                }else{
                    b[i][j] = Math.max(a[i-1][j], a[i-1][j-1]) + a[i][j];
                }
            }
        }

        int max = b[n-1][0];
        for(int i = 1; i < b[n-1].length; i++ ){
            if(b[n-1][i] > max){
                max = b[n-1][i];
            }
        }
        System.out.println(max);
    }
}
