package com.hx.lq.t2019;

/**
 * @author jxlgcmh
 * @date 2019-11-29 18:52
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
       // main.getLast4II(20190324);
        System.out.println(main.getCount(2019));
    }

    public int getCount(int n){
        int count =0;
        int min=1;
        int max=2016;
        for (int i = 2; i < max; i++) {
            int temp = i + max + min;
            if (temp == n) {
                System.out.println("min="+min+"\ti="+i +"\tmax="+max );
                count++;
                max--;
                min =i;
            }
            if (temp > n) {
                max--;
                i--;
            }
            /*if (temp < n) {

            }*/
        }
        return count;
    }










    public void getLast4(int n) {
        int a = 1;
        int b = 1;
        int c = 1;
        int res = 0;
        for (int i = 4; i <= n; i++) {
            // 取模这一步必不可少
            res = (a + b + c) % 10000;
            a = b;
            b = c;
            c = res;
        }
        System.out.println(res);
    }

    public void getLast4II(int n) {
        long [] arr =new long[n+3];
        arr[0] =1 ;
        arr[1] =1 ;
        arr[2] =1 ;
        for (int i = 3; i < n; i++) {
            arr[i] = (arr[i-1]+arr[i-2]+arr[i-3])%10000;
        }
        System.out.println(arr[n-1]);
    }
}
