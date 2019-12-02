package com.hx.ncccu;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author jxlgcmh
 * @date 2019-11-17 14:46
 * @description
 */
public class Main8 {
    public static void main(String[] args) {
/*        Scanner input = new Scanner(System.in);
        String line = input.nextLine();*/
        String s = "asdfghhgf";
        Main8 main8 = new Main8();
        main8.recString(s);
    }

    private void recString(String line) {
        Stack<Character> stack =new Stack<>();
        char[] chars = line.toCharArray();
        // 冷备
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == stack.peek()){
                stack.pop();
            }else {
                stack.push(chars[i]);
            }
        }
        StringBuilder sb =new StringBuilder();
        if (stack.empty()){
            System.out.println("YES");
        }
        while (! stack.empty()){
            sb.insert(0,stack.pop());
        }
        System.out.println(sb.toString());
    }
}
