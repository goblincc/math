package com.yy.tree;

/**
 * Created by cc on 2020/6/14.
 */
public class IsValidBST2 {
    public static void main(String[] args) {

    }

    public boolean isVlidBST(TreeNode root){
        if(root == null){
            return true;
        }
        return help(root.left, Long.MIN_VALUE, root.value) && help(root.right, root.value, Long.MAX_VALUE);
    }

    public boolean help(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.value <= min || root.value >= max) return false;
        boolean left = help(root.left, min, root.value);
        boolean right = help(root.right, root.value, max);
        return left && right;
    }
}
