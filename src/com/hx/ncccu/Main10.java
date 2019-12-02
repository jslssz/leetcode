package com.hx.ncccu;

import java.util.Stack;

/**
 * 实现简易计算器
 * @author jxlgcmh
 * @date 2019-12-01 11:24
 * @description
 */
public class Main10 {
    public static void main(String[] args) {

    }

    public int getResult(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stackNum = new Stack<>();
        Stack<Character> stackOpr = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (isOper(chars[i])){
                stackOpr.push(chars[i]);
            }


        }
        return 0;
    }

    private boolean isOper(char c) {
        return c == '+' || c == '*' || c == '/' || c == '-';
    }
}
