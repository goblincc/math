package com.yy.java;

import java.util.List;

/**
 * Created by cc on 2019/7/13.
 */
public class Solution1 {
    public static void main(String[] args) {
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(3);
        first.next = second;
        second.next = third;

        ListNode first1 = new ListNode(5);
        ListNode second1 = new ListNode(6);
        ListNode third1 = new ListNode(4);
        first1.next = second1;
        second1.next = third1;

        ListNode s = addTwoNumbers(first, first1);
        System.out.println(s.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode q = l1, p = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode carr = dummyHead;
        int carry = 0;
        while (q != null || p != null) {
            int x = q != null ? q.val : 0;
            int y = p != null ? p.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;

            carr.next = new ListNode(sum % 10);
            carr = carr.next;
            if (q != null) q = q.next;
            if (p != null) p = p.next;
        }

        if (carry > 0) {
            carr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
