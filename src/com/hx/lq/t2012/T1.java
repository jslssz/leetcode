package com.hx.lq.t2012;

/**
 * @author jxlgcmh
 * @date 2019-12-10 23:54
 * @description
 */
public class T1 {
    public static void main(String[] args) {
        int []arr =new int[100];
        double res=0.618034;
        arr[0] =1;
        arr[1] =3;
        for (int i=2;i<100;i++){
            arr[i]=arr[i-1]+arr[i-2];
            System.out.println(arr[i]);
            double temp = arr[i-1]*1.0/arr[i];
            System.out.println(temp);
        }

    }
}
