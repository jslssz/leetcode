package com.hx.other;

import java.util.ArrayList;

/**
 * @author jxlgcmh
 * @date 2019-12-03 10:40
 * @description
 */
public class Demo {

    public static void main(String args[]){
        Demo demo = new Demo();
        demo.first();
    }

    public void first( ){
        int i=5;
        Value v=new Value( );
        v.i=25;
        second(v,i);
        System.out.println(v.i);
    }

    public void second(Value v,int i){
        i = 0;
        v.i = 20;
        Value val = new Value( );
        v = val;
        System.out.println(v.i+" "+i);
    }
}
class Value{
    public int i=15;
}
