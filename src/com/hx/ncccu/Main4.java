package com.hx.ncccu;

import java.util.Scanner;

/**
 * @author jxlgcmh
 * @data 2019-11-12 13:42
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m;
        n = in.nextInt();
        m = in.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int Max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // 以行为单位，求出相邻3位的最大值
            for (int j = 0; j < m - 2; j++) {
                int sum = 0;
                for (int k = j; k < 3 + j; k++) {
                    sum += matrix[i][k];
                }
                Max = Math.max(Max, sum);
            }
            // 以列为单位，求出相邻3位的最大值
            for (int j = 0; j < m - 2; j++) {
                int sum = 0;
                for (int k = j; k < 3 + j; k++) {
                    sum += matrix[k][i];
                }
                Max = Math.max(Max, sum);
            }
        }
        System.out.println(Max);
        in.close();
    }
}

