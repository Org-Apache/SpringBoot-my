package com.dt.str.study.method.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //��־�Ƿ���й�����
        boolean flag = false;
        int[] array = {3, 9, -1, 20, -2};
        for (int i = 0; i < array.length - 1; i++) {
            for( int j = i + 1; j < array.length ; j++){
                if (array[i] > array[j]) {
                    changeNum(array,i,j);
                    flag = true;
                }
            }
            if(!flag){
                //��һ�������У�һ������û�з��������ʾ��ʱ���ݾ��������
                break;
            }else{
                //����flag�������´��ж�
                flag = false;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void changeNum(int[] array ,int i ,int j){
        int a = array[i];
        array[i] = array[j];
        array[j] = a;
    }
}
