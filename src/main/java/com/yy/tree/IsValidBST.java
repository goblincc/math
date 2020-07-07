package com.yy.tree;

import com.yy.math.BinaryTree.Tree;

import java.util.LinkedList;

/**
 * Created by cc on 2020/6/14.
 */
public class IsValidBST {
    public static void main(String[] args) {

    }

    LinkedList<Integer> res = new LinkedList<>();
    public boolean isValidBST(TreeNode root){
        if(root == null){return true;}
        dfs(root);
        for (int i = 0; i < res.size() - 1; i++) {
            if(res.get(i) > res.get(i + 1)){
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        res.add(root.value);
        System.out.println(root.value);
        dfs(root.right);
    }



}
