/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.线性表;

import java.util.HashMap;
import java.util.Map;

public class P11 {

    /*
        idea0:暴力
        idea1:算出权重，然后根据权重的优先级来算
     */
    public int maxArea(int[] height) {
        if (height.length <= 0){
            return 0;
        }
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;

    }

}
