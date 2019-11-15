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
        Array array = new Array();
        // System.out.println(array.isPalindrome(1));
        int[] nums = {7, 8, 9};
        int target = 11;
//        int[] result = array.twoSum(nums, target);
//        System.out.println(result[0] + "  " + result[1]);

//        String[] longarr = {"flower", "flow", "flight"};
//        System.out.println(array.longestCommonPrefix(longarr));

//        System.out.println(array.removeElement(nums, target));

//        System.out.println(Arrays.toString(array.searchRange(nums, target)));
//        System.out.println(array.searchInsert(nums, target));
//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(array.maxSubArray(arr));

        int[] arr2 = {9, 9, 9};
        System.out.println(Arrays.toString(array.plusOne(arr2)));

    }

    /**
     *  给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *  初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
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
        while (arr1Len >= 0 && arr2Len >= 0){
            nums1[sumLen--] = nums1[arr1Len] > nums2[arr2Len] ? nums1[arr1Len--] : nums2[arr2Len--];
        }
        while (arr2Len >= 0){
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
