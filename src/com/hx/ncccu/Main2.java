package com.hx.ncccu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jxlgcmh
 * @data 2019-11-12 12:38
 */
public class Main2 {
    /**
     * 4x+6y=m;
     * 3x+5y=n;
     */
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int m,n,x,y;
//        m=input.nextInt();
//        n=input.nextInt();
//        y=(3*m-4*n)/(3*6-4*5);
//        x=(n-5*y)/3;
//        System.out.println(x+"   "+y);
//        int count =0;
//        int n =input.nextInt();
//        int [] arr =new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = input.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                if (arr[i] > arr[j]) {
//                    count++;
//                }else {
//                    break;
//                }
//            }
//        }
//        System.out.println(count);
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        int n1=1;
        int n2=2;
        int [] tree1 =new int[50];
        for (int i = 0; i < 50; i++) {
            tree1[i]=n1;
            n1+=2;
        }
        int [] tree2 =new int[50];
        for (int i = 0; i < 50; i++) {
            tree2[i]=n2;
            n2+=2;
        }
        int [] arr =new int[in];
        for (int i = 0; i < in; i++) {
            arr[i] = input.nextInt();
        }
        int temp1 =0;
        int sum1 =0;
        int temp2 =0;
        int sum2 =0;
        int start1 =0;
        int start2 =0;
        Arrays.sort(arr);
        for (int item : arr) {
            // tree1
            if (item % 2 == 1) {
                tree1[item % 2] =0;
            }
            // tree2
            else {
                tree2[item % 2] =0;
            }
        }

        for (int i = 0; i < 50; i++) {
            if (tree1[i] != 0) {
                sum1++;
            }else {
                start1 =i;
                if (temp1 < sum1) {
                    temp1 =sum1;
                }
                sum1 =0;
            }
        }
        for (int i = 0; i < 50; i++) {
            if (tree2[i] != 0) {
                sum2++;
            }else {
                start2 =i;
                if (temp2 < sum2) {
                    temp2 =sum2;
                }
                sum2 =0;
            }
        }
        if (sum1 > sum2) {
            System.out.println(start1+ " "+ sum1);
        }else {
            System.out.println(start2+ " "+ sum2);
        }

        input.close();
    }
}
