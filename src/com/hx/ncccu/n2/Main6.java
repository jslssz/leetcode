package com.hx.ncccu.n2;

import javax.swing.*;
import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-12-01 15:19
 * @description
 */
public class Main6 {
    public static void main(String[] args) {
        int[] a = {0, 10, 100, 1000, 10000, 100000};
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int n = input.nextInt();
        int k = input.nextInt();
        long y, record;
        while (num-- >= 0) {
            int count = 0, i;
            record = n % a[k];
            y = record;
            for (i = 2; i <= a[k]; i++) {
                count++;
                y = y * n % a[k];
                if (record == y) {
                    break;
                }
            }
            if (i - 1 == a[k]) {
                System.out.printf("-1\n");
            } else {
                System.out.printf("%d\n", count);
            }
        }
    }
}
