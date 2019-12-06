package com.hx.other;

/**
 * @author jxlgcmh
 * @date 2019-12-03 10:40
 * @description
 */
public class Demo {
    public static void main(String[] args) {
        int count=0;
        int sum =0;
        for (int i = 0; i <= 100; i++) {
            count+=i;
            sum=sum++;

        }
        System.out.println(count*sum);
    }


}
