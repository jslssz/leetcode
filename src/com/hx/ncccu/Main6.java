package com.hx.ncccu;

import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-11-17 14:13
 * @description
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int count =0;
        for (int i = 1; i <= n; i++) {
            if ((int) Math.pow(i, 3) <= n) {
                count++;
            }else {
                break;
            }
        }
        System.out.println(count);
    }
}
