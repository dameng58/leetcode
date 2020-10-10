/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.线性表;

public class P209 {
    public static void main(String[] args) {
        int result = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(result);
    }
    /*
        将双指针用到底
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        if (len == 0){
            return 0;
        }else if (len == 1){
            return nums[0] >= s ? 1 : 0;
        }
        int slow = 0;
        int quick = 0;
        int sum = 0;
        while (quick < len){
            sum += nums[quick];
            while (sum >= s){
                res = Math.min(res, (quick - slow + 1));
                sum -= nums[slow];
                ++slow;
            }
            quick++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
