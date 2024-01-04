package com.my;

public class Code2023_07_23_01 {

    public static void main(String[] args) {
        Code2023_07_23_01 c = new Code2023_07_23_01();
        System.out.println(c.checkRecord("LALL"));
    }

    public boolean checkRecord(String s) {
        if(s.equals("AA")||s.equals("LLL")){
            return false;
        }
        String originString  = s ;
        int length1 = s.length();
        s = s.replace("A","");
        int length2 = s.length();
        if(length1 - length2 >= 2){
            return false;
        }
        s = originString.replace("LLL","");
        if(length1 != s.length()){
            return false;
        }
        return true;
    }
}
