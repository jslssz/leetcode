package com.hx.classic;

/**
 * @author jxlgcmh
 * @date 2019-11-13 21:14
 * @description
 */
public class Classic {
    public static void main(String[] args) {
        Classic classic =new Classic();
        String romanString =  "MCMXCIV";
        System.out.println(classic.romanToInt(romanString));


    }

        /**
         * 罗马数字转整数
         * 解题思路：
         * 1. 依次迭代s,如果前后两个字符不一致，且非subtraction，进行次数累乘。如为subtraction取特别值。
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


    /**
     * 9
     * 判断是否为回文数
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int[] array = new int[32];
        int len = 0;
        while (x != 0) {
            array[len++] = x % 10;
            x /= 10;
        }
        boolean flag = true;
        for (int i = 0; i < len / 2; i++) {
            if (array[i] != array[len - i - 1]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 7
     * 整数反转
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }


}
