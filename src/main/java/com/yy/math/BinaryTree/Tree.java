package com.yy.math.BinaryTree;

/**
 * Created by cc on 2019/8/20.
 */
public class Tree {
    public Node root;

    public void insert(int value){
        Node node = new Node(value);
        Node current = root;
        Node parent;
        if(root == null){
            root = node;
            return;
        }else{
            while(true){
                parent = current;
                if(current.value > value){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = node;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }

    }

    public void inOrder(Node localNode){
        if(localNode != null){
            inOrder(localNode.leftChild);
            System.out.println(localNode.value);
            inOrder(localNode.rightChild);
        }
    }

    public Node find(int value){
        Node current = root;
        while(current.value != value){
            if(current.value > value){
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }
            if(current == null){
                return null;
            }
        }
        return current;
    }
}
