package com.hx.lq.t2012;

/**
 * @author jxlgcmh
 * @date 2019-12-11 20:39
 * @description
 */
public class T2 {
    public static void main(String[] args) {
        for(int i=20;i>0;i--){
            for(int j=i-1;j>0;j--){
                for(int k=j-1;k>0;k--){
                    // 符点数比较\t这里误差定为小于0.0000001为成立
                    for(int m=k-1;m>0;m--){
                        if((Math.abs((1.0/i+1.0/j+1.0/k+1.0/m)-1))<0.0000001)
                            System.out.println(i+"\t"+j+"\t"+k+"\t"+m+"\t0");
                    }
                }
            }
        }
    }
}
