/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.排序;

import java.util.PriorityQueue;

/*
    最佳解法，时间on，空间o1
 */
public class P324Smart {
    class Solution {
        public void wiggleSort(int[] nums) {
            int mid = findKthLargest(nums, (nums.length + 1) / 2);
            int len = nums.length;
            int left = 0, right = len - 1;
            int i = 0;
            while (i <= right){
                if (nums[newIndex(i, len)] > mid){
                    swap(nums, newIndex(left, len), newIndex(i, len));
                    left++;
                    i++;
                }else if(nums[newIndex(i, len)] < mid){
                    swap(nums, newIndex(right, len), newIndex(i, len));
                    right--;
                }else{
                    i++;
                }
            }
        }

        private int findKthLargest(int[] nums, int k){
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
            for (int n : nums){
                heap.add(n);
                if (heap.size() > k) heap.poll();
            }
            return heap.poll();
        }

        private int newIndex(int index, int n){
            return (1 + 2 * index) % (n | 1);
        }

        private void swap(int[] nums, int left, int right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
}
