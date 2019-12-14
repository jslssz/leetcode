package com.hx.lq.t2012;

/**
 * 
 * @author jxlgcmh
 * @date 2019-12-13 17:23
 * @description
 * 
 * 某电视台举办了低碳生活大奖赛。题目的计分规则相当奇怪：
 * 每位选手需要回答10个问题（其编号为1到10），越后面越有难度。答对的，当前分数翻倍；答错了则扣掉与题号相同的分数（选手必须回答问题，不回答按错误处理）。
 * 每位选手都有一个起步的分数为10分。
 * 某获胜选手最终得分刚好是100分，如果不让你看比赛过程，你能推断出他（她）哪个题目答对了，哪个题目答错了吗？
 * 如果把答对的记为1，答错的记为0，则10个题目的回答情况可以用仅含有1和0的串来表示。例如：0010110011 就是可能的情况。
 */
public class T4 {
    public static void main(String[] args) {
        for (int i = 0; i < 1024; i++) {
            // 将对应的i值转化为对应的字符串
            String str = Integer.toBinaryString(i);
            str = cal(str);
            int sum = add(str);
            if (sum == 100) {
                System.out.println(str);
            }
        }
    }

    /**
     * 计算字符串的和
     * @param str
     * @return
     */
    private static int add(String str) {
        int sum = 10;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                sum *= 2;
            } else if (str.charAt(i) == '0') {
                sum -= (i + 1);
            }
        }
        return sum;
    }

    /**
     * 长度不足10位的补零
     * @param str
     * @return
     */
    private static String cal(String str) {
        if (str.length() < 10) {
            StringBuilder sb = new StringBuilder(10);
            sb.append(str);
            int n = 10 - str.length();
            while (n > 0) {
                sb.insert(0, '0');
                n--;
            }
            return sb.toString();
        }
        return str;
    }
}