package com.hx.ncccu.n2;

import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-12-01 14:29
 * @description
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x=input.nextInt();
        int y=input.nextInt();
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= max; i++) {
            if (i % x == 4 && i % y == 3 && i % 6 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
