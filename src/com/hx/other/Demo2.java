package com.hx.other;

/**
 * @author jxlgcmh
 * @date 2020-01-17 09:36
 * @description
 */
public class Demo2 {
    public static void main(String[] args) {
        Demo2 demo2 =new Demo2();
        System.out.println(demo2.foo(6));
    }
    public int foo(int n) {
        if (n < 2) return n;
        return foo(n - 1) + foo(n - 2);
    }
}
