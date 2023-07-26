package com.my;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
*给你一个下标从 0 开始长度为 偶数 的整数数组 nums 。

只要 nums 不是 空数组，你就重复执行以下步骤：

    找到 nums 中的最小值，并删除它。
    找到 nums 中的最大值，并删除它。
    计算删除两数的平均值。

两数 a 和 b 的 平均值 为 (a + b) / 2 。

    比方说，2 和 3 的平均值是 (2 + 3) / 2 = 2.5 。

返回上述过程能得到的 不同 平均值的数目。

注意 ，如果最小值或者最大值有重复元素，可以删除任意一个。

*
* */
public class Code2023_07_17 {
    public static void main(String[] args) {
        Code2023_07_17 code2023_07_17 = new Code2023_07_17();
        int[] array = new int[]{1,100};
        System.out.println(code2023_07_17.distinctAverages(array));
    }

    public int distinctAverages(int[] nums) {
        //定义一个Set,用来存放两数之和，两数之和不同，平均数自然不同
        Set<Integer> dataDouble = new HashSet();
        if(nums.length > 0){
            //执行的次数
            int times = (nums.length/2)-1;
            for(int i = 0; i <= times; i++){
                //首先对数据进行排序
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
