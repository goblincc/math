package com.yy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cc on 2020/6/13.
 */
public class PathSum {
    public static void main(String[] args) {

    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(root, track, sum);
        return res;
    }

    public void backTrack(TreeNode root, LinkedList<Integer> track, int target){
        if(root == null) return;
        track.add(root.value);
        target -= root.value;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new LinkedList<Integer>(track));
        }
        backTrack(root.left, track, target);
        backTrack(root.right, track, target);
        track.removeLast();
    }

    public int sum(List<Integer> track){
        int sum = 0;
        for(int temp: track){
            sum += temp;
        }
        return sum;
    }
}
