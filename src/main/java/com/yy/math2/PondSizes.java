package com.yy.math2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by cc on 2020/6/13.
 */
public class PondSizes {
    public static void main(String[] args) {

    }
    int num = 0;
    public int[] pondSizes(int[][] land){
        int m = land.length;
        int n = land[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(land[i][j] == 0){
                    num = 0;
                    dfs(land, i, j);
                    list.add(num);
                }
            }
        }
        int[] res = new int[list.size()];
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void dfs(int[][] land , int i, int j){
        if(i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] != 0){
            return;
        }
        //遇到0时，将0改为1，下次碰到就不用再遍历了
        land[i][j] = 1;
        num++;
        //上下左右，对角线
        dfs(land, i - 1, j);
        dfs(land, i + 1, j);
        dfs(land, i, j - 1);
        dfs(land, i, j + 1);
        dfs(land, i - 1, j - 1);
        dfs(land, i - 1, j + 1);
        dfs(land, i + 1, j - 1);
        dfs(land, i + 1, j + 1);
    }
}
