/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.排序;

import java.util.Arrays;

public class P324 {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] array = new int[len];
        System.arraycopy(nums, 0, array, 0, len);
        Arrays.sort(array);
        int count = 0;
        int left = len / 2 - 1;
        int right = left + 1;
        boolean flag = true;
        // StringBuilder sb = new StringBuilder();
        // sb.append(array[left]);
        nums[count] = array[left];
        while (left >= 0 && right < len && count < len){
            ++count;
            if (flag){
                // if (array[len - 1] <= array[left]){
                //
                // }
                while (right < len - 1 && array[right] == array[left]){
                    right++;
                }
                // sb.append(array[right]);
                if (array[right] > array[left]){
                    nums[count] = array[right];
                    left--;
                }
            }else {
                while (left >= 1 && array[left] == array[right]){
                    left--;
                }
                if (array[right] > array[left]){
                    nums[count] = array[left];
                    right++;
                }
                // sb.append(array[left]);
            }
            flag = !flag;
        }
    }
}
