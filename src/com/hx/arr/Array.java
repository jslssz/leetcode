package com.hx.arr;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author jxlgcmh
 * @date 2019-11-13 20:47
 * @description 数组的LeetCode算法题
 */
public class Array {
    public static void main(String[] args) {
        Array instance = new Array();
        int[] nums = {3, 2, Integer.MIN_VALUE};
        int target = 2;
        System.out.println(instance.thirdMaxII(nums));
    }


    /**
     * [1,1,2]  2
     * 2,2,1
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        boolean flag = true;
        int count = 0;
        for (int num : nums) {
            if (num == Integer.MIN_VALUE && flag) {
                count++;
                flag = false;
            }
            if (num > max1) {
                count++;
                //原先第二大传递给第三大
                max3 = max2;
                //原先最大值传递给第二大
                max2 = max1;
                //更新最大值
                max1 = num;
            } else if (num > max2 && num < max1) {
                count++;
                max3 = max2;
                max2 = num;
            } else if (num > max3 && num < max2) {
                count++;
                max3 = num;
            }
        }
        return count >= 3 ? max3 : max1;
    }


    /**
     * 第三大的数
     * @param nums
     * @return
     */
    public int thirdMaxII(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>first){
                third=second;
                second=first;
                first=nums[i];
            }
            if(nums[i]<first&&nums[i]>second){
                third=second;
                second=nums[i];
            }
            if(nums[i]<second&&nums[i]>third){
                third=nums[i];
            }
        }
        if(third==Integer.MIN_VALUE)
            return first;
        return third;

    }

    public int thirdMaxIII(int[] nums) {
        int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE,third=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>first){
                third=second;
                second=first;
                first=nums[i];
            }
            if(nums[i]<first&&nums[i]>second){
                third=second;
                second=nums[i];
            }
            if(nums[i]<second&&nums[i]>third){
                third=nums[i];
            }
        }
        if(third==Integer.MIN_VALUE)
            return first;
        return third;
    }

    /**
     * 数组中重复的数字，下标不能超过k值
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 是否存在重复元素
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 反转char型数组
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[len - 1 - i];
            s[len - 1 - i] = s[i];
            s[i] = temp;
        }
    }

    // 双指针的方式
    public void reverseStringII(char[] s) {
        if (s.length <= 1) {
            return;
        }
        int left = 0, right = s.length - 1;
        while (left <= right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    /**
     * 指定位置开始反转数组
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        for (int j = 0; j < k; j++) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }

    }


    /**
     * 股票买卖最佳时机I
     *
     * @param prices
     * @return
     */
    public int maxProfitI(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                if (temp > 0 && temp > res) {
                    res = temp;
                }
            }
        }
        return res;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易【你必须在再次购买前出售掉之前的股票】
     * <p>
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     *
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        int ans = 0;
        for (int i = 1; i <= prices.length - 1; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

    public int maxProfitIDp(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    /**
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
     * 双指针的方式
     *
     * @param arr 输入：[-4,-1,0,3,10]
     * @return 输出：[0,1,9,16,100]
     */
    public int[] sortedSquares(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (arr[l] * arr[l] > arr[r] * arr[r]) {
                res[i] = arr[l] * arr[l];
                l++;
            } else {
                res[i] = arr[r] * arr[r];
                r--;
            }
        }
        return res;
    }

    /**
     * 图像翻转
     *
     * @param arr
     * @return
     */
    public int[][] flipAndInvertImage(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            // 行        列
            int i = 0, j = arr[row].length - 1;
            while (i <= j) {
                // 暂存临时值
                int temp = arr[row][i];
                // 两个值交换位置
                arr[row][i] = (arr[row][j] + 1) % 2;
                arr[row][j] = (temp + 1) % 2;
                i++;
                j--;
            }
        }
        return arr;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        //定义两个指针变量，i用来往前探索，j用来保持<=j的数非零
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }


    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumII(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            while (numbers[left] + numbers[right] > target) {
                right--;
            }
            while (numbers[left] + numbers[right] < target) {
                left++;
            }
        }
        return result;
    }


    /**
     * 输入: ["2", "1", "+", "3", "*"]
     * 输出: 9
     * 解释: ((2 + 1) * 3) = 9
     * 逆波兰表达式求值
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        int[] queue = new int[tokens.length];
        int index = -1;
        for (String token : tokens) {
            ++index;
            switch (token) {
                case "+":
                    queue[index - 2] = queue[index - 2] + queue[index - 1];
                    index -= 2;
                    break;
                case "-":
                    queue[index - 2] = queue[index - 2] - queue[index - 1];
                    index -= 2;
                    break;
                case "*":

                    queue[index - 2] = queue[index - 2] * queue[index - 1];
                    index -= 2;
                    break;
                case "/":

                    queue[index - 2] = queue[index - 2] / queue[index - 1];
                    index -= 2;
                    break;
                default:
                    queue[index] = Integer.parseInt(token);
                    break;
            }
        }
        return queue[0];
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 交换律：a ^ b ^ c 等价于 a ^ c ^ b
     * <p>
     * 任何数于0异或为任何数 0 ^ n 等于 n
     * <p>
     * 相同的数异或为0: n ^ n 等于 0
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            //异或0001 ^ 0010 = 0011
            // 同为0，异为1
            num = num ^ nums[i];
        }
        return num;
    }


    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int sumLen = m + n - 1;
        int arr1Len = m - 1;
        int arr2Len = n - 1;
        // 根据题意:arr1Len >arr2Len,并且sumLen =arr1Len +arr2Len
        while (arr1Len >= 0 && arr2Len >= 0) {
            nums1[sumLen--] = nums1[arr1Len] > nums2[arr2Len] ? nums1[arr1Len--] : nums2[arr2Len--];
        }
        while (arr2Len >= 0) {
            nums1[sumLen--] = nums2[arr2Len--];
        }
    }


    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        return addOneAtPos(digits, digits.length - 1);
    }

    private int[] addOneAtPos(int[] num, int pos) {
        if (num[pos] != 9) {
            num[pos] += 1;
            return num;
        } else if (pos > 0) {
            num[pos] = 0;
            return addOneAtPos(num, pos - 1);
        } else {
            int length = num.length;
            int[] newNum = new int[length + 1];
            newNum[0] = 1;
            return newNum;
        }
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 穷举的方式
     *
     * @param nums {-2, 1, -3, 4, -1, 2, 1, -5, 4};
     * @return 6
     */
    public int maxSubArray(int[] nums) {
        int maxResult = nums[0];
        int tempSum = 0;
        for (int item : nums) {
            if (tempSum > 0) {
                tempSum += item;
            } else {
                tempSum = item;
            }
            maxResult = Math.max(maxResult, tempSum);
        }
        return maxResult;
    }

    /**
     * 动态规划的方式
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }


    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分的方式
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int middle;
        while (left <= right) {
            middle = (right + left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }


    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int count = 0;
        int firstIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                firstIndex = i;
            }
        }
        if (count == 0) {
            return new int[]{-1, -1};

        } else {
            return new int[]{firstIndex - count + 1, firstIndex};
        }

    }


    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        // 注意++条件的控制
        for (int i = 0; i < len; ) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
            } else {
                i++;
            }
        }
        return len;
    }


    /**
     * 删除排序数组中的重复项
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < len; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 最长公共前缀
     *
     * @param strs 字符串数组
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 假设字符数组的第一个元素为最长公共前缀
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 后边字符串出现的位子
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }

        }
        return prefix;
    }


    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int[] len = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.get(res) != null) {
                len[0] = map.get(res);
                len[1] = i;
                return len;
            }
            map.put(nums[i], i);
        }
        return len;
    }
}
