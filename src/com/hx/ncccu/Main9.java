package com.hx.ncccu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-11-17 14:46
 * @description
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nums, target;
        nums = input.nextInt();
        target = input.nextInt();
        int[] arr = new int[nums];
        for (int i = 0; i < nums; i++) {
            arr[i] = input.nextInt();
        }
        resolve(arr, target);
    }

    public static void resolve(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);
     //   Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; ++i) {
            int left = i + 1, right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum ==target){
                    System.out.println(i-2 +" "+(left-1)+" "+(right-1));
                    break;
                }

                int newDiff = Math.abs(sum - target);
                if (diff > newDiff) {
                    diff = newDiff;
                    closest = sum;
                }
                if (sum < target) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
    }

}
