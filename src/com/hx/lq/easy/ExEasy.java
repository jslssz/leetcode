package com.hx.lq.easy;

import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-11-29 10:39
 * @description
 */
public class ExEasy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long res = n*(n+1)/2;
        System.out.println(res);
    }

    public void getCycleArea() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        double area = Math.PI * num * num;
        System.out.printf("%.7f\n",area);
        System.out.println();
    }

    /**
     * 存在问题：加入n是1就会数组越界
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        // 注意这里必须加2
        int[] a = new int[num + 2];
        a[1] = 1;
        a[2] = 1;
        for (int i = 3; i <= num; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % 10007;
        }
        return a[n];
    }

    public int fibII(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return (fibII(n - 1) + fibII(n - 2)) % 1007;
    }
}
