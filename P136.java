/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.位运算;

public class P136 {
    class Solution {
        public int singleNumber(int[] nums) {
            for (int i = 1; i < nums.length; i++){
                nums[0] ^= nums[i];
            }
            return nums[0];
        }
    }
}
