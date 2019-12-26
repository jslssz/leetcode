package com.hx.other;

import java.util.ArrayList;

/**
 * @author jxlgcmh
 * @date 2019-12-03 10:40
 * @description
 */
public class Demo {
    public static void main(String[] args) {
        String classFile = "com.jd.". replaceAll("\\.", "/") + "MyClass.class";
        System.out.println(classFile);
    }
}
