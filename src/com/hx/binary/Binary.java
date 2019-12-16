package com.hx.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jxlgcmh
 * @date 2019-12-14 17:16
 * @description https://www.cnblogs.com/strive-ss/p/9458870.html  移位运算的概念
 * '&' 与运算相当与乘发法运算，1&1=1；1&0=0；0&0=0；
 * '|' 或运算相当于加法运算，1|1=1；1|0=1；0|0=0；
 * '^' 异或运算时同出0；异出1；1^1=0;1^0=1;0^0=0;
 */
public class Binary {
    public static void main(String[] args) {
        Binary instance = new Binary();
        //
        System.out.println(instance.bitwiseComplement(5));
    }

    public int bitwiseComplement(int N) {
        int tmp = N;
        int res =1;
        while (tmp > 0) {
            tmp >>= 1;
            res <<=1;
        }
        return N ^ (res-1);
    }




    /**
     * 链接：https://leetcode-cn.com/problems/letter-case-permutation/solution/zi-mu-da-xiao-xie-quan-pai-lie-by-leetcode/
     */
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        for (char c : S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i) {
                    ans.get(i).append(c);
                }
            }
        }

        List<String> finalans = new ArrayList<>();
        for (StringBuilder sb : ans) {
            finalans.add(sb.toString());
        }
        return finalans;
    }



    /**
     * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
     *
     * @param l
     * @param r
     * @return 链接：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/solution/javachao-yue-99de-jian-dan-xie-fa-by-flychenkai/
     */
    public int countPrimeSetBits(int l, int r) {
        //0-20的质数列表，prime[i]为1，则i为质数
        int[] primes = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        int res = 0;
        for (int i = l; i <= r; i++) {
            int t = Integer.bitCount(i);
            res += primes[t];
        }
        return res;
    }


    /**
     * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
     *
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        int tmp = n ^ (n >> 1);
        return (n & (tmp + 1)) == 0;

    }

    /**
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
     * 通过原数的右移至0,再由一个数从1左移，两者做异或运算则是结果
     *
     * @param num
     * @return 链接：https://leetcode-cn.com/problems/number-complement/solution/java-yi-huo-yun-suan-by-dukewen/
     */
    public int findComplement(int num) {
        int n = 1;
        int tmp = num;
        while (tmp > 0) {
            n <<= 1;
            tmp >>= 1;
        }
        n -= 1;
        return num ^ n;
    }

    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     * 输入: x = 1, y = 4
     * 输出: 2
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     * ↑   ↑
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    /**
     * 十进制转为16进制
     * 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/solution/405shu-zi-zhuan-huan-wei-shi-liu-jin-zhi-by-mikeop/
     *
     * @param num
     * @return
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String hex = "0123456789abcdef", ans = "";
        while (num != 0 && ans.length() < 8) {
            ans = hex.charAt(num & 0xf) + ans;
            num >>= 4;
        }
        return ans;
    }

    /**
     * 二进制手表
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (count(i) + count(j) == num) {
                    list.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return list;
    }

    /**
     * 统计整数n的二进制中一的个数
     *
     * @param n
     * @return
     */
    private int count(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public List<String> readBinaryWatchII(int num) {
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 60; ++j) {
                if (Integer.bitCount((i << 6) | j) == num) {
                    resList.add(i + ":" + (j > 9 ? "" : "0") + j);
                }
            }
        }
        return resList;
    }


    /**
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     * 请找出在 t 中被添加的字母。
     * 链接：https://leetcode-cn.com/problems/find-the-difference/solution/zi-fu-chuan-ti-huan-fa-mapji-shu-fa-zi-fu-chuan-as/
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int result = 0;
        for (Character c : s.toCharArray()) {
            result ^= c;
        }

        for (Character c : t.toCharArray()) {
            result ^= c;
        }
        return (char) result;
    }


    /**
     * 计算两数之和，不适用+ ‘’-符号
     * https://leetcode-cn.com/problems/sum-of-two-integers/solution/wei-yun-suan-xiang-jie-yi-ji-zai-python-zhong-xu-y/
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int res = (a & b) << 1;
            a = a ^ b;
            b = res;
        }
        return a;
    }

    /**
     * 二进制中一出现的个数
     * 链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }


}
