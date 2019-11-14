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
        int[] nums = {7, 11, 11, 2,11,11};
        int target = 11;
//        int[] result = array.twoSum(nums, target);
//        System.out.println(result[0] + "  " + result[1]);

//        String[] longarr = {"flower", "flow", "flight"};
//        System.out.println(array.longestCommonPrefix(longarr));

        System.out.println(array.removeElement(nums, target));

    }

    /**
     *  给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        // 注意++条件的控制
        for (int i = 0; i < len;) {
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
     *  删除排序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
            int len=nums.length;
            if (len ==0) {
                return 0;
            }
            int i=0;
            for(int j=1;j<len;j++) {
                if (nums[i] !=nums[j]) {
                    i++;
                    nums[i]=nums[j];
                }
            }
            return i+1;
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
