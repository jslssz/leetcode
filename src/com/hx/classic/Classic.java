package com.hx.classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jxlgcmh
 * @date 2019-11-13 21:14
 * @description
 */
public class Classic {
    public static void main(String[] args) {
        Classic instance = new Classic();
//        String romanString =  "MCMXCIV";
//        System.out.println(classic.romanToInt(romanString));

//        String s3 = "{}{}{}";
//        System.out.println(classic.isValid(s3));

//        instance.generate(4);

//        System.out.println(instance.convertToTitle(28));
        System.out.println(instance.trailingZeroes(10));
    }




    public int trailingZeroes(int n) {
        if (n == 0){
            return 0;
        }
        //能除开5都算
        int fivetimes = 0;
        //能除开2都算
        int twotimes = 0;
        //因为只有5和2相乘才可以是10。于是计算n中5的个数，要注意比如25其实是有两个5，
        while (n >= 5) {
            //每次都只加一层的个数

            //第一层有5的个数（以25为例）
            fivetimes += n / 5;
            //除以5之后就变成了第二层（n中包含25的个数，如果有一个就会在第二层判断时+1）...以此类推之后是n中包含25*5=125的个数;
            n = n / 5;
        }
        return fivetimes;
    }

    /**
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.insert(0, c[n % 26] + "");
            n = n / 26;
        }
        return sb.toString();
    }


    /**
     * 生成杨辉三角
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arrList = null;
        // 第一行手动生成
        if (numRows >= 1) {
            arrList = new ArrayList<>();
            arrList.add(1);
            result.add(arrList);
        }
        // 第一行手动生成
        if (numRows >= 2) {
            arrList = new ArrayList<>();
            arrList.add(1);
            arrList.add(1);
            result.add(arrList);
        }

        for (int i = 2; i < numRows; i++) {
            int j = i - 1;
            arrList = new ArrayList<>();
            // 初始化第一个元素
            arrList.add(1);
            while (j >= 1) {
                arrList.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                j--;
            }
            // 初始化最后一个元素
            arrList.add(1);
            result.add(arrList);
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
