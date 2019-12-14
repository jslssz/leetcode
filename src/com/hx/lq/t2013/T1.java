package com.hx.lq.t2013;

/**
 * @author jxlgcmh
 * @date 2019-12-14 10:44
 * @description
 */
public class T1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        int count = 0;
        for (int i = 2000; ; i++) {
            if (t1.typeOfYear(i)) {
                count += 366;
            } else {
                count += 365;
            }
            if (count % 7 == 2 && i % 100 == 99) {
                System.out.println(i);
                break;
            }

        }
    }

    public boolean typeOfYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }
}
