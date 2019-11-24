package com.hx.ncccu;

/**
 *  求素数
 * @author jxlgcmh
 * @date 2019-10-11 10:25
 */
public class Main1 {
    /**
     *   求1到100之间的素数
     *   素数：除了1和它本身之外，不能被其他的数整除
     */
    public static void main(String[] args) {
        System.out.println(getPrimeCount(12));
    }

    /**
     *
     * @param n  从开始，包括n本身
     * @return 返回结果
     */
    public static int getPrimeCount(int n) {
        int count =0;
        boolean flag;
        for (int i = 2; i <=n; i++) {
            flag =true;
            for (int j =2 ; j <i-1 ; j++) {
                if (i % j == 0) {
                    flag =false;
                    break;
                }
            }
            if (flag) {
                count ++;
            }
        }
        return count;
    }
}
