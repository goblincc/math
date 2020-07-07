package com.yy.linkList;

/**
 * Created by cc on 2019/8/30.
 */
public class ListNode {
    ListNode next;
    int val;
    ListNode (int val){
        this.val = val;
    }

    ListNode(int[] arr){
        if(arr  == null || arr.length == 0){
            throw new IllegalArgumentException("wrong args....");
        }
        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1; i < arr.length; i ++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

}
