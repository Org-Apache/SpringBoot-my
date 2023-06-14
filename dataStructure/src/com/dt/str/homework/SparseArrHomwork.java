package com.dt.str.homework;

import java.io.*;

/*
* 在前面二维数组和稀疏数组相互转化的基础上，
* ①：将稀疏数组保持到磁盘上，比如map.daa
* ②：恢复原来的样子，读取map.data进行恢复
*
* */
public class SparseArrHomwork {

    private static final int ARRAY_SIZE =10;
    private static final String FILE_PATH = "F:/IO/map.data";
    public static void main(String[] args){
        //首先创建一个二维数组，大小为ARRAY_SIZE
        int[][] originArr = getOriginArr();
        //将二维数组转化为稀疏数组

        //先获取有效数字的个数，确定稀疏数组的行
        int sum = 0;
        for(int[] a: originArr){
            for(int data : a){
                if(data!=0){
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0]=ARRAY_SIZE;
        sparseArray[0][1]=ARRAY_SIZE;
        sparseArray[0][2]=sum;

        //将二维数组转化为稀疏数组
        executeSparseArray(sparseArray,originArr);

        //将稀疏数组存入磁盘
        System.out.println("将稀疏数组存入磁盘");
        try {
            saveSparseArray(sparseArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //从磁盘读取稀疏数组
        int[][] sparseArray2 = new int[0][];
        try {
            sparseArray2 = getSparseArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("从磁盘读取到的稀疏数组为：");

        printArr(sparseArray2);

        //将读取到的稀疏数组转化为二维数组
        int[][] cheseArr2 = getAfterArray(sparseArray2);
        System.out.println("读取到的稀疏数组转化为二维数组后：");
        printArr(cheseArr2);
    }

    private static int[][] getSparseArray()throws IOException {
        int[][] sparseArr = new int[ARRAY_SIZE][3];
        FileReader reader = new FileReader(FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String readLine = "";
        int lineNum = 0;
        while((readLine = bufferedReader.readLine())!=null){
            String[] infoArr = readLine.replace("\t", ",").split(",");
            if(lineNum==0){
                sparseArr = new int[Integer.valueOf(infoArr[2])+1][3];
            }
            sparseArr[lineNum][0]=Integer.valueOf(infoArr[0]);
            sparseArr[lineNum][1]=Integer.valueOf(infoArr[1]);
            sparseArr[lineNum][2]=Integer.valueOf(infoArr[2]);
            lineNum++;
        }
        return sparseArr;
    }

    private static void saveSparseArray(int[][] sparseArray) throws IOException {
        File file = new File(FILE_PATH);
        if(file.exists()){
            file.delete();
        }
        FileWriter fw = new FileWriter(FILE_PATH,true);
        for(int[] a : sparseArray){
            StringBuffer stringBuffer = new StringBuffer();
            for(int data : a){
                stringBuffer.append(data+"\t");
            }
            fw.write(stringBuffer.toString()+"\n");
        }
        fw.flush();
        fw.close();
    }

    private static int[][] getAfterArray(int[][] sparseArray){
        int[][] cheseArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i = 1;i<sparseArray.length;i++){
            cheseArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return cheseArr2;
    }

    private static void executeSparseArray(int[][] sparseArray,int[][] originArr){
        int count=0;
        for(int i=0;i<originArr.length;i++){
            for(int j=0;j<originArr[i].length;j++){
                if(originArr[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=originArr[i][j];
                }
            }
        }
        System.out.println("转化后的稀疏数组为：");
        printArr(sparseArray);
    }

    private static int[][] getOriginArr(){
        int[][] numArr = new int[ARRAY_SIZE][ARRAY_SIZE];
        numArr[0][3]=1;
        numArr[1][2]=2;
        numArr[1][3]=1;
        numArr[5][6]=2;
        System.out.println("创建的二维数组为：");
        printArr(numArr);
        return numArr;
    }

    private static void printArr(int[][] array){
        for(int[] a : array){
            for(int data : a){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
