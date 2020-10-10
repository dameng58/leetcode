/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.线性表;

public class P724 {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        if(len <= 2){
            return -1;
        }
        int rightSum = 0;
        for(int num : nums){
            rightSum += num;
        }
        int leftSum = 0;
        for(int i = 0; i < len; i++){
            if(i != 0){
                leftSum += nums[i - 1];
            }
            rightSum -= nums[i];
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;

    }
}
