package com.hx.list;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author jxlgcmh
 * @date 2019-11-13 23:03
 * @description
 */
public class List {
    public static void main(String[] args) {
        List instance = new List();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
//         测试使用  记得删除
        listNode3.next=listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        instance.reverseBetween(listNode1,2,4);
    }

    /**
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/zhao-dao-mhao-jie-dian-de-qian-yi-ge-jie-dian-zai-/
     *
     * @param head
     * @param m
     * @param n
     * @return
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // tail 记录首个需要翻转的节点
        ListNode tail = head;
        // pre 记录首个需要翻转的节点的前一个节点
        ListNode pre = head;
        // 用 pre 记录翻转序列的前一个节点, tail 记录翻转序列的头一个节点
        for (int i = 1; i < m; ++i) {
            pre = tail;
            tail = tail.next;
        }
        // 新的 n 记录需要翻转的次数
        n -= m;
        // 记录需翻转的字串的头节点
        ListNode subHead = tail;
        // 翻转子串
        while (n-- != 0) {
            ListNode h = tail.next;
            tail.next = h.next;
            h.next = subHead;
            subHead = h;
            // 若不是从第一个节点就开始翻转,则进行子串头节点的拼接操作
            if (m != 1) {
                pre.next = subHead;
            }
        }
        // 若不是从首节点开始翻转,直接返回原头结点
        if (m != 1) {
            return head;
        }
        // 否则表示从首节点开始翻转,返回新的头结点
        return subHead;
    }


    /**
     * 寻找链表中的环的起始位置
     *
     * @param head
     * @return
     */
    public ListNode detectCycleII(ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    /**
     * 删除链表中的倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode leader = head;
        ListNode follower = head;
        //领导先行n步
        for (int i = 0; i < n + 1; i++) {
            // 这一步很妙啊！！！
            if (leader == null) {
                return head.next;
            }
            leader = leader.next;
        }
        //同步前进直到领导到末尾
        while (leader != null) {
            leader = leader.next;
            follower = follower.next;
        }
        //删除追随者处的节点
        follower.next = follower.next.next;
        return head;
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。
     * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> stack3 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        while (!stack1.empty() && !stack2.empty()) {
            int temp = stack1.pop().val + stack2.pop().val;
            if (temp >= 10) {
                stack3.push(new ListNode(temp - 10));
                // 选择一个栈
                int count = 0;
                while (!stack1.empty() && stack1.peek().val == 9) {
                    stack1.pop();
                    // 统计有几个9
                    count++;
                }
                // 加上temp
                if (stack1.empty()) {
                    stack1.push(new ListNode(1));
                } else {
                    stack1.push(new ListNode(stack1.pop().val + 1));
                }
                for (int i = 0; i < count; i++) {
                    stack1.push(new ListNode(0));
                }
            } else {
                stack3.push(new ListNode(temp));
            }
        }
        if (stack1.empty()) {
            while (!stack2.empty()) {
                stack3.push(new ListNode(stack2.pop().val));
            }
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack3.push(new ListNode(stack1.pop().val));
            }
        }
        ListNode temp = null;
        ListNode head = null;
        while (!stack3.empty()) {
            head = stack3.pop();
            head.next = temp;
            temp = head;
        }
        return head;
    }

    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        l1.val += l2 == null ? 0 : l2.val;
        if (l1.val > 9) {
            l1.val = l1.val % 10;
            if (l1.next == null) {
                l1.next = new ListNode(1);
            } else {
                l1.next.val += 1;
            }
            l1.next = addTwoNumbers(l1.next, l2 == null ? null : l2.next);
        } else {
            l1.next = addTwoNumbers(l1.next, l2 == null ? null : l2.next);
        }
        return l1;
    }


    //***********难*******度*******分*******割*************线******************************//

    /**
     * 是否是回文链表
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        int len = getLen(head);
        if (len <= 1) {
            return true;
        }

        for (int i = 0; i < len / 2; i++) {
            stack.push(head);
            head = head.next;
        }
        if (len % 2 == 1) {
            head = head.next;
        }
        for (int j = 0; j < len / 2; j++) {
            if (head != null && stack.pop().val == head.val) {
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    private int getLen(ListNode node) {
        int count = 0;
        if (node == null) {
            return count;
        }
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode next = null;
        while(head !=null){
            next =head.next;
            head.next = temp;
            temp = head;
            head =next;
        }
        return temp;
    }

    /**
     * 删除链表中等于给定值 val 的【所有】节点。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode point = head;
        while (point != null && point.next != null) {
            if (point.next.val == val) {
                point.next = point.next.next;
            } else {
                point = point.next;
            }
        }
        return head;
    }

    /**
     * 判断链表是否有环  用双指针的方式
     *
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

    public boolean hasCyclePro(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    /**
     * 给定一个<<排序>>链表，删除所有重复的元素，使得每个元素只出现一次。
     *
     * @param head 1->1->2->3->3
     * @return 1->2->3
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
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
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
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 非递归方式
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return res.next;
    }
}
