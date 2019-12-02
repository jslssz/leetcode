package com.hx.ncccu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-11-17 14:46
 * @description
 */
public class Main9 {
    public static void main(String[] args) {
        Main9 main9 = new Main9();
        int[] array = {1,3,5,9,6,8,7,2,4};
        main9.sanAdd(array,15);
    }

    /**
     * 三个数相加等于目标数
     * @param array
     * @param target
     */
    private void sanAdd(int[] array,int target){

        if(array == null){
            return;
        }
        //排序
        quickSort(array);

        //三个数相加等于target
        sanshu(array,target);

    }

    /**
     * 快排
     * @param array
     */
    private void quickSort(int[] array){
        int high = array.length-1,low=0;
        subSort(array,high,low);
        for(int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    private int getMiddle(int[] array,int high,int low){

        int key = array[low];
        while (low < high) {
            while (low < high && array[high] >= key){
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= key){
                low++;
            }
            array[high] = array[low];
        }
        array[low] = key;
        return low;
    }

    private void subSort(int[] array,int high,int low){
        if(low>high){
            return;
        }
        int result = getMiddle(array, high, low);
        subSort(array,result - 1,low);
        subSort(array, high,result + 1);
    }

    private void sanshu(int[] array,int target){

        int i = 0,j,k;

        for(i = 0,j=i+1,k = array.length-1; i < array.length && j<array.length && k>=0;){

            int sum = array[i]+array[j]+array[k];

            if(sum < target){
                j++;
            }else if(sum > target){
                k--;
            }else {
                System.out.println("三个数为：i,j,k:"+array[i]+","+array[j]+","+array[k]);
                j++;
            }
            if(j==k){
                //进入i的大循环
                i++;
                j=i+1;
                k = array.length-1;
            }

        }
    }

}
