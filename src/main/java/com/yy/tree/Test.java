package com.yy.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cc on 2020/6/16.
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        queue.add(null);
        queue.add(1);
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
