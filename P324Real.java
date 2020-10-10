/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.排序;

import java.util.Arrays;

public class P324Real {
    class Solution {

        /**
         * 先排序再穿插
         * O(nlogn)+O(n)=O(nlogn)
         * @param nums
         */
        public void wiggleSort(int[] nums) {
            int len = nums.length;
            int[] bak = Arrays.copyOf(nums, len);
            Arrays.sort(bak);
            int sStart = (len + 1) / 2;
            int bStart = len - 1;
            sStart--;
            for (int i = 0; i < len / 2; i++) {
                nums[2 * i] = bak[sStart--];
                nums[2 * i + 1] = bak[bStart--];

            }
            // 处理len(small) - len (big)=1;
            if (len % 2 != 0) {
                nums[len - 1] = bak[0];
            }
        }
    }
}
