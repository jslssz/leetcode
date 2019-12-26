package com.hx.other;

/**
 * @author jxlgcmh
 * @date 2019-12-18 21:39
 * @description
 */
public class EnumOne {
    public static void main(String[] args) {
        System.out.println(AccountType.Saving);
    }
}

/**
 * 枚举账户类
 */
enum AccountType{
    /**
     * 存
     */
    Saving,
    /**
     * 维修
     */
    Fixed,
    /**
     * 固定
     */
    Current;
    private AccountType(){
        System.out.println("hello enum");
    }
}
