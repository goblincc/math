package com.yy.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by cc on 2020/6/12.
 */
public class TreeDepth {
    public static void main(String[] args) {

    }
    //dfs深度优先  先遍历左子节点 后遍历右子节点
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        int res = Math.max(left_depth, right_depth) + 1;
        return res;
    }

    //bfs  层序遍历，利用队列实现，将当前节点的左右节点加入队列， 没遍历一层，深度加1
    public int maxDepth2(TreeNode root){
        if(root == null) return 0;
        LinkedList<TreeNode> quene = new LinkedList<>();
        quene.add(root);
        int res = 0;
        while(!quene.isEmpty()){
            LinkedList<TreeNode> temp = new LinkedList<>();
            for(TreeNode node: quene){
                if(node.left != null){
                    temp.add(node.left);
                }
                if(node.right != null){
                    temp.add(node.right);
                }
            }
            quene = temp;
            res++;
        }
        return res;
    }

    //bfs广度优先
    public int maxDepth3(TreeNode root){
        if(root == null) return 0;
        Deque<TreeNode> quene = new LinkedList<>();
        int res = 0;
        quene.offer(root);
        while(!quene.isEmpty()){
            int num = quene.size();
            while(num-- >0){
                TreeNode node = quene.poll();
                if(node.left != null){
                    quene.offer(node.left);
                }
                if(node.right != null){
                    quene.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }
}
