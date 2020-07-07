package com.yy.tree;

/**
 * Created by cc on 2020/6/13.
 */
public class BalanceTree {
    public static void main(String[] args) {

    }

    //后序遍历
    public boolean isBalance(TreeNode root){
        if(root == null){ return true;}
        //计算左子树的深度
        int left = depth(root.left);
        //计算右子树的深度
        int right = depth(root.right);
        //判断左子树和右子树的深度只差，左子树是否是平衡树， 右子树是否是平衡树
        return (Math.abs(right - left)) <= 1 && isBalance(root.right) && isBalance(root.left);
    }

    public int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
