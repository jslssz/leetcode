package com.hx.lq.t2013;

import javax.sound.midi.Soundbank;

/**
 * @author jxlgcmh
 * @date 2019-12-14 12:08
 * @description
 */
public class T2 {
    public static void main(String[] args) {
        //答案142
        //假设 a b c d e 代表1~9不同的5个数字（注意是各不相同的数字，且不含0）
        /*
         * 此题注意abcde五个数互不相同并且从1-9
         */
        int num = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        for (int e = 1; e <= 9; e++) {
                            if (a != b && a != c && a != d && a != e &&
                                    b != c && b != d && b != e &&
                                    c != d && c != e &&
                                    d != e &&
                                    ((a * 10 + b) * (c * 100 + d * 10 + e)) == ((a * 100 + d * 10 + b) * (c * 10 + e))) {
                                num++;
                            }
                        }
                    }
                }
            }
        }
        System.out.print(num);
    }


    private static void fun1() {
        /**
         * ab * cde = adb * ce
         */
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int ab = arr[i] * 10 + arr[j];
                for (int k = 0; k < arr.length; k++) {
                    for (int l = 0; l < arr.length; l++) {
                        for (int m = 0; m < arr.length; m++) {
                            int cde = arr[k] * 100 + arr[l] * 10 + arr[m];
                            int sum1 = ab * cde;
                            int adb = arr[i] * 100 + arr[l] * 10 + arr[j];
                            int ce = arr[k] * 10 + arr[m];
                            int sum2 = adb * ce;
                            if (sum1 == sum2) {
                                count++;
                                System.out.println(ab + "*" + cde + "=" + adb + "*" + ce + "=" + sum1);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
