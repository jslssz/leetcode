package com.hx.lq.t2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

/**
 * @author jxlgcmh
 * @date 2019-11-29 20:04
 * @description
 */
public class MiKong {
    public static int count =0;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\mikong.txt")));
        int[][] arr = new int[30][50];
        for (int i = 0; i < 30; i++) {
            String s = reader.readLine();
            if (s == null) {
                break;
            }
            for (int j = 0; j < 50; j++) {
                String substring = s.substring(j, j + 1);
                int temp = Integer.parseInt(substring);
                arr[i][j] = temp;
            }
        }
//        for (int i = 0; i < 30; i++) {
//            for (int j = 0; j < 50; j++) {
//                System.out.print(arr[i][j] + ",");
//            }
//            System.out.println();
//        }
        setWay(arr,0,0);
    }


    public static boolean setWay(int[][] map, int i, int j) {
        if (map[29][49] == 2) {
            System.out.println(count+1);
            return true;
        } else {
            if (map[i][j] == 0) {
                count++;
                map[i][j] = 2;
                //策略：下右上左
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
