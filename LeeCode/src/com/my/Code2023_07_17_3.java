package com.my;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
*����һ��ֻ���������ַ����ַ�����֧�ֵ��ַ����ͷֱ��� '('��')' �� '*'�������������ַ����Ƿ�Ϊ��Ч�ַ������������Ч�ַ������� true ��
��Ч�ַ����������¹���
    �κ������� '(' ��������Ӧ�������� ')'��
    �κ������� ')' ��������Ӧ�������� '(' ��
    ������ '(' �����ڶ�Ӧ��������֮ǰ ')'��
    '*' ���Ա���Ϊ���������� ')' ���򵥸������� '(' ����һ�����ַ�����
    һ�����ַ���Ҳ����Ϊ��Ч�ַ�����
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
