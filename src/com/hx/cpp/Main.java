package com.hx.cpp;

import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-11-30 23:17
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n=scanner.nextInt();
            System.out.print((char)n);
        }
    }
}
