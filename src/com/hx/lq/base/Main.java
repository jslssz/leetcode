package com.hx.lq.base;

import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-11-29 11:20
 * @description
 */
public class Main {
    public static void main(String[] args) {


        Main main =new Main();
        main.sort();

    }

    public void sort(){
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        for (int j=0;j<arr.length-1;j++){
            for (int k = 0; k < arr.length-j-1; k++) {
                if (arr[k]> arr[k+1]){
                    int temp =arr[k];
                    arr[k]=arr[k+1];
                    arr[k+1]=temp;
                }
            }
        }
        for (int index = 0; index < n; index++) {
            System.out.print(arr[index]+"\t");
        }

    }
}
