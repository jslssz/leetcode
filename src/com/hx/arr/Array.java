package com.hx.arr;

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
/*        int[] nums = {7, 11, 15, 2};
        int target = 9;
        int[] result = array.twoSum(nums, target);
        System.out.println(result[0] + "  " + result[1]);*/

        String[] longarr = {"flower", "flow", "flight"};
        System.out.println(array.longestCommonPrefix(longarr));

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
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.get(res) != null) {
                ans[0] = map.get(res);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
