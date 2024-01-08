package com.dt.str.study.method.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {8,3,2,1,7,6,7,10,4,5};
        int index;
        for(int i = 0; i < arr.length -1 ; i++){
            index = i;
            for(int j = i + 1 ;j < arr.length; j++){
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
           swap(arr,i,index);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr,int i ,int j){
        int a = arr[i];
        arr [i] = arr[j];
        arr[j] = a;
    }
}
