package com.hx.simulation;

/**
 * @author jxlgcmh
 * @date 2019-12-28 14:57
 * @description 是模拟面试的题
 */
public class Simulation {
    public static void main(String[] args) {
        int[] A = {2,3,1,1,4,0,0,4,3,3};
        Simulation simulation = new Simulation();
        simulation.sortArrayByParityII(A);
    }

    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     * 你可以返回任何满足上述条件的数组作为答案。
     *
     * @param A
     * @return
     * 输入：[4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     * [2,3,1,1,4,0,0,4,3,3]
     * res=[2,3,0,1,4,1,0,3,4,3]
     */

    public int[] sortArrayByParityII(int[] A) {
        int head = 0;
        int rear = A.length - 1;
        while (head < rear) {
            // 值和坐标同时为偶数
            while (head <=A.length-1 && A[head] % 2 == 0 && head % 2 == 0) {
                head++;
            }
            //  值和坐标同时为偶数
            while (head <=A.length-1 && A[head] % 2 == 1 && head % 2 == 1) {
                head++;
                while (head <=A.length-1 && A[head] % 2 == 0 && head % 2 == 0) {
                    head++;
                }
            }
            //此时A[head] 必定是奇数 head为偶数


            //  值和坐标同时为奇数
            while (rear >=0 && A[rear] % 2 == 1 && rear % 2 == 1) {
                rear--;
            }
            while (rear >=0 && A[rear] % 2 == 0 && rear % 2 == 0) {
                rear--;
                while (rear >=0 && A[rear] % 2 == 1 && rear % 2 == 1) {
                    rear--;
                }
            }
            // //此时A[rear] 必定是奇数 rear为偶数

            if (head < rear) {
                int temp = A[head];
                A[head] = A[rear];
                A[rear] = temp;
            }
            if (A[head] % 2 ==0  && head%2 ==0) head++;
            if (A[rear] % 2 ==1  && rear%2 ==1) rear--;
        }
        return A;
    }


}
