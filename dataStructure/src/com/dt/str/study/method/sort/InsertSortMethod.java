package com.dt.str.study.method.sort;

import java.util.Arrays;

public class InsertSortMethod {

    public static void main(String[] args) {
        int arr[] = {8, 3, 2, 1, 7, 6, 7, 10, 4, 5};
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0&&arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void swap(int[] arr,int i ,int j){
        int a = arr[i];
        arr [i] = arr[j];
        arr[j] = a;
    }
}
