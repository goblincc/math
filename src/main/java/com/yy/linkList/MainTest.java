package com.yy.linkList;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cc on 2019/8/30.
 */
public class MainTest {
    public static void main(String[] args) {
        int[] arr = new int[]{2,8,5,7,3,4};
        ListNode listNode = new ListNode(arr);
        map(listNode);
        ListNode listNode1 = removeNthFromEnd(listNode, 4);
        map(listNode1);
        int[] arr1 = new int[]{2, 3, 4};
        int[] arr2 = new int[]{1, 2, 2, 2};
        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);
//        ListNode listNode2 = addTwoNumbers(l1, l2);
//        map(listNode2);
//        ListNode listNode3 = mergeTwoLists(l1, l2);
//        map(listNode3);
//        ListNode listNode4 = swapPairs(l2);
//        map(listNode4);
//        ListNode listNode2 = rotateRight(l2, 5);
//        map(listNode2);
//        ListNode listNode3 = deleteDuplicates2(l2);
//        map(listNode3);
        ListNode listNode4 = deleteDuplicates3(l2);
        map(listNode4);
        System.out.println("ab".substring(1,2));

    }
    public static ListNode deleteDuplicates3(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode startNode = new ListNode(0);
        startNode.next = head;
        ListNode temp = startNode;
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                head = head.next;
            }else{
                temp.next = head;
                temp = temp.next;
                head = head.next;
            }
        }
        temp.next = head;
        return startNode.next;
    }
    /**
     * 旋转链表
     * 1->2->6->5
     * fast 5  slow 2->6->5
     * fast.next 5->1->2->6->5   temp: slow.next  6->5
     * 2->null
     * 6->5->1->2
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode startNode = new ListNode(0);
        startNode.next = head;
        ListNode fast = startNode;
        ListNode slow = startNode;
        int length = 0;
        while(slow.next != null){
            length++;
            slow = slow.next;
        }
        slow = startNode;
        //注意k有可能大于链表的长度
        k= (length+(k % length)) % length;
        //此时不需要反转
        if(k  == 0){
            return startNode.next;
        }
        for(int j = 0; j < k; j ++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        fast.next = head;
        slow.next = null;

        return temp;
    }

    /**
     * 两两交换链表中的节点
     *
     * 第一步：得到链表A 1->2->4->5,3被挂起，当然是另一种形式存在，就是链表B 3->4->5。
     * 第二步:得到链表C 3->5，也就是将链表B 3->4->5的4去掉
     * 第三步:整合A和C链表，将4指向3，得到结果链表，1->2->4->3->5，交换完成
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //初始化节点，该节点下一个节点指向head
        ListNode startNode = new ListNode(0);
        startNode.next = head;
        //需要一个节点记住，发生交换前，上一次交换的末尾节点索引点
        ListNode cur = startNode;
        while(cur.next != null && cur.next.next != null){
            ListNode first = cur.next.next;
            ListNode second = cur.next;
            //这里有个必须注意的是，链表位置交换，比如1->2->3->4->5，这个链表，2和3要交换。执行交换操作就是
            //1先指向3，然后2执行4，最后3指向2,这样就链接起来了
            cur.next = first;
            second.next = first.next;
            first.next = second;
            //最后更新下一次交换前的上个节点node
            //first已与second交换， 那下一个初始节点就是second
            cur = second;
        }
        return startNode.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        while(temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode startNode = new ListNode(0);
        startNode.next = head;
        ListNode cur = startNode;
        int k = 0;
        while(head != null){
            if(!map.containsKey(head.val)){
                map.put(head.val,k);
                k++;
                cur = cur.next;
            }else{
                cur.next = head.next;
            }
            head = head.next;

        }
        return startNode.next;
    }

    /**
     * 合并两个有序数组
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode startNode = new ListNode(0);
        ListNode cur = startNode;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur= cur.next;
            }else{
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur= cur.next;
            }

            if(l1 == null && l2 != null){
                cur.next = l2;
            }
            if(l2 == null && l1 != null){
                cur.next = l1;
            }
        }
        return startNode.next;
    }

    /**
     * 删除节点的倒数第N个数
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null || n < 0){
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode fast = node;
        ListNode slow = node;
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return node.next;
    }

    /**
     * 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode startNode = new ListNode(0);
        ListNode curr = startNode;
        //定义一个进位
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return startNode.next;
    }

    /**
     * 遍历链表
     * @param node
     */
    public static void map(ListNode node){
        StringBuffer sb = new StringBuffer();
        while(node != null){
            sb.append(node.val).append("->");
            node = node.next;
        }
        System.out.println(sb.toString().substring(0, sb.toString().lastIndexOf("->")));
    }
}
