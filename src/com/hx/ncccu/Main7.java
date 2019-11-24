package com.hx.ncccu;

import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-11-17 14:27
 * @description
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m,n;
        m=input.nextInt();
        n=input.nextInt();
        int count =0;
        for (int i = m; i <=n; i++) {
            for (int j =2 ; j <=i-1 ; j++) {
                if (i%2 !=0){
                    if ( i % j == 0) {
                        count++;
                        break;
                    }
                }else {
                    break;
                }

            }
        }
        System.out.println(count);
    }
}
