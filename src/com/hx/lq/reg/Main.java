package com.hx.lq.reg;

/**
 * @author jxlgcmh
 * @date 2019-11-29 15:47
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getContainsII(40));
    }

    public int getContains(int n) {
        int res = 12;
        int tempVal = res;
        int[] arr = {2, 0, 1, 9};
        for (int i = 10; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                int pop = temp % 10;
                for (int item : arr) {
                    if (item == pop) {
                        res += i;
                        System.out.println(i);
                        break;
                    }
                }
                if (res == tempVal) {
                    temp /= 10;
                } else {
                    tempVal = res;
                    break;
                }
            }
        }
        return res;
    }

    public int getContainsII(int n) {
        int ans = 12;
        for (int i = 10; i <= n; ++i) {
            int t = i;
            boolean ok = false;
            while (t > 0) {
                int g = t % 10;
                if (g == 2 || g == 0 || g == 1 || g == 9) {
                    ok = true;
                    break;
                }
                t = t / 10;
            }
            if (ok) {
                ans += i;
            }
        }
        return ans;
    }
}
