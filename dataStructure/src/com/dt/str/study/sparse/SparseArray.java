package com.dt.str.study.sparse;

/*
* 学习二维数组和稀疏数组之间的转化
* */
public class SparseArray {
    public static void main(String[] args) {
        //首先创建一个11×11的原始二维数组
        //0表示没有棋子，1表示黑子，2表示篮子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组为：");
        for(int[] a : chessArr1){
            for(int data : a){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转化为稀疏数组
        //先遍历，获取有效数字(非0)的个数
        int sum = 0;
        for(int[] a : chessArr1){
            for(int data : a){
                if(data!=0){
                    sum++;
                }
            }
        }

        //定义一个sum+1行，3列的数组，用来充当稀疏数组
        int[][] sparseArr = new int[sum+1][3];

        //给稀疏数组赋值,先赋值第一行
        sparseArr[0][0]  = 11;
        sparseArr[0][1]  = 11;
        sparseArr[0][2]  = sum;

        //遍历二维数组，将非0的值放到稀疏数组中
        //用来记录是第几个非零的数组
        int count = 0;
        for(int i = 0;i<chessArr1.length;i++){
            for(int j = 0;j<chessArr1[i].length;j++){
                 if(chessArr1[i][j]!=0){
                     count++;
                     sparseArr[count][0] = i;
                     sparseArr[count][1] = j;
                     sparseArr[count][2] = chessArr1[i][j];
                 }
            }
        }
        //输出稀疏的数组的值
        System.out.println("输出稀疏数组");
        for(int[] a :sparseArr){
            for(int data : a){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将稀疏数组恢复为二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i = 1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("恢复后的二维数组：");
        for(int[] a : chessArr2){
            for (int data : a){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


    }
}
