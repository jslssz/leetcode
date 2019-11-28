package com.hx.dp;

/**
 * @author jxlgcmh
 * @date 2019-11-15 08:20
 * @description
 */
public class Dp {
    public static void main(String[] args) {

    }

    /**
     * 股票买卖最佳时机I 动态规划解题
     * @param prices
     * @return
     */
    public int maxProfitIDp(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            int temp = prices[i] - min;
            max = Math.max(max, temp);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    /**
     *  爬楼梯问题 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
}
