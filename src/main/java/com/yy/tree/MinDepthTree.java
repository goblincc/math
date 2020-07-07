package com.yy.tree;

import java.util.Arrays;

/**
 * Created by cc on 2020/6/13.
 */
public class MinDepthTree {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }
}
