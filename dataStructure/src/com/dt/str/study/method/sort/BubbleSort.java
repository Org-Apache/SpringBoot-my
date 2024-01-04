package com.dt.str.study.method.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //标志是否进行过交换
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
                //在一趟排序中，一次排序都没有发生，则表示此时数据就是有序的
                break;
            }else{
                //重置flag，进行下次判断
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
