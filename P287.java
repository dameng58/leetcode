/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.排序;

import java.util.Arrays;

public class P287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i + 1]){
                return nums[i];
            }
        }
        return -1;
    }
}
