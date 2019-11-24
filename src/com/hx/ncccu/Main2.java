package com.hx.ncccu;

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
        Scanner input = new Scanner(System.in);
        int m,n,x,y;
        m=input.nextInt();
        n=input.nextInt();
        y=(3*m-4*n)/(3*6-4*5);
        x=(n-5*y)/3;
        System.out.println(x+"   "+y);
        input.close();
    }
}
