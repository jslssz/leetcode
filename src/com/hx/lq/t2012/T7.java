package com.hx.lq.t2012;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @author jxlgcmh
 * @date 2019-12-13 19:35
 * @description
 */
public class T7 {
    public static void main(String[] args) {
        List<Integer> lst = new Vector<Integer>();
        lst.addAll(Arrays.asList(12, 127, 85, 66, 27, 34, 15, 344, 156, 344, 29, 47));
        System.out.println(max5(lst));
    }

    public static List<Integer> max5(List<Integer> lst) {
        if (lst.size() <= 5) {
            return lst;
        }
// 填空       int a = _______________________;
        int a = lst.remove(0);
        List<Integer> b = max5(lst);
        for (int i = 0; i < b.size(); i++) {
            int t = b.get(i);
            if (a > t) {
                // __________________;  // 填空
                Collections.replaceAll(b,t,a);
                a = t;
            }
        }
        return b;
    }
}
