package com.dt.str.study.method.sort;

import java.util.Arrays;

public class PopMethod {
    public static void main(String[] args) {
        int[] arr = {101,1,54,22,78,7,87,88,4,654,7,5,4,7};
        for(int i = 0; i < arr.length - 1 ; i++){
            for(int j = i + 1 ; j < arr.length ; j ++){
                if(arr[i]>arr[j]){
                    int a = arr[i];
                    arr[i] = arr[j];
                    arr[j] = a;                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
