package com.hx.sm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jxlgcmh
 * @date 2019-12-10 17:06
 * @description
 */
public class Main2 {
    public static void main(String[] args) {
        printResult("./input.txt" , "./keyword.conf");
    }

    public static void printResult(String inputPath, String keyword) {
        Set<String> conf = getKeyword(keyword);
        printResult(inputPath, conf);
    }

    private static void printResult(String inputFilePath, Set<String> keys) {
        try (FileInputStream inputStream = new FileInputStream(inputFilePath);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                for (String key : keys) {
                    if (str.split(" ")[0].contains(key)) {
                        System.out.println(str);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Set<String> getKeyword(String filePath) {
        Set<String> set = new HashSet<>();
        try (FileInputStream inputStream = new FileInputStream(filePath);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            while ((str = bufferedReader.readLine()) != null)
                set.add(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }
}
