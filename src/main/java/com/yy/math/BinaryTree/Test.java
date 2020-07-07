package com.yy.math.BinaryTree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cc on 2019/8/21.
 */
public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(8);
        tree.insert(9);
        tree.insert(15);
        tree.insert(16);
//        System.out.println(tree.root.leftChild.rightChild.value);
//        System.out.println(tree.root.value);
//        tree.inOrder(tree.root);
//        System.out.println(tree.find(15).value);
//        System.out.println(maxDepth(tree.root));
        System.out.println(maxDepth2(tree.root));

    }

    public static int maxDepth(Node root){
        if(root == null){
            return 0;
        }else{
            int left = maxDepth(root.leftChild);
            int right = maxDepth(root.rightChild);
            return Math.max(left, right) + 1;
        }
    }

    public static int maxDepth2(Node root){
        Queue<Pair<Node, Integer>> quene = new LinkedList<>();
        if(root != null){
            quene.add(new Pair<Node, Integer>(root, 1));
        }
        int maxdepth = 0;
        while(!quene.isEmpty()){
            Pair<Node, Integer> pair = quene.poll();
            int current_depth = pair.getValue();
            Node node = pair.getKey();
            if(node != null){
                maxdepth = Math.max(maxdepth, current_depth);
                quene.add(new Pair<Node, Integer>(node.leftChild, current_depth + 1));
                quene.add(new Pair<Node, Integer>(node.rightChild, current_depth + 1));
            }
        }
        return maxdepth;
    }
}
