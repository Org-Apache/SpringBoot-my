package com.my;
import java.util.*;

//3141
public class Code_2023_07_26_01 {
    public static void main(String[] args) {
        Code_2023_07_26_01 code_2023_07_26_01 = new Code_2023_07_26_01();
        int[] birth = {1900,1901,1950};
        int[] death = {1948,1951,2000};
        System.out.println(code_2023_07_26_01.maxAliveYear(birth,death));
    }
    public int maxAliveYear(int[] birth, int[] death) {
        Map<Integer,Integer> people = new LinkedHashMap<>();
        for(int year = 1900 ; year <= 2000 ;year ++){
            for(int i =0 ;i < birth.length ; i++){
                if(birth[i] <= year && death[i] >= year){
                   people.put(year,people.containsKey(year) ? people.get(year) + 1 : 1);
                }
            }
        }
        int year = 1900;
        int num = 0;
        for(Map.Entry<Integer, Integer> entry : people.entrySet()){
            if(entry.getValue() > num){
                num = entry.getValue();
                year = entry.getKey();
            }
        }
        return year;
    }
}

