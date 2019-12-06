package com.hx.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jxlgcmh
 * @date 2019-11-13 21:14
 * @description
 */
public class MyMath {
    public static void main(String[] args) {
        MyMath instance = new MyMath();
        int [] arr ={1,2,3,4,4,3,2,1,1,1};
        System.out.println(instance.hasGroupsSizeX(arr));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                values.add(count[i]);
            }
        }

        for (int x = 2; x <= len; ++x) {
            if (len % x == 0) {
                for (int v : values) {
                    if (v % x != 0) {
                        break;
                    }
                }
                return true;
            }
        }

        return false;
    }


    /**
     * 三角形最大面积
     * 链接：https://leetcode-cn.com/problems/largest-triangle-area/solution/zui-da-san-jiao-xing-mian-ji-by-leetcode/
     *
     * @param points
     * @return
     */
    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        double ans = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                for (int k = j + 1; k < len; ++k) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    private double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0] * Q[1] + Q[0] * R[1] + R[0] * P[1]
                - P[1] * Q[0] - Q[1] * R[0] - R[1] * P[0]);
    }


    /**
     * 自除数 是指可以被它包含的每一位数除尽的数。
     * 输入：
     * 上边界left = 1, 下边界right = 22
     * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
     *
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean flag = true;
            int temp = i;
            while (temp > 0) {
                int a = temp % 10;
                if (a == 0 || i % a != 0) {
                    flag = false;
                    break;
                }
                temp /= 10;
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
     * <p>
     * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     * 输入: nums = [1,2,2,4]
     * 输出: [2,3]
     * 链接：https://leetcode-cn.com/problems/set-mismatch
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int[] out = new int[2];
        int[] count = new int[10002];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 2) {
                out[0] = i;
            }
            if (count[i] == 0) {
                out[1] = i;
            }
        }
        return out;
    }


    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers/solution/ping-fang-shu-zhi-he-by-leetcode/
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int) (a * a);
            if (binarySearch(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(long s, long e, int n) {
        if (s > e) {
            return false;
        }
        long mid = s + (e - s) / 2;
        if (mid * mid == n) {
            return true;
        }
        if (mid * mid > n) {
            return binarySearch(s, mid - 1, n);
        }
        return binarySearch(mid + 1, e, n);
    }

    public boolean judgeSquareSumII(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }


    /**
     * 三个数最大乘积
     * 思路一：排序，如果全为正数，则是最后三个数的乘积，如果全为负数，则是最前两个负数和最后一个正数的乘积
     *
     * @param nums
     * @return 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers/solution/san-ge-shu-de-zui-da-cheng-ji-by-leetcode/
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    /**
     * 线性的方式
     *
     * @param nums
     * @return
     */
    public int maximumProductII(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            // min 用来存最小的值
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            }
            // min2 用来存倒数第二小的值
            else if (n <= min2) {
                min2 = n;
            }
            // max1 用来存最大的值
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            // max2用来存倒数第二大的值
            else if (n >= max2) {
                max3 = max2;
                max2 = n;
            }
            // max3 用来存第三大的值
            else if (n >= max3) {
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }


    /**
     * 范围求和II
     * https://leetcode-cn.com/problems/range-addition-ii/
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {
        int xmin = Integer.MAX_VALUE, ymin = Integer.MAX_VALUE;
        if (ops.length == 0) {
            return m * n;
        }
        for (int i = 0; i < ops.length; i++) {
            if (ops[i][0] < xmin) {
                xmin = ops[i][0];
            }
            if (ops[i][1] < ymin) {
                ymin = ops[i][1];
            }
        }
        return xmin * ymin;
    }

    /**
     * 完美数
     * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
     * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
     * 链接：https://leetcode-cn.com/problems/perfect-number
     * 超时
     *
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public boolean checkPerfectNumberII(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                int temp = num / i;
                sum += temp;
            }
        }
        return sum == num;
    }


    /**
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     * <p>
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     * <p>
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/arranging-coins
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 求根公式
     *
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

    public int arrangeCoinsII(int n) {
        int i = 1;
        //n小于该行应有的个数则停止
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
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
     * 1,2,3，...，n中缺失的数字
     * 利用求和公式，减去现有的和就是缺失的数字
     *
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
