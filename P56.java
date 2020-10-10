/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.排序;

import java.util.Arrays;

/*
    行吧，暴力可以解，但是最后一个测试用例没过，为什么呢？
    因为最后一个测试用例有28377个区间，时间超时了。
 */
public class P56 {

    private void p56Sort(int[][] intervals){
        int len = intervals.length;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len - 1 - i; j++){
                if (intervals[j][0] > intervals[j + 1][0]){
                    swap(intervals, j, j + 1);
                }
            }
        }
    }

    private void swap(int[][] intervals, int index1, int index2){
        int[] temp = intervals[index1];
        intervals[index1] = intervals[index2];
        intervals[index2] = temp;
    }

    public int[][] merge(int[][] intervals) {
        int[][] result = merge2(intervals);
        while (!endOfWhile(result)){
            result = merge(result);
        }
        return result;
    }

    private boolean endOfWhile(int[][] intervals){
        for (int i = 0; i < intervals.length - 1; i++){
            if (intervals[i][1] < intervals[i + 1][0]){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    public int[][] merge2(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1){
            return intervals;
        }
        // Arrays.sort()只适用于一维数组
        // Arrays.sort(intervals);
        p56Sort(intervals);
        int[][] result = new int[len][intervals[0].length];
        boolean[] flag = new boolean[len];
        Arrays.fill(flag, true);
        int count = -1;
        for(int i = 0; i < len - 1; i++){
            //这里是>=，而不是>
            //这里是<=，而不是<,是为了去除重复
            if (flag[i + 1] && intervals[i][1] >= intervals[i + 1][0] && intervals[i][1] <= intervals[i + 1][1]){
                result[++count] = new int[]{intervals[i][0], intervals[i + 1][1]};
                flag[i + 1] = false;
            }else if (flag[i + 1] && intervals[i][0] <= intervals[i + 1][0] && intervals[i][1] >= intervals[i + 1][1]){
                result[++count] = new int[]{intervals[i][0], intervals[i][1]};
                flag[i + 1] = false;
            }else if (flag[i]){
                result[++count] = intervals[i];
            }else {
                continue;
            }
        }
        //判断最后一个
        if (flag[len - 1]){
            result[++count] = intervals[len - 1];
        }
        //
        // return result;
        //最后这里处理：是为了去除后面为空的
        int[][] resultFormat = new int[count + 1][intervals[0].length];
        System.arraycopy(result, 0, resultFormat, 0, count + 1);
        return resultFormat;
    }

    public static void main(String[] args) {
        // int[][] data = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // int[][] data = {{1, 4}, {0, 4}};
        // int[][] data = {{1, 4}, {2, 3}};
        //[[1,4],[0,2],[3,5]]，这种情况还要二次合并
        int[][] data = {{1, 4}, {2, 3}};
        int[][] result = new P56().merge(data);

    }

}
