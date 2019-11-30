package com.hx.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jxlgcmh
 * @date 2019-11-13 21:14
 * @description
 */
public class MyMath {
    public static void main(String[] args) {
        MyMath instance = new MyMath();
        System.out.println(instance.convertToTitle(28));

    }


    /**
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     *
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     *
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/arranging-coins
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 求根公式
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

    public int arrangeCoinsII(int n) {
        int i=1;
        //n小于该行应有的个数则停止
        while (n>=i){
            n-=i;
            i++;
        }
        return i-1;
    }

    /**
     * 2的平方
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        //数学定理解法(n*(a1+an))/2
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    /**
     * 3的幂
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     *  1,2,3，...，n中缺失的数字
     *  利用求和公式，减去现有的和就是缺失的数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        return n * (n + 1) / 2 - sum;
    }

    /**
     * 编写一个程序判断给定的数是否为丑数。
     * 丑数就是只包含质因数 2, 3, 5 的正整数。
     * <p>
     *
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }
            if (num % 3 == 0) {
                num /= 3;
                continue;
            }
            if (num % 5 == 0) {
                num /= 5;
                continue;
            }
            return false;
        }
        return true;
    }

    public boolean isUglyII(int num) {
        int[] nums = new int[]{2, 3, 5};
        for (int n : nums) {
            while (num % n == 0 && num != 0) {
                num = num / n;
            }
        }
        return num == 1;
    }


    /**
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     * 输入: 38
     * 输出: 2
     * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public int addDigitsII(int num) {
        int sum = 0;
        while (num >= 10) {
            sum = 0;
            while (num > 0) {
                int temp = num % 10;
                sum += temp;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    /**
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        while (n != 1) {
            if (n % 2 == 1) {
                return false;
            }
            n /= 2;
        }
        return true;
    }


    /**
     * 统计质数的个数
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }


    /**
     * 是否是快乐数
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        return false;
    }

    /**
     * 字符串转为二进制相加
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();
        int lena = chara.length - 1;
        int lenb = charb.length - 1;
        while (lena >= 0 && lenb >= 0) {
            int i = chara[lena] ^ charb[lenb];
            lena--;
            lenb--;
            System.out.println(i);
        }
        return null;
    }


    public int trailingZeroes(int n) {
        if (n == 0) {
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
            // 为什么要减一？因为把它放在了数组之中，下标从0开始
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
                //特别提醒，list的下标是从第0个开始，所以这层for循环从2开始
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
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }


}
