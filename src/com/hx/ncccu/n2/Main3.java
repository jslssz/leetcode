package com.hx.ncccu.n2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-12-01 14:41
 * @description
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        List<List<Object>> lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Object> list =new ArrayList<>();
            while (input.hasNext()) {
                int temp =input.nextInt();
                if (temp == -1) {
                    break;
                }
                list.add(temp);
            }
            lists.add(list);
        }
        // 重量
        List<Object> weights = lists.get(lists.size() - 1);
        double count =0;
        double tempSum=0;
        for (int i = 0; i < lists.size()-1; i++) {
            List<Object> list = lists.get(0);
            // 价格
            double price = (double)list.get(1);
            int weight = (int)list.get(2);
            int realWeight=(int)weights.get(i);
            if (realWeight < weight) {
                tempSum = price*realWeight;
            }
            if (realWeight > weight) {
                if (list.size()>4){
                     price = price *realWeight*(int)list.get(2);
                }
            }
            count+=tempSum;
        }
        System.out.println(count);
    }
}
