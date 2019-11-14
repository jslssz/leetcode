package com.hx.string;

/**
 * @author jxlgcmh
 * @date 2019-11-14 12:21
 * @description
 */
public class MyString {

    public static void main(String[] args) {
        MyString instance =new MyString();

        String s1 ="hello";
        String s2 ="ll";
        instance.strStr(s1,s2);

    }

    /**
     *  给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }
        if (needle.length() == 0){
            return 0;
        }
        int [] shift = new int[256];
        int i = 0;
        int plen = needle.length();
        int len = haystack.length();
        int k = 0;
        for (char c : needle.toCharArray()) {
            shift[c] = plen - k++;
        }
        while (i + plen <= len) {
            if (needle.equals(haystack.substring(i, i + plen))){
            }
            else {
                if (i + plen < len && shift[haystack.charAt(i + plen)] != 0){
                    i = i + shift[haystack.charAt(i + plen)];
                }
                else{
                    i = i + plen;
                }
            }
        }
        return -1;
    }

    /**
     * 有效的括号 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // 边界条件的判断
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int stackIndex = 0;
        char[] data = s.toCharArray();
        char[] stack = new char[data.length];
        stack[0] = '0';

        for (char item : data) {
            if (item == '[' || item == '{' || item == '(') {
                stack[stackIndex++] = item;
            } else if (stackIndex == 0 || item == ']' && stack[stackIndex - 1] != '['
                    || item == '}' && stack[stackIndex - 1] != '{'
                    || item == ')' && stack[stackIndex - 1] != '(') {
                boolean bool1 = stackIndex == 0 || item == ']';
                boolean bool2 = stack[stackIndex - 1] != '[' || item == '}';
                boolean bool3 = stack[stackIndex - 1] != '{' || item == ')' ;
                boolean bool4 = stack[stackIndex - 1] != '(';
                return false;
            } else {
                stack[--stackIndex] = '0';
            }
        }
        return stackIndex == 0;
    }


    /**
     * 罗马数字转整数
     * 解题思路：
     * 1. 依次迭代s,如果前后两个字符不一致，且非subtraction，进行次数累乘。如为subtraction取特别值。
     *
     * @param s 入参
     * @return 转换数值
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            switch (c) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    if (i < length - 1) {
                        if (chars[i + 1] == 'M') {
                            result += 900;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'D') {
                            result += 400;
                            i++;
                            break;
                        }
                    }
                    result += 100;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    if (i < length - 1) {
                        if (chars[i + 1] == 'C') {
                            result += 90;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'L') {
                            result += 40;
                            i++;
                            break;
                        }
                    }
                    result += 10;
                    break;
                case 'V':
                    result += 5;
                    break;
                default:
                    // I
                    if (i < length - 1) {
                        if (chars[i + 1] == 'X') {
                            result += 9;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'V') {
                            result += 4;
                            i++;
                            break;
                        }
                    }
                    result += 1;
                    break;
            }
        }
        return result;
    }
}