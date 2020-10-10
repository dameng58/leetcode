/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.排序;

public class P162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len <= 1){
            return 0;
        }
        if (len == 2){
            return nums[0] > nums[1] ? 0 : nums[0] < nums[1] ? 1 : -1;
        }
        for (int i = 0; i < len; i++){
            if (i == 0 && nums[i] > nums[i + 1]){
                return i;
            }else if (i == len - 1 && nums[i] > nums[i - 1]){
                return i;
            }else if (i != 0 && i != len - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                return i;
            }
        }
        return -1;
    }
}
