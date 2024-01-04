package com.my;

public class Code2023_07_25 {
    private int[] defaultArr = {0,1,1};
    public static void main(String[] args) {
        Code2023_07_25 code2023_07_25 = new Code2023_07_25();
        System.out.println(code2023_07_25.tribonacci(25));
    }

    public int tribonacci(int n) {
        if(n<3){
            return defaultArr[n];
        }
        int a = defaultArr[0];
        int b = defaultArr[1];
        int c = defaultArr[2];
        int result = 0;
        for(int index = 3 ; index <= n ;index ++){
            result = a + b + c;
            a = b;
            b = c;
            c = result;
        }
        return result;
    }

}
