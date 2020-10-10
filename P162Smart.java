/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.排序;

/*
    题目要求o（logN）,因此考虑二分法
    而且，可以根据题目的条件对本题进行手动分析，发现了该题目共分为3种情况
    1、上升
    2、下降
    3、有峰值
    因此可以根据这三种情况发现，只需要满足nums[i]>nums[i+1]既可满足该题目
 */
public class P162Smart {
    public int findPeakElement(int[] nums) {
        int left = 0;
        //需要-1
        int right = nums.length - 1;
        while (left < right){
            //不加left
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
