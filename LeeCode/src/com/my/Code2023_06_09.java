package com.my;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
*
*����һ���������� nums ��һ������Ŀ��ֵ target�������ڸ��������ҳ� ��ΪĿ��ֵ target  ���� ���� ���������������ǵ������±ꡣ
*����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ���ڴ��ﲻ���ظ����֡�
*����԰�����˳�򷵻ش𰸡�
* */
public class Code2023_06_09 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums==null || nums.length==0){
            return result;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(map.containsKey(temp)){
                result[0] = map.get(temp);
                result[1] = i;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
