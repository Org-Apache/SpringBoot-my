package com.my;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
*给你一个只包含三种字符的字符串，支持的字符类型分别是 '('、')' 和 '*'。请你检验这个字符串是否为有效字符串，如果是有效字符串返回 true 。
有效字符串符合如下规则：
    任何左括号 '(' 必须有相应的右括号 ')'。
    任何右括号 ')' 必须有相应的左括号 '(' 。
    左括号 '(' 必须在对应的右括号之前 ')'。
    '*' 可以被视为单个右括号 ')' ，或单个左括号 '(' ，或一个空字符串。
    一个空字符串也被视为有效字符串。
*
* */
public class Code2023_07_17_3 {
    public static void main(String[] args) {
        Code2023_07_17_3 code2023_07_17_3 = new Code2023_07_17_3();
        String s = "()*()())";
        System.out.println(code2023_07_17_3.checkValidString(s));
    }

    public boolean checkValidString(String s) {
        char[] chars = s.trim().toCharArray();

        if(chars.length > 0){
            int left = 0;
            int right = 0;
            for(int i = 0;i<chars.length;i++){
                if('('==chars[i]){
                    left++;
                    right++;
                }else if(')'==chars[i]){
                    left--;
                    right--;
                }else {
                    left++;
                    right--;
                }
            }
            if(right != 0){
                return false;
            }
        }
        return true;
    }
}
