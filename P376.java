/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.排序;

/*
    属于暴力解法，stackover.
 */
public class P376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        return Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
    }

    private int calculate(int[] nums, int index, boolean isUp){
        int maxCount = 0;
        for (int i = index; i < nums.length - 1; i++){
            if ((isUp && nums[i] < nums[i + 1]) || (!isUp && nums[i] > nums[i+1])){
                maxCount = Math.max(maxCount, calculate(nums, index, !isUp));
            }
        }
        return maxCount;
    }

}
