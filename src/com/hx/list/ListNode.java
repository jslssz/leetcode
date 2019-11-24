package com.hx.list;

/**
 * @author jxlgcmh
 * @date 2019-11-13 23:01
 * @description
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "[ListNode]"+val;
    }
}
