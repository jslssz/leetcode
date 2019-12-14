package com.hx.lq.t2013;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-12-14 13:40
 * @description
 */
public class T8 {


/*
 * 幸运数
 幸运数是波兰数学家乌拉姆命名的。它采用与生成素数类似的“筛法”生成。
 首先从1开始写出自然数1,2,3,4,5,6,.... 1 就是第一个幸运数。 我们从2这个数开始。把所有序号能被2整除的项删除，变为：
 1 _ 3 _ 5 _ 7 _ 9 ....
 把它们缩紧，重新记序，为： 1 3 5 7 9 .... 。
 这时，3为第2个幸运数，然后把所有能被3整除的序号位置的数删去。
 注意，是序号位置，不是那个数本身能否被3整除!! 删除的应该是5，11, 17, ...
 此时7为第3个幸运数，然后再删去序号位置能被7整除的(19,39,...)
 最后剩下的序列类似：
 1, 3, 7, 9, 13, 15, 21, 25, 31, 33, 37, 43, 49, 51, 63, 67, 69, 73, 75, 79, ...
 本题要求：
 输入两个正整数m n, 用空格分开 (m < n < 1000*1000)程序输出 位于m和n之间的幸运数的个数（不包含m和n）。
 例如：
 用户输入：1  20
 程序输出：5
 例如：
 用户输入：30  69
 程序输出：8
 */


    static int count = 0, n, m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.close();

        LinkedList<Integer> link = new LinkedList<Integer>();
        link.add(0);
        // 这里用link集合存奇数就可以了
        for (int i = 1; i <= m; i += 2)
            link.add(i);

        findlukcy(link, 3, 3, 2);
        System.out.println(count);
    }

    // link是存取所有数的集合，order是标记下一个幸运数的位置，num就是那个幸运数，ass是一个“辅助数”
    private static void findlukcy(LinkedList<Integer> link, int order, int luckynum, int ass) {

        /*
         * ass：辅助作用，比如 1 3 5 7 9 11 13 15 17 19 21 23 .......
         * 题目说，3是第二个幸运数，那么i%3==0的话，那这个i的位置的数就被删除，那么所有数向前移动一位
         * 没有移动之前，i是：3，6，9，12.....的，正因为位置3的（link.remove(3)）被删了，所以，6，9，12...
         * 都变成了5，8，11；当这个时候的位置5被删了，8，11...变成7，10....位置7被删了，10变成9...
         * 在这里不难不发现，原本要被删除的是位置3，6，9，12，15....变成了3,5,7,9,11...
         * 幸运的时候，集合移动都是有规律的，这里的ass是luckynum-1。
         */

        int isfirst = 0;// 用于判断幸运数是否超出了m的范围，是0就超出了
        for (int i = 1; i < link.size(); i++) {
            if (i % luckynum == 0) {
                isfirst++;
                link.remove(i);
                luckynum += ass;
            }
        }

        if (order < link.size()) {
            luckynum = link.get(order);
            if (isfirst != 0)// 如果没有超出范围，那就继续找呀
                findlukcy(link, order + 1, luckynum, luckynum - 1);
                // 超出了，那么数一下有多少个
            else {
                for (int i = link.size() - 1; i > 0; i--) {
                    int aim = link.get(i);
                    if (aim > n && aim < m)
                        count++;
                    else if (aim <= n)
                        break;
                }
            }
        }
    }
}