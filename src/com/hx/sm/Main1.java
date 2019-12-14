package com.hx.sm;

/**
 * @author jxlgcmh
 * @date 2019-12-10 16:57
 * @description
 */
public class Main1 {


    public int[] merge(int a[], int b[]) {
        int result[];
        result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        while (i < a.length)
            result[k++] = a[i++];
        while (j < b.length)
            result[k++] = b[j++];
        return result;
    }
}
