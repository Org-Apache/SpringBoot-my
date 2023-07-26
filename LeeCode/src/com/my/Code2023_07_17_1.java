package com.my;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
*����һ���±�� 0 ��ʼ����Ϊ ż�� ���������� nums ��

ֻҪ nums ���� �����飬����ظ�ִ�����²��裺

    �ҵ� nums �е���Сֵ����ɾ������
    �ҵ� nums �е����ֵ����ɾ������
    ����ɾ��������ƽ��ֵ��

���� a �� b �� ƽ��ֵ Ϊ (a + b) / 2 ��

    �ȷ�˵��2 �� 3 ��ƽ��ֵ�� (2 + 3) / 2 = 2.5 ��

�������������ܵõ��� ��ͬ ƽ��ֵ����Ŀ��

ע�� �������Сֵ�������ֵ���ظ�Ԫ�أ�����ɾ������һ����

*
* */
public class Code2023_07_17 {
    public static void main(String[] args) {
        Code2023_07_17 code2023_07_17 = new Code2023_07_17();
        int[] array = new int[]{1,100};
        System.out.println(code2023_07_17.distinctAverages(array));
    }

    public int distinctAverages(int[] nums) {
        //����һ��Set,�����������֮�ͣ�����֮�Ͳ�ͬ��ƽ������Ȼ��ͬ
        Set<Integer> dataDouble = new HashSet();
        if(nums.length > 0){
            //ִ�еĴ���
            int times = (nums.length/2)-1;
            for(int i = 0; i <= times; i++){
                //���ȶ����ݽ�������
                if(i == 0){
                    Arrays.sort(nums);
                }

                dataDouble.add(nums[0] + nums[nums.length - 1]);
                nums = Arrays.copyOfRange(nums,1,nums.length - 1);
            }
        }
        return dataDouble.size();
    }
}
