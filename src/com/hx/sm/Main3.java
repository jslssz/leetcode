package com.hx.sm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jxlgcmh
 * @date 2019-12-10 17:09
 * @description
 */
public class Main3 {

    private static final char[] UPPER = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
    private static final char[] NUIT = {'拾','佰','仟','万','亿'};
    private static final char[] DIGIT = {'0','1','2','3','4','5','6','7','8','9'};
    private static final Map<Character, Character> mapU = new HashMap<>();
    private static final Map<Character, Character> mapD = new HashMap<>();
    private static final List<Character> listN = new ArrayList<>();

    static {
        for(int i=0; i<DIGIT.length; i++){
            mapU.put(DIGIT[i], UPPER[i]);
            mapD.put(UPPER[i], DIGIT[i]);
        }
        for(int i=0; i<NUIT.length; i++){
            listN.add(NUIT[i]);
        }
    }

    public String convertToDigit(String upper){
        long digit = 1L;  //倍数
        long result = 0L; //最终结果
        long pre = 0L;    //前一次转换后的数
        long w_radix = 1L;//基数（万）
        long y_radix = 1L;//基数（亿)
        int w = 0; //记录万出现的次数
        int y = 0; //记录亿出现的次数
        int z = 0; //记录连续出现单位的次数（数组NUIT中的单位）
        for(int i=upper.length()-1; i>=0; i--){
            if(mapD.containsKey(upper.charAt(i)) && upper.charAt(i) != UPPER[0]){
                result = digit * Long.parseLong(String.valueOf(mapD.get(upper.charAt(i)))) + pre;
                pre = result;
                digit = 1L; //重置倍数
                z = 0;  //重置z
            } else if(listN.contains(upper.charAt(i))){
                if((++z) == 2) { //形如“壹佰亿”，连续出现单位字符时，需重置倍数
                    digit = 1L;
                }

                if(upper.charAt(i) == NUIT[0]){
                    /* 当数字大于亿小于万亿时，需特殊处理  */
                    digit = (w ==1 && y == 1) ? digit*10L*y_radix : digit*10L*w_radix*y_radix;
                }
                else if(upper.charAt(i) == NUIT[1]){
                    digit = (w ==1 && y == 1) ? digit*100L*y_radix : digit*100L*w_radix*y_radix;
                }
                else if(upper.charAt(i) == NUIT[2]){
                    digit = (w ==1 && y == 1) ? digit*1000L*y_radix : digit*1000L*w_radix*y_radix;
                }
                else if(upper.charAt(i) == NUIT[3]){
                    digit = (w ==1 && y == 1) ? digit*10000L*y_radix : digit*10000L;
                    w_radix = 10000L;
                    ++w;
                }
                else if(upper.charAt(i) == NUIT[4]){
                    digit *= 100000000L;
                    y_radix = 100000000L;
                    ++y;
                }
            }
        }
        return String.valueOf(result);
    }
}
