package com.hx.math;

import java.util.*;

/**
 * @author jxlgcmh
 * @date 2019-11-13 21:14
 * @description
 */
public class MyMath {
    public static void main(String[] args) {
        MyMath instance = new MyMath();

        System.out.println(instance.convertToTitle(27));
    }

    /**
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n) {
        int temp1 = 0;
        int temp2 = 1;
        while (n > 0) {
            int n1 = n % 10;
            temp1 += n1;
            temp2 *= n1;
            n = n / 10;
        }
        return temp2 - temp1;
    }


    /**
     * 缀点成线
     *
     * @param coordinates
     * @return 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/solution/qiu-xie-lu-by-user8064p/
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int[] arr1 = coordinates[0];
        int[] arr2 = coordinates[1];
        // 获取第一个点的坐标
        int initX = arr1[0];
        int initY = arr1[1];

        // 获取第二个点的坐标
        int xDistance = arr2[0] - initX;
        int yDistance = arr2[1] - initY;

        // 从第三个点开始遍历
        for (int i = 2; i < coordinates.length; i++) {
            int[] curArr = coordinates[i];
            int curX = curArr[0];
            int curY = curArr[1];
            // 如果一二个点的高度差为0
            if (yDistance == 0) {
                // 同时第三个点和第一个点的距离不为0  返回false
                if (curY - initY != 0) {
                    return false;
                }
            }
            // 如果一二个点的高度差不为0
            else {
                // 同时第三个点和第一个点的高度为0  返回false
                if (curY - initY == 0) {
                    return false;
                }
                if (((curX - initX) / (curY - initY)) != (xDistance / yDistance)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkStraightLineII(int[][] coordinates) {
        int x1 = coordinates[1][0] - coordinates[0][0];
        int y1 = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x2 = coordinates[i][0] - coordinates[i - 1][0];
            int y2 = coordinates[i][1] - coordinates[i - 1][1];
            if (x1 * y2 != x2 * y1) {
                return false;
            }
        }
        return true;
    }


    /**
     * 玩筹码
     *
     * @param chips
     * @return
     */
    public int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;
        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 == 0) {
                even++;
            } else if (chips[i] % 2 != 0) {
                odd++;
            }
        }
        return Math.min(even, odd);
    }


    /**
     * @param n
     * @return https://leetcode-cn.com/problems/prime-arrangements/solution/javajian-ji-ban-ji-you-hua-by-dreshadow/
     */
    public int numPrimeArrangements(int n) {
        if (n < 3) {
            return 1;
        }
        int count = 0;
        boolean[] nums = new boolean[n + 1];
        for (int i = 2; i * i < nums.length; i++) {
            if (!nums[i]) {
                for (int j = i * i; j < nums.length; j += i) {
                    if (nums[j]) {
                        continue;
                    }
                    nums[j] = true;
                    count++;
                }
            }
        }
        // 非质数的数量(加1：元素1不包含在内)
        count++;

        // 8以内的质数个数多于非质数
        if (n < 8) {
            count = n - count;
        }
        // 结果
        long res = 1;
        for (int i = 2; i <= count; i++) {
            res = (res * i) % 1000000007;
            // 这里判断会减少一轮遍历
            if (i == n - count) {
                res = (res * res) % 1000000007;
            }
        }
        return (int) res;
    }


    /**
     * 每年的第几天
     *
     * @param date "1976-01-24"      "2016-02-29"
     * @return
     */
    public int dayOfYear(String date) {
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] split = date.split("-");

        int day = Integer.parseInt(split[2]);

        int month = Integer.parseInt(split[1]);

        if (isLeapYear(split[0]) && month > 2) {
            day += 1;
        }
        for (int i = 0; i < month - 1; i++) {
            day += arr[i];
        }
        return day;

    }

    private boolean isLeapYear(String stringYear) {
        int year = Integer.parseInt(stringYear);
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }


    /**
     * 分糖果
     *
     * @param candies
     * @param num_people
     * @return https://leetcode-cn.com/problems/distribute-candies-to-people/
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        int n = 0;
        while (candies > 0) {
            for (int i = 1; i <= num_people; i++) {
                if (candies > i + n * num_people) {
                    arr[i - 1] += i + n * num_people;
                } else {
                    arr[i - 1] += candies;
                }
                candies -= (i + n * num_people);
                if (candies <= 0) {
                    break;
                }
            }
            n++;
        }
        return arr;
    }


    /**
     * 有效的回旋镖
     * 采用斜率的方式：这里有一个聪敏的地方，就是斜率的分母可能为零，则改为乘积的方式
     *
     * @param points
     * @return
     */
    public boolean isBoomerang(int[][] points) {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }


    /**
     * 除数博弈
     *
     * @param N
     * @return https://leetcode-cn.com/problems/divisor-game/
     */
    public boolean divisorGame(int N) {
        int count = 0;
        int temp = 0;
        while (N > 1) {
            for (int i = 1; i < N; i++) {
                if (N % i == 0) {
                    temp = i;
                    count++;
                    break;
                }
            }
            N -= temp;
        }
        return count % 2 == 1;
    }

    /**
     * 三角形的最大周长
     * [超时]  见下题
     *
     * @param A
     * @return https://leetcode-cn.com/problems/largest-perimeter-triangle/
     */
    public int largestPerimeter(int[] A) {
        int perimeter = 0;
        int len = A.length;
        // 长度小于3  不能组成三角形
        if (len < 3) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (A[i] + A[j] > A[k] && A[i] + A[k] > A[j] && A[k] + A[j] > A[i]) {
                        perimeter = Math.max(perimeter, A[i] + A[j] + A[k]);
                    }
                }
            }
        }
        return perimeter;
    }

    public int largestPerimeterII(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        for (int i = len - 3; i >= 0; i--) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;
    }


    /**
     * 给定数字能组成的最大时间
     *
     * @param A
     * @return https://leetcode-cn.com/problems/largest-time-for-given-digits/
     */
    public String largestTimeFromDigits(int[] A) {
        int res = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j != i) {
                    for (int k = 0; k < 4; k++) {
                        if (k != i && k != j) {
                            // 有if的判断处理不会产生数组下标越界
                            int l = 6 - i - j - k;
                            int hour = 10 * A[i] + A[j];
                            int min = 10 * A[k] + A[l];
                            if (hour < 24 && min < 60) {
                                res = Math.max(res, hour * 60 + min);
                            }
                        }
                    }
                }
            }
        }
        return res >= 0 ? String.format("%02d:%02d", res / 60, res % 60) : "";
    }

    /**
     * 增减字符串匹配
     *
     * @param S
     * @return https://leetcode-cn.com/problems/di-string-match/
     */
    public int[] diStringMatch(String S) {
        int len = S.length();
        int low = 0;
        int fast = len;
        int[] arr = new int[len + 1];
        char[] chars = S.toCharArray();
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'I') {
                arr[i] = low++;
            } else {
                arr[i] = fast--;
            }

        }
        arr[len] = low;
        return arr;
    }

    /**
     * 最小差值 901
     *
     * @param A
     * @param K
     * @return https://leetcode-cn.com/problems/smallest-range-i/
     */
    public int smallestRangeI(int[] A, int K) {
        int max = A[0];
        int min = A[0];
        for (int i : A) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        // 如果出现结果为负数，最大差值为0
        return Math.max(0, max - min - 2 * K);
    }

    /**
     * 868 二级制间距
     *
     * @param N
     * @return 链接：https://leetcode-cn.com/problems/binary-gap/solution/er-jin-zhi-jian-ju-by-leetcode/
     */
    public int binaryGap(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i) {
            if (((N >> i) & 1) != 0) {
                A[t++] = i;
            }
        }

        int ans = 0;
        for (int i = 0; i < t - 1; ++i) {
            ans = Math.max(ans, A[i + 1] - A[i]);
        }
        return ans;
    }


    /**
     * 矩形重叠
     *
     * @param rec1
     * @param rec2
     * @return https://leetcode-cn.com/problems/rectangle-overlap/
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2]
                && rec2[0] < rec1[2]
                && rec1[1] < rec2[3]
                && rec2[1] < rec1[3];
    }

    public boolean isRectangleOverlapII(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }


    /**
     * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
     * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     *
     * @param nums
     * @return 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/zui-xiao-yi-dong-ci-shu-shi-shu-zu-yuan-su-xiang-d/
     */
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }

    public int minMovesII(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            res += num;
        }
        res = res - min * nums.length;
        return res;
    }


    /**
     * @param x
     * @param y
     * @param bound
     * @return
     */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                set.add(a + b);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }

        return new ArrayList<>(set);
    }

    /**
     * 卡牌分组
     *
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }
        List<Integer> values = new ArrayList();
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                values.add(count[i]);
            }
        }
        search:
        for (int X = 2; X <= N; ++X) {
            if (N % X == 0) {
                for (int v : values) {
                    if (v % X != 0) {
                        continue search;
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
     * 平方数之和
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

    /**
     *阶乘后的0的个数
     * @param n
     * @return
     * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
     */
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
        // 第二行手动生成
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
