package com.hx.ncccu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author jxlgcmh
 * @data 2019-11-12 12:41
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String obj_str = reader.readLine();
        System.out.println(str.indexOf(obj_str)+1);
    }
}
