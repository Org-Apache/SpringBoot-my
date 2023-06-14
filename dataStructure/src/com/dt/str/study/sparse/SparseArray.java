package com.dt.str.study.sparse;

/*
* ѧϰ��ά�����ϡ������֮���ת��
* */
public class SparseArray {
    public static void main(String[] args) {
        //���ȴ���һ��11��11��ԭʼ��ά����
        //0��ʾû�����ӣ�1��ʾ���ӣ�2��ʾ����
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //���ԭʼ�Ķ�ά����
        System.out.println("ԭʼ�Ķ�ά����Ϊ��");
        for(int[] a : chessArr1){
            for(int data : a){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //����ά����ת��Ϊϡ������
        //�ȱ�������ȡ��Ч����(��0)�ĸ���
        int sum = 0;
        for(int[] a : chessArr1){
            for(int data : a){
                if(data!=0){
                    sum++;
                }
            }
        }

        //����һ��sum+1�У�3�е����飬�����䵱ϡ������
        int[][] sparseArr = new int[sum+1][3];

        //��ϡ�����鸳ֵ,�ȸ�ֵ��һ��
        sparseArr[0][0]  = 11;
        sparseArr[0][1]  = 11;
        sparseArr[0][2]  = sum;

        //������ά���飬����0��ֵ�ŵ�ϡ��������
        //������¼�ǵڼ������������
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
        //���ϡ��������ֵ
        System.out.println("���ϡ������");
        for(int[] a :sparseArr){
            for(int data : a){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //��ϡ������ָ�Ϊ��ά����
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i = 1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("�ָ���Ķ�ά���飺");
        for(int[] a : chessArr2){
            for (int data : a){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


    }
}
