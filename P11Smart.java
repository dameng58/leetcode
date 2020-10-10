/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.线性表;

public class P11Smart {
    /*
        经典双指针思路，有点意思
     */
    public int maxArea(int[] height) {

        int len = height.length;
        int lk = 0, rk = len - 1;
        int max = 0;
        while (lk < rk){
            max = Math.max(max, Math.min(height[lk], height[rk]) * (rk - lk));
            if (height[lk] > height[rk]){
                --rk;
            }else{
                ++lk;
            }
        }
        return max;
    }
}
