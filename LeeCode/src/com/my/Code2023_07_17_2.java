package com.my;

import java.util.Scanner;

/*
*��дһ��������������һ���޷����������Զ����ƴ�����ʽ��������������Ʊ��ʽ������λ��Ϊ '1' �ĸ�����Ҳ����Ϊ ��������).����
��ʾ��
    ��ע�⣬��ĳЩ���ԣ��� Java���У�û���޷����������͡�����������£���������������ָ��Ϊ�з����������ͣ����Ҳ�ӦӰ������ʵ�֣���Ϊ�����������з��ŵĻ����޷��ŵģ����ڲ��Ķ����Ʊ�ʾ��ʽ������ͬ�ġ�
    �� Java �У�������ʹ�� �����Ʋ��� �Ƿ�����ʾ�з�����������ˣ�������� ʾ�� 3 �У������ʾ�з������� -3��
*
* */
public class Code2023_07_17_2 {
    public static void main(String[] args) {
        Code2023_07_17_2 code2023_07_17_2 = new Code2023_07_17_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(code2023_07_17_2.hammingWeight(n));
    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
