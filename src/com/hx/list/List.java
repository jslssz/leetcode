package com.hx.list;

/**
 * @author jxlgcmh
 * @date 2019-11-13 23:03
 * @description
 */
public class List {
    public static void main(String[] args) {
        List list =new List();
        ListNode listNode1 =new ListNode(1);
        ListNode listNode2 =new ListNode(2);
        ListNode listNode3 =new ListNode(3);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        ListNode listNode4 =new ListNode(2);
        ListNode listNode5 =new ListNode(3);
        ListNode listNode6 =new ListNode(5);
        listNode4.next=listNode5;
        listNode5.next=listNode6;

        list.mergeTwoLists(listNode1,listNode4);
    }

    /**
     * 判断链表是否有环  用双指针的方式
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode point1 = head;
        ListNode point2 = head;
        while (point1 != null && point2 != null && point2.next != null) {
            point1 = point1.next;
            point2 = point2.next.next;
            if (point1 == point2) {
                return true;
            }
        }
        return false;
    }


    /**
     * 给定一个<<排序>>链表，删除所有重复的元素，使得每个元素只出现一次。
     * @param head 1->1->2->3->3
     * @return  1->2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        while (pre != null) {
            ListNode next = pre.next;
            while (next != null && next.val == pre.val) {
                next = next.next;
            }
            pre.next = next;
            pre = next;
        }
        return head;
    }

    /**
     *将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1 链表1
     * @param l2 链表2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    /**
     *  非递归方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1==null?l2:l1;
        return res.next;
    }
}
