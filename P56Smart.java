/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P56Smart {
    public int[][] merge(int[][] intervals) {
        //重要的第零点来了，List可以这样定义
        List<int[]> result = new ArrayList<>();
        int len = intervals.length;
        if (len <= 1){
            return intervals;
        }
        //重要的第一点来了，二维数组可以利用lambda来排序
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int i = 0;
        while (i < len){
            int left = intervals[i][0];
            int right = intervals[i][1];
            //重要的第二点来了，一个while循环，可以取到合并的最大，而不是俩个俩个合并
            while (i < len - 1 && right >= intervals[i + 1][0]){
                ++i;
                right = Math.max(right, intervals[i][1]);
            }
            result.add(new int[]{left, right});
            ++i;
        }
        //重要的第三点来了，将List<int[]> 转为 int[][]
        return result.toArray(new int[0][]);
    }
}
