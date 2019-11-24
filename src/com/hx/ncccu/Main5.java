package com.hx.ncccu;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author jxlgcmh
 * @data 2019-11-12 12:43
 */
public class Main5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        TreeSet<String> treeSet = new TreeSet<>(String::compareToIgnoreCase);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            treeSet.add(input.next());
        }
        treeSet.forEach(System.out::println);
        input.close();
    }
}