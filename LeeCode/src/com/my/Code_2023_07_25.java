package com.my;
//12
public class Code_2023_07_25 {
    char[] charArr = {'I','V','X','L','C','D','M'};
    int[] numArr = {1,5,10,50,100,500,1000};
    public static void main(String[] args) {
        Code_2023_07_25 code = new Code_2023_07_25();
        System.out.println(code.intToRoman("3"));
    }

    public String intToRoman(String num) {
        int number = Integer.valueOf(num);
        StringBuilder s = new StringBuilder();
        while(number!=0){
            if(number == numArr[numArr.length - 1]){
                s.append(charArr[charArr.length - 1]);
                break;
            }
            for(int i = 0;i < numArr.length - 1;i++){
                if(numArr[i] == number){
                    s.append(charArr[i]);
                    number = number - numArr[i];
                    break;
                }
                if(numArr[i] < number && numArr[i+1] > number && numArr[i+1] != number){
                    if(number == (numArr[i+1] - numArr[i])){
                        s.append(charArr[i]+charArr[i+1]);
                        number = numArr[i+1] - numArr[i];
                        break;
                    }
                }
            }
        }
        return s.toString();
    }
}
